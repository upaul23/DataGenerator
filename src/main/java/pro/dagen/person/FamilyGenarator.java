package pro.dagen.person;

import pro.dagen.randomizer.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FamilyGenarator extends PersonGenerator{

    final String consentAge = config.getProperties().getProperty("consentAge");

    public Family family(int sonCounter, int duagtherConter){
        FakePerson father = get(Gender.MALE);
        FakePerson mother = get(Gender.FEMALE);
        mother.getFio().setLastname(getFemaleLastName(father.getFio().getLastname()));

        List<FakePerson> children = new ArrayList<>();
        IntStream.range(0, sonCounter).forEach(i->children.add(getChild(father, mother, Gender.MALE)));
        IntStream.range(0, duagtherConter).forEach(i->children.add(getChild(father, mother, Gender.FEMALE)));
        return Family.builder()
                .children(children)
                .father(father)
                .mother(mother)
                .build();
    }


    public FakePerson getChild(FakePerson father, FakePerson mother, Gender childGender){
        FakePerson child = get(childGender);
        if(childGender.equals(Gender.FEMALE)){
            child.getFio().setParentName(getParentName(father.getFio().getFirstname(), Gender.FEMALE));
            child.getFio().setLastname(getFemaleLastName(father.getFio().getLastname()));
        }
        else {
            child.getFio().setParentName(getParentName(father.getFio().getFirstname(), Gender.MALE));
            child.getFio().setLastname(father.getFio().getLastname());
        }
        int childDateBirth = father.getBirthDate().getYear() <= mother.getBirthDate().getYear()
                ? (mother.getBirthDate().getYear() + Integer.valueOf(consentAge))
                : (father.getBirthDate().getYear() + Integer.valueOf(consentAge));
        child.setBirthDate(Randomizer.getDateInRange(childDateBirth - 1 , childDateBirth));
        return child;
    }

}
