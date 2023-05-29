package pro.dagen;

import pro.dagen.account.Currency;
import pro.dagen.account.PersoneType;
import pro.dagen.account.ProfileType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountSuite {

    @Test
    public void checkAccount(){
        String accountNumber = DataGenerator.accountDetails().account(PersoneType.PERSON, Currency.RUB, ProfileType.COMMERCIAL);
        Assertions.assertEquals(20, accountNumber.toCharArray().length);
        Assertions.assertEquals("408028100", accountNumber.substring(0, 9));
    }

    @Test
    public void checkThatAccountUnique(){
        Assertions.assertEquals(100,
                IntStream.range(0, 100).mapToObj(i -> DataGenerator.accountDetails().account()).collect(Collectors.toSet()).size());
    }

    @Test
    public void checkInn(){
        Assertions.assertEquals(10, DataGenerator.accountDetails().inn10().toCharArray());
        Assertions.assertEquals(12, DataGenerator.accountDetails().inn12().toCharArray());
    }

    @Test
    public void checkOgrn(){
        Assertions.assertEquals(13, DataGenerator.accountDetails().ogrn().length());
    }


}
