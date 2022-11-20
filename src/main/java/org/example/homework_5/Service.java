package org.example.homework_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
public class Service {
    public static void cls() {
        System.out.print("\033[H\033[J");

    }

    private static Repository repository;
    public static int number, num, numNew;
    public static void work() {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер меню:");
        System.out.println("1 - Вывести всех людей и их данные");
        System.out.println("2 - Найти человека по имени, номеру телефона, электронной почте");
        System.out.println("3 - Добавить человека");
        System.out.println("4 - Удалить человека с определенным номером телефона");
        System.out.println("5 - Редактировать данные участника с определенным номером телефона");
        System.out.println("6 - Завершить выполнение");
        number = Integer.parseInt(in.nextLine());
        switch (number) {
            //вывод справочника
            case 1:
                System.out.println("Справочник: ");
                repository.PrintAll();
                System.out.println();
                System.out.println("1 - вернуться в главное меню");
                num = Integer.parseInt(in.nextLine());
                if (num == 1) {
                    Service.cls();
                    Service.work();
                }
                break;
            //Найти человека по имени, номеру телефона, электронной почте
            case 2:
                System.out.println("По какому параметру ищем?");
                System.out.println("1 - по имени");
                System.out.println("2 - по номеру телефона");
                System.out.println("3 - по почте");
                int numberSearch = Integer.parseInt(in.nextLine());
                System.out.println("Введите данные для поиска:");
                String stringForSearch = in.nextLine();
                List<Person> personsFind = Service.findPersonNamePhoneEmail(numberSearch, stringForSearch);
                System.out.println();
                System.out.println("1 - вернуться в главное меню");
                num = Integer.parseInt(in.nextLine());
                if (num == 1) {
                    Service.cls();
                    Service.work();
                }
                break;
            //добавить человека
            case 3:
                System.out.println("Введите номер телефона:");
                String newPhone = in.nextLine();
                Person personNew = repository.findPhone(newPhone);
                if (personNew != null) {
                    System.out.println("Запись с таким телефоном уже существует.");
                    personNew.Print();
                    System.out.println(" ");
                    System.out.println("Выберите дальнейшие действия: 1 - вернуться в главное меню, " +
                            "2 - редактировать имеющегося участника");
                    numNew = Integer.parseInt(in.nextLine());
                    if (numNew == 1) {
                        Service.cls();
                        Service.work();
                    }
                    if (numNew == 2) {
                        System.out.println("Какой параметр редактируем? " +
                                "1 - номер телефона, 2 - имя и фамилию, 3 - электронную почту, 4 - адрес проживания.");
                        int numCor = Integer.parseInt(in.nextLine());
                        personNew = correctPersonNamePhoneEmail(numCor, personNew);
                    }
                    System.out.println(" ");
                    System.out.println("1 - вернуться в главное меню");
                    num = Integer.parseInt(in.nextLine());
                    if (num == 1) {
                        Service.cls();
                        Service.work();
                    }

                }
                //вводим нового человека
                else {
                    System.out.println("Введите имя: ");
                    String nameNew = in.nextLine();
                    System.out.println("Введите фамилию: ");
                    String surnameNew = in.nextLine();
                    System.out.println("Введите адрес: ");
                    String addressNew = in.nextLine();
                    List<String> emailNew = new ArrayList<>();
                    System.out.println("Введите количество email:");
                    int emailNumber = Integer.parseInt(in.nextLine());
                    System.out.println("Введите email:");
                    for (int i = 0; i < emailNumber; i++) {
                        String s = in.nextLine();
                        emailNew.add(s);
                    }
                    Person personNewest = new Person(newPhone, nameNew, surnameNew, addressNew, emailNew);
                    personNewest.Print();
                    repository.addPerson(personNewest);
                    System.out.println(" ");
                    System.out.println("1 - вернуться в главное меню");
                    num = Integer.parseInt(in.nextLine());
                    if (num == 1) {
                        Service.cls();
                        Service.work();
                    }

                }
                break;
            // удаление записи
            case 4:
                System.out.println("Введите номер телефона:");
                String dellPhone = in.nextLine();
                Person personDell = repository.findPhone(dellPhone);
                if (personDell != null) {
                    personDell.Print();
                    System.out.println(" ");
                    System.out.println("Удалить запись? 1 - да, 2 - нет.");
                    int numDell = Integer.parseInt(in.nextLine());
                    if (numDell == 1) {
                        repository.dellPerson(dellPhone);
                        System.out.println("Запись удалена.");
                    }
                    else {
                        System.out.println("1 - вернуться в главное меню");
                        num = Integer.parseInt(in.nextLine());
                        if (num == 1) {
                            Service.cls();
                            Service.work();
                        }
                    }
                } else {
                    System.out.println("Записи с таким номером телефона не существует.");
                    System.out.println("1 - вернуться в главное меню");
                    num = Integer.parseInt(in.nextLine());
                    if (num == 1) {
                        Service.cls();
                        Service.work();
                    }
                }
                break;
            //Редактировать данные участника с определенным номером телефона
            case 5:
                System.out.println("Введите номер телефона:");
                String phoneToCorrect = in.nextLine();
                Person personToCorrect = repository.findPhone(phoneToCorrect);
                if (personToCorrect != null) {
                    System.out.println("Запись для редактирования:");
                    personToCorrect.Print();
                    System.out.println(" ");
                    System.out.println("Выберите дальнейшие действия: 1 - вернуться в главное меню, " +
                            "2 - редактировать участника");
                    int numToCorrect = Integer.parseInt(in.nextLine());
                    if (numToCorrect == 1) {
                        Service.cls();
                        Service.work();
                    }
                    if (numToCorrect == 2) {
                        System.out.println("Какой параметр редактируем? " +
                                "1 - номер телефона, 2 - имя и фамилию, 3 - электронную почту, 4 - адрес проживания.");
                        int numCor = Integer.parseInt(in.nextLine());
                        personToCorrect = correctPersonNamePhoneEmail(numCor, personToCorrect);
                        System.out.println(" ");
                        System.out.println("1 - вернуться в главное меню");
                        num = Integer.parseInt(in.nextLine());
                        if (num == 1) {
                            Service.cls();
                            Service.work();
                        }
                    }
                }
                else {
                    System.out.println("Записи с таким номером не существует.");
                    System.out.println(" ");
                    System.out.println("1 - вернуться в главное меню");
                    num = Integer.parseInt(in.nextLine());
                    if (num == 1) {
                        Service.cls();
                        Service.work();
                    }
                }
                break;

            case 6:
                System.out.println("До свидания! Хорошего дня!");
                break;


        }

    }
    //Найти человека по имени, номеру телефона, электронной почте
    public static List<Person> findPersonNamePhoneEmail(int numberSearch, String stringForSearch) {
        List<Person> selectedPersons = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int num;
        switch (numberSearch) {
            // поиск по имени
            case 1:

                selectedPersons = repository.findName(stringForSearch);
                for (Person person1 : selectedPersons) {
                    person1.Print();
                    System.out.println(" ");
                }
                if (selectedPersons == null) {
                    System.out.println("Запись не найдена");
                }

                break;
            // поиск по номеру телефона
            case 2:
                Person person2 = repository.findPhone(stringForSearch);

                if (person2 == null) {
                    System.out.println("Запись не найдена");
                } else person2.Print();
                selectedPersons.add(person2);

                break;
            // поиск по почте
            case 3:
                Person person3 = repository.findEmail(stringForSearch);

                if (person3 == null) {
                    System.out.println("Запись не найдена");
                } else person3.Print();
                selectedPersons.add(person3);

                break;
        }

        return selectedPersons;
    }
    //редактировать имеющегося участника
    public static Person correctPersonNamePhoneEmail (int numCor, Person personNew){
        Scanner in = new Scanner(System.in);
        switch (numCor) {
            // редактируем номер телефона
            case 1:
                System.out.println("Введите новый номер: ");
                String phoneCor = in.nextLine();
                Person personCor = repository.findPhone(phoneCor);
                if (personCor != null) {
                    System.out.println("Такой номер уже занят. Не хотите изменить другие данные?");
                    System.out.println("1- вернуться в главное меню, 2 - имя и фамилию, 3 - электронную почту, 4 - адрес проживания.");
                    numNew = Integer.parseInt(in.nextLine());
                    if (numNew == 1) {
                        Service.cls();
                        Service.work();
                    } else numCor = numNew;
                } else {
                    personNew.setPhone(phoneCor);
                    personNew.Print();
                    System.out.println(" ");
                }
                break;
                // редактируем имя и фамилию
            case 2:
                System.out.println("Введите новое имя: ");
                String nameCor = in.nextLine();
                System.out.println("Введите новую фамилию: ");
                String surnameCor = in.nextLine();
                personNew.setName(nameCor);
                personNew.setSurname(surnameCor);
                personNew.Print();
                System.out.println(" ");
                break;
            // редактируем почту
            case 3:
                System.out.println(personNew.getEmail());
                List<String> emailNew = personNew.getEmail();
                System.out.println("Введите порядковый номер почты:");
                int emailNumber = Integer.parseInt(in.nextLine());
                System.out.println("Введите новую почту:");
                String emailCor = in.nextLine();
                emailNumber = emailNumber - 1;
                emailNew.set(emailNumber, emailCor);
                personNew.setEmail(emailNew);
                personNew.Print();
                break;
            //редактируем адрес
            case 4:
                System.out.println("Введите новый адрес: ");
                String addressCor = in.nextLine();
                personNew.setAddress(addressCor);
                personNew.Print();
                break;
        }
        return personNew;
    }
    public Service(Repository repository) {
        this.repository = repository;
    }
}

