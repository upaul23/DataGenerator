package pro.dagen.cars;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeCarStateNumber {
    private String regionCode;
    private String regionName;
    private String number;

    @Override
    public String toString() {
        return String.format("%s %s", number, regionCode);
    }
}
