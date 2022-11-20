package testing;
import org.example.homework_6.task_1.DateValidatorUsingLocalDate;
import org.example.homework_6.task_1.Main;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class task_6_1_Test {
    private static DateValidatorUsingLocalDate dateValid = new DateValidatorUsingLocalDate(DateTimeFormatter.ISO_LOCAL_DATE);

    @Test
    public void isValidTestForCorrectFormat() {
        // given

        String correctDate = "2022-12-01";
        boolean expectedResult = true;


        //when
        boolean actualResult = dateValid.isValid(correctDate);

        // then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void isValidTestForIncorrectFormat() {
        // given

        String correctDate = "20221201";
        boolean expectedResult = false;


        //when
        boolean actualResult = dateValid.isValid(correctDate);

        // then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void dayOfWeakReturnTest() {
        // given

        String dateStr = "2022-11-04";
        String expectedResult = "пятница";


        //when
        String actualResult = Main.dayOfWeakReturn(dateStr);

        // then
        assertEquals(expectedResult, actualResult);

    }
}
