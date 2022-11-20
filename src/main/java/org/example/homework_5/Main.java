package org.example.homework_5;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(new Repository());
        service.work();
    }
}
