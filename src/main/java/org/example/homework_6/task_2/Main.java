package org.example.homework_6.task_2;

import org.example.homework_6.task_1.DateValidatorUsingLocalDate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateStr;
        LocalDate date;
        System.out.println("Введите дату рождения в формате yyyy-mm-dd");
        dateStr = in.nextLine();
        DateValidatorUsingLocalDate dateValid = new DateValidatorUsingLocalDate(DateTimeFormatter.ISO_LOCAL_DATE);
        if (dateValid.isValid(dateStr)) {
            date = LocalDate.parse(dateStr);
        }
        else {
            Boolean chek;
            do {
                System.out.println("Введенные данные некорректны.");
                System.out.println("Введите дату рождения в формате yyyy-mm-dd");
                dateStr = in.nextLine();
                chek = dateValid.isValid(dateStr);
            }
            while (!chek);
            date = LocalDate.parse(dateStr);

        }
        List<String> DateAndAgeResult = new ArrayList<String>();
        DateAndAgeResult = DateAndAge(date);
        for(String result : DateAndAgeResult){
            System.out.println(result);
        }

    }
    public static List<String> DateAndAge (LocalDate date) {
        LocalDate dateNow = LocalDate.now();
        List<String> DateAndAge = new ArrayList<String>();
        int age = -1;
        for (int year = date.getYear(); year<= dateNow.getYear(); year = year +1) {
            age = age +1;
            if (year%4==0 && year%100 !=0 || year%400==0) {
                DateAndAge.add(date.getDayOfMonth() + " "+ date.getMonth()+ " " + year + " " + age +" лет");
            }
        }
        return DateAndAge;

    }
}
