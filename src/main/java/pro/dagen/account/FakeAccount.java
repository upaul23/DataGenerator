package pro.dagen.account;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FakeAccount {

    private String account;
    private Bank bank;

}
