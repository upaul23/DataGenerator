package generator.person;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FakePerson {

    FIO fio;
    Gender gender;
    String birthDate;

}
