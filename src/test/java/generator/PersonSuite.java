package generator;

import org.junit.jupiter.api.Test;

public class PersonSuite {

    @Test
    public void getPerson(){
        DataGenerator.person().get();
    }
}
