package generator;

import generator.person.PersonGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataGenerator {

    static private PersonGenerator personGenerator;

    public static PersonGenerator person(){
        if(personGenerator == null){
            personGenerator =  new PersonGenerator();
        }
        return personGenerator;
    }

    public static String getRandomDate(Integer minYear, Integer maxYear) {
        GregorianCalendar gc = new GregorianCalendar();

        Integer year = (int) randomBetween(minYear, maxYear);
        gc.set(Calendar.YEAR, year);

        Integer dayOfYear = (int) randomBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        String date = String.format("%02d", gc.get(Calendar.DAY_OF_MONTH)) + "."
                + String.format("%02d", gc.get(Calendar.MONTH) + 1) + "."
                + gc.get(Calendar.YEAR);

        return date;
    }

    public static long randomBetween(long minValue, long maxValue) {
        return minValue + Math.round(Math.random() * (maxValue - minValue));
    }
}
