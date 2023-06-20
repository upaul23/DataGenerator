package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.creditCard.Banks;
import pro.dagen.creditCard.CardGenerator;
import pro.dagen.creditCard.CardType;
import pro.dagen.creditCard.FakeCard;

public class CardSuite {

    @Test
    public void checkCardNumber(){
        FakeCard fakeCard = DataGenerator.cardGenerator().card(Banks.SBER, CardType.MIR, "Василий Пупкин");
        Assertions.assertEquals("Vasilij Pupkin", fakeCard.getHolder().getTranslated());
        Assertions.assertEquals("22022", fakeCard.getNumber().substring(0, 5));
    }

}
