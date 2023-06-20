package pro.dagen.creditCard;

import pro.dagen.AbstractGenerator;
import pro.dagen.account.Bank;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardGenerator extends AbstractGenerator {

    private final List<String[]> sber = ReaderFile.parseCsv(config.getProperties().getProperty("sber"));
    private final List<String[]> vtb = ReaderFile.parseCsv(config.getProperties().getProperty("vtb"));

    public FakeCard card(Banks bank, CardType cardType, String holderNameCyr){
        String number = Randomizer.getRandomNumber(9);
        List<String[]> filtredByType = getBankBins(bank).stream().filter(i -> i[1].equals(cardType.name())).collect(Collectors.toList());
        String bin = Randomizer.getRandomElementFromList(filtredByType)[0];
        String checkDigit = Luhn.getCheckDigit(bin + number);
        Holder holder = new Holder(holderNameCyr, new Translator(Schemas.GOST_779).translate(holderNameCyr));
        return FakeCard.builder()
                .type(cardType)
                .number(bin + number + checkDigit)
                .holder(holder)
                .cvv(Randomizer.getRandomNumber(3))
                .issueDate(LocalDate.now().minusDays(Randomizer.randomBetween(0, 1095)))
                .build();
    }

    private List<String[]> getBankBins(Banks bank){
        switch (bank){
            case SBER -> {
                return sber;
            }
            case PSB -> {
                return vtb;
            }
        }
        return Collections.EMPTY_LIST;
    }




}
