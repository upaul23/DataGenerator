package generator.person;

import lombok.Data;

import java.util.Date;

@Data
public class FakePerson {

    FIO fio;
    Gender gender;
    Date birthDate;

}
