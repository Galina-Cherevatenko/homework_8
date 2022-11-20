package testing;
import org.example.homework_6.task_2.Main;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class task_6_2_Test {

    @Test
    public void DateAndAgeTest (){
        // given

        LocalDate date = LocalDate.parse("2011-01-19");
        List<String> DateAndAgeExpected = new ArrayList<String>();
        List<String> DateAndAgeResult = new ArrayList<String>();
        DateAndAgeExpected.add("19 JANUARY 2012 1 лет");
        DateAndAgeExpected.add("19 JANUARY 2016 5 лет");
        DateAndAgeExpected.add("19 JANUARY 2020 9 лет");

        //when
        DateAndAgeResult = Main.DateAndAge(date);

        // then
        assertEquals(DateAndAgeExpected, DateAndAgeResult);

    }
}
