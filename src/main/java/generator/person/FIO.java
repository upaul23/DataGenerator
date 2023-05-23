package generator.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FIO {

    String fisrtname;
    String lastname;
    String parentname;
}
