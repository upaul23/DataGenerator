package generator.documents;

import generator.AbstractGenerator;
import generator.fileworker.ReaderFile;
import generator.randomizer.Randomizer;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static generator.randomizer.Randomizer.getRandomNumber;

public class DocumentGenerator extends AbstractGenerator {

    private List<String> cities;
    private List<String> areas;

    public DocumentGenerator() {
        cities = ReaderFile.readByLine(config.getProperties().getProperty("city"));
        areas = ReaderFile.readByLine(config.getProperties().getProperty("area"));
    }

    public FakeRussianPassport passport(){
        String city = Randomizer.getRandomElementFromList(cities);
        String area = Randomizer.getRandomElementFromList(areas);
        String issuedBy = String.format(
                "ОТДЕЛОМ ВНУТРЕННИХ ДЕЛ %s ГОРОДА %s",
                area.replaceAll("кий", "кого").toUpperCase(Locale.ROOT),
                city
        );
        return FakeRussianPassport.builder()
                .code(Randomizer.getRandomNumber(4))
                .number(Randomizer.getRandomNumber(6))
                .series(Randomizer.getRandomNumber(4))
                .issued(issuedBy)
                .issueDate(Randomizer.getRandomDate(2000, LocalDate.now().getYear()))
                .code(Randomizer.getRandomNumber(6))
                .build();

    }

    public String snils() {
        String newSnils = generateSnilsChecksum(getRandomNumber(9));
        return newSnils;
    }

    private String generateSnilsChecksum(String baseString) {
        int index = 0;
        int sum = 0;
        byte[] var3 = baseString.getBytes();
        int check = var3.length;

        for (int var5 = 0; var5 < check; ++var5) {
            byte snilsDigit = var3[var5];
            sum += (snilsDigit - 48) * (9 - index);
            ++index;
        }

        String checkDigit = "00";
        if (sum < 100) {
            checkDigit = Integer.toString(sum);
        } else if (sum > 101) {
            check = sum % 101;
            if (check != 100) {
                checkDigit = Integer.toString(check);
            }
        }

        if (checkDigit.length() < 2) {
            checkDigit = "0" + checkDigit;
        }

        return baseString + checkDigit;
    }
}
