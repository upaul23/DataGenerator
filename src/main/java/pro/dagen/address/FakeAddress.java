package pro.dagen.address;

import lombok.*;

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
        String formatAddress = String.format("%s, д. %s, кв. %s, г. %s, %s %s", street, building, flat, city, subject, postalCode);
        return shorty(formatAddress);
    }

    private String shorty(String address){
        String streetTypeShort = "";
        if (address.contains("Улица") | address.contains("улица")){
            streetTypeShort = "ул.";
        }
        if (address.contains("Проспект") | address.contains("проспект")){
            streetTypeShort = "просп.";
        }
        if(address.contains("Переулок") | address.contains("переулок")){
            streetTypeShort = "пер.";
        }
        if(address.contains("Проезд") | address.contains("Проезд")){
            streetTypeShort = "проезд";
        }
        address = address.replace("Республика", "респ.")
                .replace("область", "обл.")
                .replace("Улица", "")
                .replace("улица", "")
                .replace("Проспект", "")
                .replace("проспект", "")
                .replace("Переулок", "")
                .replace("переулок", "")
                .replace("Проезд", "")
                .replace("проезд", "");
        return String.format("%s %s", streetTypeShort, address);
    }
}

