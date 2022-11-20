package testing;

import org.example.homework_6.task_5.Main;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class Task_6_5_Test {
    @Test
    public void checkHolidayTest () {
        // given

        String expectedResult = "День знаний";
        LocalDate date = LocalDate.parse("2022-09-01");


        //when
        String actualResult = Main.checkHoliday(date);

        // then
        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void checkDayOfWeakTest () {
        // given

        String expectedResult = "Четверг - это маленькая пятница";
        LocalDate date = LocalDate.parse("2022-09-01");


        //when
        String actualResult = Main.checkDayOfWeak(date);

        // then
        assertEquals(expectedResult, actualResult);

    }
}
