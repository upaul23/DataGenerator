package generator.person;

import generator.DataGenerator;
import generator.fileworker.ReaderFile;
import generator.config.Config;
import generator.randomizer.Randomizer;

import java.util.List;

import static generator.randomizer.Randomizer.getRandomNumber;

public class PersonGenerator {

    private List<String> femaleNames;
    private List<String> maleNames;
    private List<String> surnames;
    private List<String> parentnames;

    private Config config = new Config();
    private int birthDayRangeStart;
    private int birthDayRangeEnd;

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
                    .fisrtname(Randomizer.getRandomElementFromList(femaleNames))
                    .parentname(getFemaleParentName())
                    .build();
        }
        else {
            fio = FIO.builder()
                    .lastname(Randomizer.getRandomElementFromList(surnames))
                    .fisrtname(Randomizer.getRandomElementFromList(maleNames))
                    .parentname(Randomizer.getRandomElementFromList(parentnames))
                    .build();
        }
        return FakePerson.builder()
                .gender(gender)
                .fio(fio)
                .birthDate(Randomizer.getRandomDate(birthDayRangeStart, birthDayRangeEnd))
                .build();
    }

    private String getFemaleLastName(){
        String lastname = Randomizer.getRandomElementFromList(surnames);
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

    private String getFemaleParentName(){
        String parentname = Randomizer.getRandomElementFromList(parentnames);
        return parentname.replaceAll("вич", "ова");
    }


}
