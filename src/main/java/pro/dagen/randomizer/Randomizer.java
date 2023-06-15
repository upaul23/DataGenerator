package pro.dagen.randomizer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    static public <T> T getRandomElementFromList(List<T> list){
        return list.get((int) randomBetween(0, list.size()-1));
    }

    static public <T extends Enum<T>> T getRandomEnum(Class<T> e){
        T[] array = e.getEnumConstants();
        return e.getEnumConstants()[new Random().nextInt(array.length)];
    }

    public static String getRandomDate(Integer minYear, Integer maxYear) {
        GregorianCalendar gc = new GregorianCalendar();

        int year = (int) randomBetween(minYear, maxYear);
        gc.set(Calendar.YEAR, year);

        int dayOfYear = (int) randomBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return String.format("%02d", gc.get(Calendar.DAY_OF_MONTH)) + "."
                + String.format("%02d", gc.get(Calendar.MONTH) + 1) + "."
                + gc.get(Calendar.YEAR);
    }

    public static String getRandomNumber(int length) {
        // Use digits
        char[] chars = "0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

    public static long randomBetween(long minValue, long maxValue) {
        return minValue + Math.round(Math.random() * (maxValue - minValue));
    }


    public static String getRandomString(Integer minLength, Integer maxLength) {
        // Use english alphabet.
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Select length of the string
        int length = new Random().nextInt(maxLength - minLength) + minLength;

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getRandomStringCode(int length) {
        char[] chars = "0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getRandomStringCyrilic(Integer minLength, Integer maxLength) {
        // Use english alphabet.
        char[] chars = "йцукенгшщзхъфывапролджэячсмитьбюё".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Select length of the string
        int length = new Random().nextInt(maxLength - minLength) + minLength;

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

}
