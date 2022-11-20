package org.example.homework_6.task_4;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1, num2;
        Set<String> zone = ZoneId.getAvailableZoneIds();
        List<String> listZone = new ArrayList<>();
        listZone.addAll(zone);
        int number = listZone.size();
        System.out.println("Введите номера зон от 1 до "+ number);
        System.out.println("Первая зона:");
        num1 = Integer.parseInt(in.nextLine())-1;
        System.out.println("Вторая зона:");
        num2 = Integer.parseInt(in.nextLine())-1;
        if ((num1>0)&&(num1<=number)&&(num2>0)&&(num2<number)){
            ZoneId zoneId1 = ZoneId.of(listZone.get(num1));
            ZonedDateTime timeZone1 = ZonedDateTime.now(zoneId1);
            System.out.println(timeZone1);
            ZoneId zoneId2 = ZoneId.of(listZone.get(num2));
            ZonedDateTime timeZone2 = ZonedDateTime.now(zoneId2);
            System.out.println(timeZone2);}
        else {
            Boolean chek;

            do {
                System.out.println("Введенные данные не корректны.");
                System.out.println("Введите номера зон от 1 до "+ number);
                System.out.println("Первая зона:");
                num1 = Integer.parseInt(in.nextLine())-1;
                System.out.println("Вторая зона:");
                num2 = Integer.parseInt(in.nextLine())-1;
                chek = (num1>0)&&(num1<=number)&&(num2>0)&&(num2<number);
            }
            while (!chek);
            ZoneId zoneId1 = ZoneId.of(listZone.get(num1));
            ZonedDateTime timeZone1 = ZonedDateTime.now(zoneId1);
            System.out.println(timeZone1);
            ZoneId zoneId2 = ZoneId.of(listZone.get(num2));
            ZonedDateTime timeZone2 = ZonedDateTime.now(zoneId2);
            System.out.println(timeZone2);
        }
    }
}
