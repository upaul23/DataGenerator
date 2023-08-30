package pro.dagen.person;

import com.github.petrovich4j.Case;
import com.github.petrovich4j.NameType;
import com.github.petrovich4j.Petrovich;
import org.apache.commons.lang3.StringUtils;
import pro.dagen.config.Config;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;

import java.time.LocalDate;
import java.util.List;

public class PersonGenerator {

    private List<String> femaleNames;
    private List<String> maleNames;
    private List<String> surnames;
    private List<String[]> parentnames;

    protected Config config = new Config();
    private int birthDayRangeStart;
    private int birthDayRangeEnd;
    Petrovich petrovich;

    public PersonGenerator() {
        femaleNames = ReaderFile.readByLine(config.getProperties().getProperty("femalenames"));
        maleNames = ReaderFile.readByLine(config.getProperties().getProperty("malenames"));
        surnames = ReaderFile.readByLine(config.getProperties().getProperty("surnames"));
        parentnames = ReaderFile.parseCsv(config.getProperties().getProperty("parentnames"));
        String range = config.getProperties().getProperty("yearOfBirthRange");
        birthDayRangeStart = Integer.parseInt(range.substring(0,4));
        birthDayRangeEnd = Integer.parseInt(range.substring(5, range.length()));
        petrovich = new Petrovich();
    }

    public FakePerson get(){
        Gender gender = Randomizer.getRandomBoolean() ? Gender.MALE : Gender.FEMALE;
        return get(gender);
    }

    public FakePerson get(Gender gender){
        FIO fio;
        if(gender.equals(Gender.FEMALE)){
            fio = FIO.builder()
                    .lastname(getFemaleLastName())
                    .firstname(Randomizer.getRandomElementFromList(femaleNames))
                    .parentName(getParentName(StringUtils.capitalize(Randomizer.getRandomElementFromList(maleNames)), Gender.FEMALE))
                    .build();
        }
        else {
            fio = FIO.builder()
                    .lastname(StringUtils.capitalize(Randomizer.getRandomElementFromList(surnames)))
                    .firstname(StringUtils.capitalize(Randomizer.getRandomElementFromList(maleNames)))
                    .parentName(getParentName(StringUtils.capitalize(Randomizer.getRandomElementFromList(maleNames)), Gender.MALE))
                    .build();
        }
        LocalDate birthDate = Randomizer.getDateInRange(birthDayRangeStart, birthDayRangeEnd);
        return FakePerson.builder()
                .gender(gender)
                .fio(fio)
                .birthDate(birthDate)
                .build();
    }

    private String getFemaleLastName(){
        String lastname = Randomizer.getRandomElementFromList(surnames);
        return getFemaleLastName(lastname);
    }

    protected String getFemaleLastName(String lastname){
        return petrovich.say(lastname, NameType.LastName, com.github.petrovich4j.Gender.Female, Case.Accusative);
    }

    protected String getParentName(String maleName, Gender gender){
        petrovich
        return petrovich.say(maleName, NameType.PatronymicName, gender.getPGender(), Case.Accusative);
    }
}
