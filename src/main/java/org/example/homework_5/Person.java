package org.example.homework_5;

import java.util.List;

public class Person {
    private String phone, name, surname, address;
    private List<String> email;

    public Person(String phone, String name, String surname, String address, List<String> email) {
        this.phone = phone;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public void Print () {

        System.out.print("Фамилия и имя: ");
        System.out.print(surname + " "+name+", ");
        System.out.print("номер телефона: ");
        System.out.print(phone + ", ");
        System.out.print("Адреса электронной почты: ");
        System.out.print(email);
        System.out.print(", Адрес проживания: ");
        System.out.print(address);

    }
}

