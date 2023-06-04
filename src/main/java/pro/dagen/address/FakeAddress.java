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
        String formatAddress = String.format("%s, �. %s, ��. %s, �. %s, %s %s", street, building, flat, city, subject, postalCode);
        return shorty(formatAddress);
    }

    private String shorty(String address){
        String streetTypeShort = "";
        if (address.contains("�����") | address.contains("�����")){
            streetTypeShort = "��.";
        }
        if (address.contains("��������") | address.contains("��������")){
            streetTypeShort = "�����.";
        }
        if(address.contains("��������") | address.contains("��������")){
            streetTypeShort = "���.";
        }
        if(address.contains("������") | address.contains("������")){
            streetTypeShort = "������";
        }
        address = address.replace("����������", "����.")
                .replace("�������", "���.")
                .replace("�����", "")
                .replace("�����", "")
                .replace("��������", "")
                .replace("��������", "")
                .replace("��������", "")
                .replace("��������", "")
                .replace("������", "")
                .replace("������", "");
        return String.format("%s %s", streetTypeShort, address);
    }
}

