**DATAGENERATOR**

Библиотека поозвляет генерировать следующие данные:

1. Персон различного пола. ФИО соотвествует гендеру персоны. Пример вызова:
   _DataGenerator.person().get(Gender.MALE)_ - метод возвращает экземпляр FakePerson с заполнеными полями.
2. Фейковые паспортные данные для паспортов РФ. Пример вызова:
   _DataGenerator.documents().getRussianPassport()_ - метод возвращает экземляр FakeRussianPassport 
