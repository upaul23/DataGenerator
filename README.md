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

Метод возвращает экземпляр FakePerson с заполненными полями. ФИО соответствует гендеру персоны.

```java
DataGenerator.persons().get() 
```

Получение персоны с заранее заданным полом.

```java
DataGenerator.persons().get(Gender.MALE)
```
этим параметром в _**dagen.properties**_ задается диапозон годов рождения, генерируемых персон

```properties
yearOfBirthRange=1920-2005
  ```

**Паспортные данные**

Метод возвращает экземпляр FakeRussianPassport

```java
DataGenerator.documents().passport()
```

**СНИЛС**
```java
DataGenerator.documents().snils()
```


**Расчетный счет**
```java
DataGenerator.accountDetails().account(PersoneType.PERSON, Currency.RUB, ProfileType.COMMERCIAL, DataGenerator.accountDetails().bank())
```

**Банковские данные**

Метод возвращает экземпляр класса Bank

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

Возвращается строка в формате +7 XXX XXX XXXX
```java
DataGenerator.contacts().mobile()
```

**Номер городского телефона**

Возвращается строка в формате +7 XXX XXX XXXX

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


**Как подключить библиотеку?**

Добавить в **pom.xml** вашего проекта, как зависимость:

```xml
<dependency>
    <groupId>pro.dagen</groupId>
    <artifactId>datagenerator</artifactId>        
    <version>1.0</version>    
</dependency>


```




