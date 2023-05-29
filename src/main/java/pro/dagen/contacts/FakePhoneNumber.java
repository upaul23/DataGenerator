package pro.dagen.contacts;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FakePhoneNumber {

    private String countryCode;
    private String operatorCode;
    private String number;

    @Override
    public String toString() {
        return new StringBuffer().append(countryCode).append(operatorCode).append(number).toString();
    }

    public String withoutCountry(){
        return new StringBuffer().append(operatorCode).append(number).toString();
    }

    public String withoutCodes(){
        return new StringBuffer().append(number).toString();
    }
}
