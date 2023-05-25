package generator.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FIO {

    private String fisrtname;
    private String lastname;
    private String parentname;
}
