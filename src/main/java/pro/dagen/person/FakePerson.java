package pro.dagen.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakePerson {

    private FIO fio;
    private Gender gender;
    private String birthDate;

}
