package generator;

import generator.person.PersonGenerator;
import generator.person.TestPerson;

public class DataGenerator {

    PersonGenerator personGenerator;

    public PersonGenerator person(){
        if(personGenerator == null){
            personGenerator =  new PersonGenerator();
        }
        return personGenerator;
    }
}
