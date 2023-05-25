package generator;

import generator.person.FakePerson;
import generator.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonSuite {

    @Test
    @DisplayName("Get FakePerson and check fields")
    public void getPerson(){
        FakePerson fakePerson = DataGenerator.persons().get();
        Assertions.assertNotNull(fakePerson.getBirthDate());
        Assertions.assertNotNull(fakePerson.getFio());
        Assertions.assertNotNull(fakePerson.getBirthDate());
    }

    @Test
    @DisplayName("Get FakePerson with gender preference")
    public void getGenderPerso(){
        FakePerson malePerson = DataGenerator.persons().get(Gender.MALE);
        Assertions.assertEquals(Gender.MALE, malePerson.getGender());

        FakePerson femalePerson = DataGenerator.persons().get(Gender.FEMALE);
        Assertions.assertEquals(Gender.FEMALE, femalePerson.getGender());
    }

    @Test
    @DisplayName("Check that FakePerson always unique")
    public void checkThatPersonAlwasUnique(){
        Assertions.assertEquals(100, IntStream.range(0, 100).mapToObj(i->(DataGenerator.persons().get())).collect(Collectors.toSet()).size());
    }
}
