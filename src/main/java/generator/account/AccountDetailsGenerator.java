package generator.account;

import generator.AbstractGenerator;
import generator.fileworker.ReaderFile;
import generator.randomizer.Randomizer;

import java.time.LocalDate;
import java.util.List;

import static generator.randomizer.Randomizer.*;


public class AccountDetailsGenerator extends AbstractGenerator {

    public String account(PersoneType personeType, Currency currency, ProfileType profileType){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(personeType.getCode());
        stringBuffer.append(profileType.getCode());
        stringBuffer.append(currency.getCode());
        stringBuffer.append("0");
        stringBuffer.append(getRandomNumber(11));
        return stringBuffer.toString();
    }

    public String account(){
        return account(
                getRandomEnum(PersoneType.class),
                getRandomEnum(Currency.class),
                getRandomEnum(ProfileType.class)
                );

    }


    public String inn12() {
        Integer[] coefsArr1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0, 0};
        Integer[] coefsArr2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0};
        Integer result1 = 0;
        Integer result2 = 0;
        StringBuilder inn = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int digit = 0;
            if (i < 10) {
                digit = ((Long) randomBetween(1, 9)).intValue();
                result1 += digit * coefsArr1[i];
            }
            if (i == 10) {
                digit = result1 % 11 % 10;
            }
            if (i == 11) {
                digit = result2 % 11 % 10;
            }
            result2 += digit * coefsArr2[i];
            inn.append(digit);

        }
        return inn.toString();
    }

    public String inn10() {
        Integer[] coefsArr = {2, 4, 10, 3, 5, 9, 4, 6, 8};
        Integer result = 0;
        StringBuilder inn = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = ((Long) Math.round(Math.random() * 9)).intValue();
            result += digit * coefsArr[i];
            inn.append(digit);

        }
        result = (result % 11) % 10;
        inn.append(result);
        return inn.toString();
    }

    public String ogrn() {
        List<String[]> subjectList = ReaderFile.parseCsv(config.getProperties().getProperty("subject"));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Randomizer.getRandomNumber(1)); //признак отнесения государственного регистрационного номера записи
        stringBuffer.append(Randomizer.getRandomDate(2000, LocalDate.now().getYear()).substring(8,10)); //Год регистрации
        stringBuffer.append(Randomizer.getRandomElementFromList(subjectList)[0]); // Регион регистрации
        stringBuffer.append(Randomizer.getRandomNumber(2)); //Код налоговой инспекции
        stringBuffer.append(Randomizer.getRandomNumber(5)); //Номер записи регистрации
        Long ogrn = Long.valueOf(stringBuffer.toString());
        Long controlNumber = ogrn % 11 == 10 ? 0 : (ogrn % 11);
        stringBuffer.append(controlNumber);
        return stringBuffer.toString();
    }



}
