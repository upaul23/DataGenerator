package pro.dagen.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FakeAddress {

    private String postalCode;
    private String city;
    private String street;
    private String flat;
    private String building;
    private String area;

    private String subject;


    public String postalFormat(){
        String formatAddress = String.format("%s, д. %s, кв. %s, г. %s, %s %s", street.trim(), building, flat, city, subject, postalCode);
        return shorty(formatAddress);
    }

    private String shorty(String address){
        String streetTypeShort = "";
        if (address.contains("улица") | address.contains("Улица")){
            streetTypeShort = "ул.";
        }
        if (address.contains("Проспект") | address.contains("проспект")){
            streetTypeShort = "пр-т";
        }
        if(address.contains("Проезд") | address.contains("проезд")){
            streetTypeShort = "пр-д";
        }
        if(address.contains("переулок") | address.contains("Переулок")){
            streetTypeShort = "пер.";
        }
        address = address
                .replace("область", "обл.")
                .replace("Республика", "респ.")
                .replace("проезд", "")
                .replace("Проезд", "")
                .replace("Переулок", "")
                .replace("переулок", "")
                .replace("улица", "")
                .replace("Улица", "")
                .replace("проспект", "")
                .replace("Проспект", "");
        return String.format("%s %s", streetTypeShort, address.trim());
    }
}

