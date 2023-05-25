package generator.account;

import lombok.Getter;

public enum PERSONE {

    PERSON ("408"),
    COMPANY ("407"),
    BUDGET ("406");

    @Getter
    private String code;

    PERSONE(String code) {
        this.code = code;
    }
}
