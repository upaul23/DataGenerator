**DATAGENERATOR**

Данная библиотека предназначена для генерации **случайных данных,** специфицированных под русскоязычные проекты. Данные аналогичны реальным, боевым данным.  
**Библиотека не использует чьих-то персональных данных.** Все данные являются случайно сгенерированными (кроме случаев кастомной генерации) и любые совпадения с реальными персональными данными являются вероятностным совпадением.

**Все реальные данные взяты из открытых источников и не нарушают права третьих лиц.**

Методы генерации не являются идемпотентными, т.е. каждый последующий вызов метода будет возвращать уникальные данные.
В качестве тезауруса используются списки, хранящиеся в тестовых файлах в папке resource/dictionary. Классы генераторов получают данные о расположении файлов из dagen.properties по соответствующим ключам.

Генерация данных происходит по алгоритму случайных выборок из тезауруса и комбинирования данных для создания сущности.
**DataGenerator** – является точкой входа и содержит статические методы, для получения данных из соответствующих генераторов.

**Библиотека генерирует следующие данные:**

**Персоны**

Метод возвращает экземпляр FakePerson с заполненными полями. ФИО соответствует гендеру персоны:

```java
DataGenerator.persons().get() 
```

Получение персоны с заранее заданным полом:

```java
DataGenerator.persons().get(Gender.MALE)
```
этим параметром в _**dagen.properties**_ задается диапозон годов рождения, генерируемых персон:

```properties
yearOfBirthRange=1920-2005
  ```

**Паспортные данные**

Метод возвращает экземпляр _FakeRussianPassport_:

```java
@Data
@Builder
public class FakeRussianPassport {
    String series;
    String number;
    String issued;
    String issueDate;
    String code;
}
```

```java
DataGenerator.documents().passport()
```

**СНИЛС**

```java
DataGenerator.documents().snils()
```

**Расчетный счет**

Метод создания счета с заданными параметрами:

```java
DataGenerator.accountDetails().account(PersoneType.PERSON, Currency.RUB, ProfileType.COMMERCIAL, DataGenerator.accountDetails().bank());
```

Метод создания счета со случайными параметрами:

```java
DataGenerator.accountDetails().account();
```

**Банковские данные**

Метод возвращает экземпляр класса Bank

```java
@Builder
@Data
public class Bank {
    private String correspondentAccount;
    private String bik;
    private String name;
    private String city;
}
```

```java
DataGenerator.accountDetails().bank()
```

**ИНН для ФЛ**
```java
DataGenerator.accountDetails().inn12()
```

**ИНН для ЮЛ**
```java
DataGenerator.accountDetails().inn10()
```

**ОГРН для ЮЛ**
```java
DataGenerator.accountDetails().ogrn()
```

**Номер мобильного телефона**

Возвращается строка в формате +7 YYY XXX XXXX, где YYY соотвествует коду мобильного оператора,
начинающегося с цифры 9
```java
DataGenerator.contacts().mobile()
```

**Номер городского телефона**

Возвращается строка в формате +7 YYY XXX XXXX, где YYY соотвествует разряду городскиих номеров,
начинающегося с фирцы 8

```java
DataGenerator.contacts().cityPhone()
```

**Адрес электронной почты**

Возвращается строка в формате <случайная комбинация>@<случайный домен>
```java
DataGenerator.contacts().email()
```
Возвращается строка в формате <случайная комбинация>@test.ru
```java
DataGenerator.contacts().email("test.ru")
```

**Автомобильные гос. номера**

Метод возвращает экземпляр класса _FakeCarStateNumber_:

```java
DataGenerator.carsGenerator().stateNumber()
```

**Реквизиты банковских карт**

Метод вернет экземлпяр _FakeCard_ со случыйными реквизитами:

```java

DataGenerator.bankCard().card()
        
```

Метод вернет экземпляр карты с реальным БИНом, который соответствует банку и типу платежной системы.
В случае, если в словаре не было найдено нужного типа платежной системы, то номер карты будет сгенерирован
полностью случайно. Имя владельца будет автоматически транслитерировано в латинские буквы. 

```java
DataGenerator.bankCard().card(Banks.SBER, CardType.MIR, "Василий Пупкин")
```

Метод сгенерирует экземпляр карты с указанным типом платежной системы:

```java
DataGenerator.bankCard().card(CardType.VISA)
```

Список поддерживаемых платежных систем:

```java
public enum CardType {
    MIR,
    VISA,
    MASTERCARD,
    MAESTRO,
    UNIONPAY,
    AMERICANEXPRESS
}
```

Список поддерживаемых БИНов банков эмитентов:
```java
public enum Banks {
    SBER,
    VTB,
    TINKOFF,
    PSB,
    RAIFFEISEN,
    ALFA,
    GAZPROM
}
```

**Как подключить библиотеку?**

Добавить в **pom.xml** вашего проекта, как зависимость:

```xml
<dependency>
    <groupId>pro.dagen</groupId>
    <artifactId>datagenerator</artifactId>        
    <version>1.2.0</version>    
</dependency>

```


**ОТКАЗ ОТ ОТВЕТСТВЕННОСТИ**

Номера кредитных карт и другие данные, абсолютно случайны и не имеют никакой реальной ценности. 
Не пытайтесь использовать поддельные данные кредитной карты для совершения какой-либо покупки,
так как это не сработает. Попытка взлома или мошенничества с использованием поддельной информации
кредитной карты является незаконной и может привести к наказанию, например тюремному заключению.



