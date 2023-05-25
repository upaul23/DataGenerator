package generator.account;

import lombok.Getter;

public enum CURRENCY {

    RUB ("810"),
    EUR ("978"),
    USD("840");

    @Getter
    private String code;

    CURRENCY(String code) {
        this.code = code;
    }
}
