package generator;

import generator.person.PersonGenerator;

public class DataGenerator {

    static private PersonGenerator personGenerator;

    public static PersonGenerator person(){
        if(personGenerator == null){
            personGenerator =  new PersonGenerator();
        }
        return personGenerator;
    }
}
