package generator.account;

import generator.AbstractGenerator;

import static generator.randomizer.Randomizer.*;


public class AccountDetailsGenerator extends AbstractGenerator {

    public FakeBankAccount personPaymnetAccount(){
        return FakeBankAccount.builder().build();
    }

    public String account(PERSONE personeType, CURRENCY currency, PROFILE profile){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(personeType.getCode());
        stringBuffer.append(profile.getCode());
        stringBuffer.append(currency.getCode());
        stringBuffer.append("0");
        stringBuffer.append(getRandomNumber(11));
        return stringBuffer.toString();
    }

    public String account(){
        return account(
                getRandomEnum(PERSONE.class),
                getRandomEnum(CURRENCY.class),
                getRandomEnum(PROFILE.class)
                );

    }


    public static String inn12() {
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

    public static String inn10() {
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

}
