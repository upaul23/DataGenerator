package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.person.Family;
import pro.dagen.person.Gender;

public class FamilySuite {

    @Test
    public void check_family(){
        Family family = DataGenerator.family().family(1, 2);
        Assertions.assertEquals(3, family.getChildren().size());
        Assertions.assertEquals(2, family.getChildren().stream().filter(i -> i.getGender().equals(Gender.FEMALE)).count());
        Assertions.assertEquals(1, family.getChildren().stream().filter(i -> i.getGender().equals(Gender.MALE)).count());

        Assertions.assertEquals(family.getFather().getFio().getLastname(),
                family.getChildren().stream().filter(i -> i.getGender().equals(Gender.MALE)).findFirst().get().getFio().getLastname());
        Assertions.assertEquals(family.getFather().getFio().getLastname(),
                family.getChildren().stream().filter(i -> i.getGender().equals(Gender.FEMALE)).findFirst().get().getFio().getLastname());
        Assertions.assertEquals(family.getFather().getFio().getLastname(), family.getMother().getFio().getLastname());
    }
}
