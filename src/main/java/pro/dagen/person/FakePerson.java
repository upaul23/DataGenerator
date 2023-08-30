package pro.dagen.person;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FakePerson {
    private FIO fio;
    private Gender gender;
    private LocalDate birthDate;
}
