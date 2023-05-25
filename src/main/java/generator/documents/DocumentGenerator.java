package generator.documents;

import generator.AbstractGenerator;
import generator.DataGenerator;
import generator.config.Config;
import generator.fileworker.ReaderFile;
import generator.Randomizer.Randomizer;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class DocumentGenerator extends AbstractGenerator {

    private List<String> cities;
    private List<String> areas;

    public DocumentGenerator() {
        cities = ReaderFile.readByLine(config.getProperties().getProperty("city"));
        areas = ReaderFile.readByLine(config.getProperties().getProperty("area"));
    }

    public FakeRussianPassport getRussianPassport(){
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
}
