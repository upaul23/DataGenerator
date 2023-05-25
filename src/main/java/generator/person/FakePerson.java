package generator.person;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FakePerson {

    private FIO fio;
    private Gender gender;
    private String birthDate;

}
