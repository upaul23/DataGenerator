package generator.contacts;

import generator.AbstractGenerator;
import generator.DataGenerator;
import generator.fileworker.ReaderFile;
import generator.randomizer.Randomizer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsGenerator extends AbstractGenerator {

    private List<String> domains;

    public ContactsGenerator() {
        this.domains = ReaderFile.readByLine(config.getProperties().getProperty("domains"));
    }

    private static final int[] codes = {
            811, 812, 813, 814, 815, 816, 817, 818, 820, 821, 831, 833, 834, 835, 836, 841, 842, 843, 844, 845, 846, 847,
            848, 851, 855, 861, 862, 863, 865, 866, 867, 869, 871, 872, 873, 877, 878, 879, 401, 411, 413, 415, 416,
            421, 423, 424, 426, 427, 471, 472, 473, 474, 475, 481, 482, 483, 484, 485, 486, 487, 491, 492, 493, 494, 495,
            496, 498, 499, 301, 302, 336, 341, 342, 343, 345, 346, 347, 349, 351, 352, 353, 365, 381, 382, 383, 384, 385,
            388, 390, 391, 394, 395

    };

    public FakePhoneNumber mobile(){
        return FakePhoneNumber.builder()
                .countryCode("+7")
                .operatorCode(String.valueOf(Randomizer.randomBetween(900, 999)))
                .number(Randomizer.getRandomNumber(7))
                .build();
     }

     public FakePhoneNumber cityPhone(){
        String code = String.valueOf(Randomizer.getRandomElementFromList(Arrays.stream(codes).boxed().collect(Collectors.toList())));
        return FakePhoneNumber.builder()
                .countryCode("+7")
                .operatorCode(code)
                .number(String.valueOf(Randomizer.randomBetween(30000, 9999999)))
                .build();
     }

     public String email(){
        return email(Randomizer.getRandomElementFromList(domains));
     }

    public String email(String domain){
        StringBuffer email = new StringBuffer();
        email.append(Randomizer.getRandomString(5, 20));
        email.append("@");
        email.append(domain);
        return email.toString();
    }
}

