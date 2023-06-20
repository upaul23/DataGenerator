package pro.dagen;

import pro.dagen.account.AccountDetailsGenerator;
import pro.dagen.address.AddressGenerator;
import pro.dagen.cars.CarsGenerator;
import pro.dagen.contacts.ContactsGenerator;
import pro.dagen.creditCard.CardGenerator;
import pro.dagen.documents.DocumentGenerator;
import pro.dagen.person.PersonGenerator;

public class DataGenerator {

    static private PersonGenerator personGenerator;
    static private DocumentGenerator documentGenerator;
    static private AccountDetailsGenerator accountDetailsGenerator;
    static private AddressGenerator addressGenerator;
    static private ContactsGenerator contactsGenerator;
    static private CarsGenerator carsGenerator;

    static private CardGenerator cardGenerator;

    public static PersonGenerator persons(){
        if(personGenerator == null){
            personGenerator = new PersonGenerator();
        }
        return personGenerator;
    }

    public static DocumentGenerator documents(){
        if(documentGenerator == null){
            documentGenerator = new DocumentGenerator();
        }
        return documentGenerator;
    }

    public static AccountDetailsGenerator accountDetails(){
        if(accountDetailsGenerator == null){
            accountDetailsGenerator = new AccountDetailsGenerator();
        }
        return accountDetailsGenerator;
    }


    public static ContactsGenerator contacts(){
        if(contactsGenerator == null){
            contactsGenerator = new ContactsGenerator();
        }
        return contactsGenerator;
    }

    public static AddressGenerator address(){
        if(addressGenerator == null){
            addressGenerator = new AddressGenerator();
        }
        return addressGenerator;
    }

    public static CarsGenerator cars(){
        if(carsGenerator == null){
            carsGenerator = new CarsGenerator();
        }
        return carsGenerator;
    }
    public static CardGenerator bankCard(){
        if(carsGenerator == null){
            cardGenerator = new CardGenerator();
        }
        return cardGenerator;
    }

}
