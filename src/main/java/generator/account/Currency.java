package generator.account;

import lombok.Getter;

public enum Currency {

    RUB ("810"),
    EUR ("978"),
    USD("840");

    @Getter
    private String code;

    Currency(String code) {
        this.code = code;
    }
}
