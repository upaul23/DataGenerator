package generator;

import generator.account.CURRENCY;
import generator.account.PERSONE;
import generator.account.PROFILE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountSuite {

    @Test
    public void checkAccount(){
        String accountNumber = DataGenerator.accountDetails().account(PERSONE.PERSON, CURRENCY.RUB, PROFILE.COMMERCIAL);
        Assertions.assertEquals(20, accountNumber.toCharArray().length);
        Assertions.assertEquals("408028100", accountNumber.substring(0, 9));
    }

    @Test
    public void checkThatAccountUnique(){
        Assertions.assertEquals(100,
                IntStream.range(0, 100).mapToObj(i -> DataGenerator.accountDetails().account()).collect(Collectors.toSet()).size());
    }


}
