package generator.account;

import lombok.Getter;

public enum PROFILE {

    FINANCE("01"),
    COMMERCIAL("02"),
    NONPROFIT("03");

    @Getter
    private String code;

    PROFILE(String code) {
        this.code = code;
    }
}
