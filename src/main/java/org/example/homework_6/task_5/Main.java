package org.example.homework_6.task_5;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateStr;
        System.out.println("Введите дату в формате yyyy-mm-dd");
        dateStr = in.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        if (checkHoliday(date) != null)
            System.out.println("Праздник! " + checkHoliday(date));
        System.out.println(checkDayOfWeak (date));
    }

    public static String checkHoliday (LocalDate date) {
        String holiday = null;
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        if (day == 1 && month == 1)
            holiday = "International Hangover Day";
        if (day == 1 && month == 9)
            holiday = "День знаний";
        if (day == 5 && month == 10)
            holiday = "День учителя";
        if (day == 31 && month == 12)
            holiday = "Новый год";

        return holiday;
    }
    public static String checkDayOfWeak (LocalDate date) {
        String dayOfWeak = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
        String dayOfWeakResult;
        switch (dayOfWeak) {
            case "суббота", "воскресенье":
                dayOfWeakResult = "Выходной!";
                break;

            case "пятница":
                dayOfWeakResult = "Пятница - это день, когда работа заканчивается и можно уйти с работы пораньше";
                break;
            case "четверг":
                dayOfWeakResult = "Четверг - это маленькая пятница";
                break;
            default:
                dayOfWeakResult = "Будний день";
                break;

        }

        return dayOfWeakResult;
    }

}
