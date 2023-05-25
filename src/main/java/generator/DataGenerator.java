package generator;

import generator.account.AccountDetailsGenerator;
import generator.documents.DocumentGenerator;
import generator.person.PersonGenerator;

public class DataGenerator {

    static private PersonGenerator personGenerator;
    static private DocumentGenerator documentGenerator;
    static private AccountDetailsGenerator accountDetailsGenerator;

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




}
