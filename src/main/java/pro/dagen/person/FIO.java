package pro.dagen.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FIO {

    private String firstname;
    private String lastname;
    private String parentName;
}
