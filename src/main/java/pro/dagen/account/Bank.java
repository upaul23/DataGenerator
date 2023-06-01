package pro.dagen.account;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Bank {
    
    private String correspondentAccount;
    private String bik;
    private String name;
    private String city;

}
