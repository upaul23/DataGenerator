package generator.randomizer;

import generator.DataGenerator;

import java.util.List;

public class Randomizer {

    public static boolean getRandomBoolean() {
        boolean result = Math.random() < 0.5;
        return result;
    }

    public <T> T getRandomElementFromList(List<T> list){
        return list.get((int) DataGenerator.randomBetween(0, list.size()));
    }
}
