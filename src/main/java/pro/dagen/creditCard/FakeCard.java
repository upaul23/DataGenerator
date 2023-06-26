package pro.dagen.creditCard;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FakeCard {
    private CardType type;
    private String number;
    private String cvv;
    private LocalDate issueDate;
    private Holder holder;
}
