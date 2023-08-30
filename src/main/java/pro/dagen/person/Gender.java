package pro.dagen.person;

import lombok.Getter;

public enum Gender {
    MALE (com.github.petrovich4j.Gender.Male),
    FEMALE(com.github.petrovich4j.Gender.Female);

    Gender(com.github.petrovich4j.Gender pGender) {
        this.pGender = pGender;
    }

    @Getter
    private com.github.petrovich4j.Gender pGender;
}
