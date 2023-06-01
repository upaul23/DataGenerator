package pro.dagen.account;

import pro.dagen.AbstractGenerator;
import pro.dagen.fileworker.ReaderFile;
import pro.dagen.randomizer.Randomizer;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static pro.dagen.randomizer.Randomizer.*;


public class AccountDetailsGenerator extends AbstractGenerator {

    static List<String[]> banks = ReaderFile.parseCsv(config.getProperties().getProperty("banks"));

    public FakeAccount account(PersoneType personeType, Currency currency, ProfileType profileType, Bank bank){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(personeType.getCode());
        stringBuffer.append(profileType.getCode());
        stringBuffer.append(currency.getCode());
        stringBuffer.append("K");
        stringBuffer.append(getRandomNumber(11));
        String account = calcControlNumber(bank.getBik(), stringBuffer.toString());
        return FakeAccount.builder()
                .account(account)
                .bank(bank)
                .build();
    }

    public FakeAccount account(){
        Bank bank = bank();
        return account(
                getRandomEnum(PersoneType.class),
                getRandomEnum(Currency.class),
                getRandomEnum(ProfileType.class),
                bank
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

    public Bank bank(){
        String[] bankData = Randomizer.getRandomElementFromList(banks);
        return Bank.builder()
                .bik(bankData[0])
                .name(bankData[1])
                .city(bankData[2])
                .correspondentAccount(bankData[3])
                .build();
    }

    public String calcControlNumber(String bik, String account){
        String bikSubstring = String.format(bik.substring(6,9));
        String copyAccount = new String(account);
        String bikAndCorr = bikSubstring + copyAccount.replaceAll("K", "0");
        AtomicInteger checkSum = new AtomicInteger();
        int[]coefficients = {7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1};
        if(coefficients.length != bikAndCorr.toCharArray().length){
            throw new IllegalArgumentException();
        }
        IntStream.range(0, coefficients.length).forEach(i -> {
            int summ = coefficients[i] * Character.getNumericValue(bikAndCorr.toCharArray()[i]);
            if(String.valueOf(summ).toCharArray().length == 2){
                checkSum.addAndGet(Character.getNumericValue(String.valueOf(summ).toCharArray()[1]));
            }
            else {
                checkSum.addAndGet(summ);
            }

        });
        int s1 = Character.getNumericValue(String.valueOf(checkSum.get()).toCharArray()[1]) * 3;
        if(String.valueOf(s1).toCharArray().length == 2){
            return account.replaceAll("K", String.valueOf(String.valueOf(s1).toCharArray()[1]));
        }
        else {
            return account.replaceAll("K", String.valueOf(String.valueOf(s1).toCharArray()[0]));
        }
    }

}
