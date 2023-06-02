package pro.dagen;

import pro.dagen.account.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountSuite {

    @Test
    public void checkAccount(){
        FakeAccount accountNumber = DataGenerator.accountDetails().account(PersoneType.PERSON, Currency.RUB, ProfileType.COMMERCIAL,
                DataGenerator.accountDetails().bank());
        Assertions.assertEquals(20, accountNumber.getAccount().length());
        Assertions.assertEquals("40802810", accountNumber.getAccount().substring(0, 8));
    }

    @Test
    public void checkThatAccountUnique(){
        Assertions.assertEquals(100,
                IntStream.range(0, 100).mapToObj(i -> DataGenerator.accountDetails().account()).collect(Collectors.toSet()).size());
    }

    @Test
    public void checkInn(){
        Assertions.assertEquals(10, DataGenerator.accountDetails().inn10().toCharArray().length);
        Assertions.assertEquals(12, DataGenerator.accountDetails().inn12().toCharArray().length);
    }

    @Test
    public void checkOgrn(){
        Assertions.assertEquals(13, DataGenerator.accountDetails().ogrn().length());
    }

    @Test
    public void checkSuum(){
        AccountDetailsGenerator accountDetailsGenerator = new AccountDetailsGenerator();
        Assertions.assertEquals("40602810700000000025", accountDetailsGenerator.calcControlNumber("049805746", "40602810K00000000025"));
    }

}
