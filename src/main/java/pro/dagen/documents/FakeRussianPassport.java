package pro.dagen.documents;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeRussianPassport {
    String series;
    String number;
    String issued;
    String issueDate;
    String code;
}
