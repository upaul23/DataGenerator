package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.address.FakeAddress;

public class AddressSuite {

    @Test
    public void checkPostalAddress(){
        FakeAddress fakeAddress = DataGenerator.address().address();
        fakeAddress.postalFormat();
        Assertions.assertEquals(6, fakeAddress.getPostalCode().length());
        Assertions.assertNotNull(fakeAddress.getArea());
        Assertions.assertNotNull(fakeAddress.getBuilding());
        Assertions.assertNotNull(fakeAddress.getCity());
        Assertions.assertNotNull(fakeAddress.getFlat());
        Assertions.assertNotNull(fakeAddress.getStreet());
        Assertions.assertNotNull(fakeAddress.getSubject());
        Assertions.assertNotNull(fakeAddress.getPostalCode());
    }
}
