package pro.dagen.account;

import lombok.Getter;

public enum ProfileType {

    FINANCE("01"),
    COMMERCIAL("02"),
    NONPROFIT("03");

    @Getter
    private String code;

    ProfileType(String code) {
        this.code = code;
    }
}
