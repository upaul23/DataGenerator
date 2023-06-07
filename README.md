**DATAGENERATOR**

Данная библиотека предназначения для генерации **случайных данных,** специфицированных под русскоязычные проекты. Данные аналогичны реальным боевым данным.  
**Библиотека не использует чьих-то персональных данных.** Все данные являются случайно сгенерированными (кроме случаев ручной генерации) и любые совпадения с реальными персональными данными являются вероятностным совпадением.

**Все реальные данные взяты из открытых источников и не нарушают права третьих лиц.**

Методы генерации не являются идемпотентными, т.е. каждый последующий вызов метода будет возвращать уникальные данные.
В качестве тезауруса используются списки, хранящиеся в тестовых файлах в папке resource/dictionary. Классы генераторов получают данные о расположении файлов из app.properties по соответствующим ключам.

Генерация данных происходит по алгоритму случайных выборок из тезауруса и комбинированию для создания сущности.
**DataGenerator** – является точкой входа и содержится статические методы, для получения данных из соответствующих генераторов.

**Библиотека генерирует следующие данные:**

**Персоны.** 
ФИО соответствует гендеру персоны. 
_DataGenerator.person().get(Gender.MALE)_ - метод возвращает экземпляр FakePerson с заполненными полями.

**Паспортные данные**

_DataGenerator.documents().getRussianPassport()_ - метод возвращает экземпляр pro.dagen.documents.FakeRussianPassport

**СНИЛС**

_DataGenerator.documents().snils()_

**Расчетный счет**

_DataGenerator.accountDetails().account(PersoneType.PERSON, Currency.RUB, ProfileType.COMMERCIAL, DataGenerator.accountDetails().bank())_

**Банковские данные**

_DataGenerator.accountDetails().bank()_
Метод возвращает экземпляр класса pro.dagen.account.Bank

**ИНН для ФЛ**

_DataGenerator.accountDetails().inn12()_

**ИНН для ЮЛ**

_DataGenerator.accountDetails().inn10()_

**ОГРН для ЮЛ**

_DataGenerator.accountDetails().ogrn()_

**Номер мобильного телефона**

_DataGenerator.contacts().mobile()_
Возвращается строка в формате +7 XXX XXX XXXX;

**Номер городского телефона**

_DataGenerator.contacts().cityPhone()_
Возвращается строка в формате +7 XXX XXX XXXX;

**Адрес электронной почты**

_DataGenerator.contacts().email()_
Возвращается строка в формате <случайная комбинация>@<случайный домен>

_DataGenerator.contacts().email("test.ru")_
Возвращается строка в формате <случайная комбинация>@test.ru

**Как подключить библиотеку?**

&lt;dependency&gt;

    <groupId>pro.dagen</groupId>
    <artifactId>datagenerator</artifactId>        
    <version>1.0</version>
    
&lt;/dependency&gt;



