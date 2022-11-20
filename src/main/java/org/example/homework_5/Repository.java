package org.example.homework_5;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static List<Person> Persons = new ArrayList<>();

    public Repository() {

    }
    // вывод всего справочника
    public void PrintAll () {
        for (Person person : Persons) {
            System.out.print("Фамилия и имя: ");
            System.out.print(person.getSurname() + " "+person.getName()+", ");
            System.out.print("номер телефона: ");
            System.out.print(person.getPhone() + ", ");
            System.out.print("Адреса электронной почты: ");
            System.out.print(person.getEmail());
            System.out.print(", Адрес проживания: ");
            System.out.print(person.getAddress());
        }
    }

    // поиск по номеру телефона
    public  Person findEmail (String email) {
        for (Person person : Persons) {
            if (person.getEmail().contains(email)) {
                return person;
            }
        }
        return null;
    }
    // поиск по имени и фамилии
    public List<Person> findName (String name) {
        List<Person> selectedPersons = new ArrayList<>();
        for (Person person : Persons) {
            if ((person.getName().equals(name)) || (person.getSurname().equals(name))) {
                selectedPersons.add(person);
            }

        }
        return selectedPersons;
    }
    // поиск по почте
    public  Person findPhone (String phone) {
        for (Person person : Persons) {
            if (person.getPhone().equals(phone)) {
                return person;
            }
        }
        return null;
    }

    //add - добавляет запись
    public void addPerson (Person newPerson) {

        Persons.add(newPerson);
    }

    //dell - удаляет запись по номеру телефона
    public  void dellPerson (String phone) {
        for (Person person : Persons) {
            if (person.getPhone().equals(phone)) {
                Persons.remove(person);
            }
        }
    }
    public List<Person> getAllPersons() {
        return new ArrayList<>(Persons);
    }
}

