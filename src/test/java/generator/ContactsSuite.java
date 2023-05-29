package generator;

import generator.contacts.FakePhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactsSuite {

    @Test
    public void checkMobilePhone(){
        FakePhoneNumber fakePhoneNumber = DataGenerator.contacts().mobile();
        Assertions.assertEquals("+7", fakePhoneNumber.getCountryCode());
        Assertions.assertTrue(899 <= Integer.parseInt(fakePhoneNumber.getOperatorCode())
                && Integer.parseInt(fakePhoneNumber.getOperatorCode()) <= 1000);
        Assertions.assertEquals(12, fakePhoneNumber.toString().length());
        Assertions.assertEquals(10, fakePhoneNumber.withoutCountry().length());
        Assertions.assertEquals(7, fakePhoneNumber.withoutCodes().length());
    }

    @Test
    public void checkCityPhone(){
        FakePhoneNumber fakePhoneNumber = DataGenerator.contacts().cityPhone();
        Assertions.assertEquals("+7", fakePhoneNumber.getCountryCode());
        Assertions.assertTrue(300 <= Integer.parseInt(fakePhoneNumber.getOperatorCode())
                && Integer.parseInt(fakePhoneNumber.getOperatorCode()) <= 880);
    }

    @Test
    public void checkEmail(){
        String email = DataGenerator.contacts().email("test.ru");
        Assertions.assertTrue(email.contains("test.ru"));
        Assertions.assertEquals(2, email.split("@").length);
        Assertions.assertTrue(email.split("@")[0].length() >= 5);
    }

}
