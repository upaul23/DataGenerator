package pro.dagen.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.dagen.DataGenerator;
import pro.dagen.documents.FakeRussianPassport;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DocumentSuite {

    @Test
    public void getPassport(){
        FakeRussianPassport fakeRussianPassport = DataGenerator.documents().passport();
        Assertions.assertNotNull(fakeRussianPassport.getCode());
        Assertions.assertNotNull(fakeRussianPassport.getSeries());
        Assertions.assertNotNull(fakeRussianPassport.getIssued());
        Assertions.assertNotNull(fakeRussianPassport.getIssueDate());
        Assertions.assertNotNull(fakeRussianPassport.getNumber());
    }

    @Test
    public void checkThatPassportUnique(){
        Assertions.assertEquals(100, IntStream.range(0, 100).mapToObj(i->(DataGenerator.documents().passport()))
                .collect(Collectors.toSet()).size());
    }

    @Test
    public void checkSnils(){
        Assertions.assertEquals(11, DataGenerator.documents().snils().toCharArray().length);
    }

    @Test
    public void checkThatSnilsUnique(){
        Assertions.assertEquals(100, IntStream.range(0, 100).mapToObj(i->(DataGenerator.documents().snils()))
                .collect(Collectors.toSet()).size());
    }
}
