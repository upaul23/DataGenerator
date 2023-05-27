package generator.account;

import lombok.Getter;

public enum PersoneType {

    PERSON ("408"),
    COMPANY ("407"),
    BUDGET ("406");

    @Getter
    private String code;

    PersoneType(String code) {
        this.code = code;
    }
}
