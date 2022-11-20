package testing;
import org.junit.Test;

import static org.example.homework_1.task1.Main.dohodCount;
import static org.junit.Assert.assertEquals;

public class DohodTest {
    @Test
     public void testdohodCountMethod (){
        // given
        double result = 100182.58;
        double Summa = 1000000;
        int procent = 5;
        int n=2;


        //when
        double actualResult = dohodCount (Summa, procent, n);

        // then
        assertEquals(result, actualResult, 1e-2);


    }
}