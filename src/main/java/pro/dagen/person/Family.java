package pro.dagen.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Family {
    private FakePerson father;
    private FakePerson mother;
    private List<FakePerson> children;
}
