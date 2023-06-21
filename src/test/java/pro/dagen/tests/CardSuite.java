package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.creditCard.Banks;
import pro.dagen.creditCard.CardType;
import pro.dagen.creditCard.FakeCard;
import pro.dagen.creditCard.Luhn;

import java.util.Arrays;

public class CardSuite {

    @Test
    public void checkMirCard(){
        FakeCard fakeCard = DataGenerator.bankCard().card(Banks.SBER, CardType.MIR, "Василий Пупкин");
        Assertions.assertTrue(Luhn.isValidLuhn(fakeCard.getNumber()));
        Assertions.assertEquals("Vasiliy Pupkin", fakeCard.getHolder().getTranslated());
        Assertions.assertEquals("22022", fakeCard.getNumber().substring(0, 5));
        Assertions.assertEquals(16, fakeCard.getNumber().length());
    }

    @Test
    public void checkRandomCard(){
        FakeCard fakeCard = DataGenerator.bankCard().card();
        Assertions.assertTrue(Luhn.isValidLuhn(fakeCard.getNumber()));
        Assertions.assertNotNull(fakeCard.getNumber());
        Assertions.assertNotNull(fakeCard.getCvv());
        Assertions.assertNotNull(fakeCard.getHolder());
        Assertions.assertNotNull(fakeCard.getType());
        Assertions.assertNotNull(fakeCard.getIssueDate());
    }

    @Test
    public void checkGeneratedNumber(){
        Arrays.asList(CardType.values()).stream().forEach(i -> {
            FakeCard fakeCard = DataGenerator.bankCard().card(Banks.VTB, i, "Иван Иванов");
            Assertions.assertTrue(Luhn.isValidLuhn(fakeCard.getNumber()));
        });
    }

    @Test
    public void checkType(){
        FakeCard fakeCard = DataGenerator.bankCard().card(CardType.VISA);
        Assertions.assertEquals("4", fakeCard.getNumber().substring(0, 1));
    }

}
