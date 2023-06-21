package pro.dagen.creditCard;

import lombok.extern.log4j.Log4j2;
import pro.dagen.AbstractGenerator;
import pro.dagen.DataGenerator;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CardGenerator extends AbstractGenerator {
    private final List<String[]> sber = ReaderFile.parseCsv(config.getProperties().getProperty("sber"));
    private final List<String[]> vtb = ReaderFile.parseCsv(config.getProperties().getProperty("vtb"));
    private final List<String[]> psb = ReaderFile.parseCsv(config.getProperties().getProperty("psb"));
    private final List<String[]> tinkoff = ReaderFile.parseCsv(config.getProperties().getProperty("tinkoff"));
    private final List<String[]> raiffeisenbank = ReaderFile.parseCsv(config.getProperties().getProperty("raiffeisenbank"));
    private final List<String[]> gazprom = ReaderFile.parseCsv(config.getProperties().getProperty("gazprom"));
    private final List<String[]> alfabank = ReaderFile.parseCsv(config.getProperties().getProperty("alfabank"));

    public FakeCard card(Banks bank, CardType cardType, String holderNameCyr){
        log.info("Do card for type " + cardType.name());
        log.info("Do card for banl " + bank.name());
        String number = Randomizer.getRandomNumber(9);
        List<String[]> filtredByType = getBankBins(bank).stream().filter(i -> i[1].equals(cardType.name())).toList();
        String bin;
        if(filtredByType.size() == 0){
            log.info("Не нашлось подходящего БИНа для указанного банка, поэтому БИН будет сгенерирован случайно");
            bin = getRandomBin(cardType);
        }
        else {
            bin = Randomizer.getRandomElementFromList(filtredByType)[0];
        }
        String checkDigit = Luhn.getCheckDigit(bin + number);
        Holder holder = new Holder(holderNameCyr, new Translator(Schemas.YANDEX_MAPS).translate(holderNameCyr));
        return FakeCard.builder()
                .type(cardType)
                .number(bin + number + checkDigit)
                .holder(holder)
                .cvv(Randomizer.getRandomNumber(3))
                .issueDate(LocalDate.now().minusDays(Randomizer.randomBetween(0, 1095)))
                .build();
    }

    public FakeCard card(CardType cardType){
        return card(
                Randomizer.getRandomElementFromList(Arrays.asList(Banks.values())),
                cardType,
                DataGenerator.persons().get().getFio().toFI()
        );
    }

    public FakeCard card(){
        return card(
                Randomizer.getRandomElementFromList(Arrays.asList(Banks.values())),
                Randomizer.getRandomElementFromList(Arrays.asList(CardType.values())),
                DataGenerator.persons().get().getFio().toFI()
        );
    }

    private List<String[]> getBankBins(Banks bank){
        var list = switch (bank){
            case SBER -> sber;
            case PSB -> psb;
            case VTB -> vtb;
            case TINKOFF -> tinkoff;
            case RAIFFEISEN -> raiffeisenbank;
            case GAZPROM -> gazprom;
            case ALFA -> alfabank;
        };
        return list;
    }

    private String getRandomBin(CardType cardType){
        StringBuilder bin = new StringBuilder();
        switch (cardType){
            case MIR -> {
                bin.append(22);
                bin.append(Randomizer.getRandomStringCode(4));
            }
            case VISA -> {
                bin.append(4);
                bin.append(Randomizer.getRandomStringCode(5));
                break;
            }
            case MASTERCARD -> {
                bin.append(5);
                bin.append(Randomizer.getRandomStringCode(5));
            }
            case UNIONPAY -> {
                bin.append(6);
                bin.append(Randomizer.getRandomStringCode(5));
            }
            case AMERICANEXPRESS, MAESTRO -> {
                bin.append(3);
                bin.append(Randomizer.getRandomStringCode(5));
            }
        }
        return bin.toString();
    }




}
