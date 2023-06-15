package pro.dagen.cars;

import pro.dagen.AbstractGenerator;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;

import java.util.List;
import java.util.Random;

public class CarsGenerator extends AbstractGenerator {

    private final List<String[]> regionCodeList = ReaderFile.parseCsv(config.getProperties().getProperty("regionCode"));

    public FakeCarStateNumber stateNumber(){
        String[] code = Randomizer.getRandomElementFromList(regionCodeList);
        StringBuilder number = new StringBuilder();
        number.append(randomChars(1));
        number.append(Randomizer.getRandomStringCode(3));
        number.append(randomChars(2));
        return FakeCarStateNumber.builder()
                .number(number.toString())
                .regionCode(code[0])
                .regionName(code[1])
                .build();
    }


    private String randomChars(int length){
        char[] chars = "АВЕКМНОРСТУХ".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }
}
