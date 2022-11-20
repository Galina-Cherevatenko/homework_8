package org.example.homework_6.task_1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateStr;
        System.out.println("Введите дату в формате yyyy-mm-dd");
        dateStr = in.nextLine();
        DateValidatorUsingLocalDate dateValid = new DateValidatorUsingLocalDate(DateTimeFormatter.ISO_LOCAL_DATE);
        if (dateValid.isValid(dateStr)) {

            System.out.println(dayOfWeakReturn(dateStr));
        } else {
            Boolean chek;

            do {
                System.out.println("Введенные данные некорректны.");
                System.out.println("Введите дату в формате yyyy-mm-dd");
                dateStr = in.nextLine();
                chek = dateValid.isValid(dateStr);
            }
            while (!chek);
            System.out.println(dayOfWeakReturn(dateStr));
        }
    }

    public static String dayOfWeakReturn (String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        String dayOfWeak = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
        return dayOfWeak;

    }
}




