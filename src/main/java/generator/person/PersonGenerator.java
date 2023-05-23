package generator.person;

import generator.DataGenerator;
import generator.fileworker.ReaderFile;
import generator.config.Config;
import generator.randomizer.Randomizer;

import java.util.List;

public class PersonGenerator {

    List<String> femaleNames;
    List<String> maleNames;
    List<String> surnames;
    List<String> parentnames;

    Config config = new Config();
    Randomizer randomizer = new Randomizer();
    int birthDayRangeStart;
    int birthDayRangeEnd;

    public PersonGenerator() {
        femaleNames = ReaderFile.readByLine(config.getProperties().getProperty("femalenames"));
        maleNames = ReaderFile.readByLine(config.getProperties().getProperty("malenames"));
        surnames = ReaderFile.readByLine(config.getProperties().getProperty("surnames"));
        parentnames = ReaderFile.readByLine(config.getProperties().getProperty("parentnames"));
        String range = config.getProperties().getProperty("yearOfBirthRange");
        birthDayRangeStart = Integer.parseInt(range.substring(0,4));
        birthDayRangeEnd = Integer.parseInt(range.substring(4, range.length()));
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
                    .fisrtname(randomizer.getRandomElementFromList(femaleNames))
                    .parentname(getFemaleParentName())
                    .build();
        }
        else {
            fio = FIO.builder()
                    .lastname(randomizer.getRandomElementFromList(surnames))
                    .fisrtname(randomizer.getRandomElementFromList(maleNames))
                    .parentname(randomizer.getRandomElementFromList(parentnames))
                    .build();
        }
        return FakePerson.builder()
                .gender(gender)
                .fio(fio)
                .birthDate(DataGenerator.getRandomDate(birthDayRangeStart, birthDayRangeEnd))
                .build();
    }

    private String getFemaleLastName(){
        String lastname = randomizer.getRandomElementFromList(surnames);
        if(lastname.substring(lastname.length() - 2, lastname.length()).equals("о")){
            return lastname;
        }
        else if(lastname.substring(lastname.length() - 2, lastname.length()).equals("ва")){
            return lastname;
        }
        else {
            return lastname + "ва";
        }
    }

    public String getFemaleParentName(){
        String parentname = randomizer.getRandomElementFromList(parentnames);
        return parentname.replaceAll("вич", "ова");
    }
}
