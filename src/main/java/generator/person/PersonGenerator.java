package generator.person;

import generator.fileworker.ReaderFile;
import generator.properties.Config;

import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {

    List<String> femaleNames = new ArrayList<>();
    List<String> maleNames = new ArrayList<>();
    List<String> surnames = new ArrayList<>();
    List<String> parentnames = new ArrayList<>();

    Config config = new Config();

    public PersonGenerator() {
        femaleNames = ReaderFile.readByLine(config.getProperties().getProperty("femalenames"));
        maleNames = ReaderFile.readByLine(config.getProperties().getProperty("malenames"));
    }

    public FakePerson get(){
        return null;
    }

    public FakePerson get(Gender gender){
        return null;
    }
}
