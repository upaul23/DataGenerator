package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.cars.FakeCarStateNumber;

public class CarsSuite {

    @Test
    public void checkStateNumber(){
        FakeCarStateNumber fakeCarStateNumber = DataGenerator.cars().stateNumber();
        Assertions.assertEquals(6, fakeCarStateNumber.getNumber().length());
        Assertions.assertNotNull(fakeCarStateNumber.getRegionCode());
        Assertions.assertNotNull(fakeCarStateNumber.getRegionName());
        Assertions.assertNotNull(fakeCarStateNumber.toString());
    }
}
