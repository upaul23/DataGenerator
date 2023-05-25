package generator;

import generator.documents.FakeRussianPassport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DocumentSuite {

    @Test
    public void getPassport(){
        FakeRussianPassport fakeRussianPassport = DataGenerator.documents().getRussianPassport();
        Assertions.assertNotNull(fakeRussianPassport.getCode());
        Assertions.assertNotNull(fakeRussianPassport.getSeries());
        Assertions.assertNotNull(fakeRussianPassport.getIssued());
        Assertions.assertNotNull(fakeRussianPassport.getIssueDate());
        Assertions.assertNotNull(fakeRussianPassport.getNumber());
    }

    @Test
    public void checkThatPassportUnique(){
        Assertions.assertEquals(100, IntStream.range(0, 100).mapToObj(i->(DataGenerator.documents().getRussianPassport()))
                .collect(Collectors.toSet()).size());
    }
}
