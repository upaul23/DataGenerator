package pro.dagen.address;

import pro.dagen.AbstractGenerator;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;

import java.util.List;


public class AddressGenerator extends AbstractGenerator {

    private List<String> cities = ReaderFile.readByLine(config.getProperties().getProperty("city"));
    private List<String> streets = ReaderFile.readByLine(config.getProperties().getProperty("streets"));
    private List<String> disctricts = ReaderFile.readByLine(config.getProperties().getProperty("disctrict"));

    private List<String[]> subject = ReaderFile.parseCsv(config.getProperties().getProperty("subject"));

    public FakeAddress address(){
        FakeAddress fakeAddress = new FakeAddress();
        fakeAddress.setCity(Randomizer.getRandomElementFromList(cities));
        fakeAddress.setPostalCode(Randomizer.getRandomNumber(6));
        fakeAddress.setStreet(Randomizer.getRandomElementFromList(streets));
        fakeAddress.setBuilding(String.valueOf(Randomizer.randomBetween(1, 999)));
        fakeAddress.setFlat(String.valueOf(Randomizer.randomBetween(1, 999)));
        fakeAddress.setArea(Randomizer.getRandomElementFromList(disctricts));
        fakeAddress.setSubject(Randomizer.getRandomElementFromList(subject)[1]);
        return fakeAddress;
    }


}
