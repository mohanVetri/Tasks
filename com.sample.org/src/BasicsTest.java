import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BasicsTest {
    @Test
    public void verify_BasicObject_NotNull(){
        Basic basic =new Basic();
        assertNotNull(basic);
    }

    @Test
    public void grading_Shows_Position(){
        Basic basic =new Basic ();
        String position=basic.grading('A');
        assertEquals("First class",position);
    }

    @Test
    public void sum_OfTen_NaturalNumbers(){
        Basic basic =new Basic ();
        int Total=basic.sum();
        assertEquals(55,Total);
    }

    @Test
    public void sumWithBreak_StopAtSomeIndex_NaturalNumbers(){
        Basic basic =new Basic ();
        int totalBeforeIndex=basic.sumWithBreak(3);
        assertEquals(3,totalBeforeIndex);
        }

    @Test
    public void sumWithContinue_SkipAtIndex_NaturalNumbers(){
        Basic basic =new Basic ();
        int totalWithoutIndex=basic.sumWithContinue(3);
        assertEquals(52,totalWithoutIndex);
    }

    @Test
    public void sumOfMatrixWithBreak_StopAtIndex_RowOfMatrix(){
        Basic basic =new Basic ();
        int sumOfElementsInMatrix=basic.labelWithBreak(2);
        assertEquals(11,sumOfElementsInMatrix);
    }

    @Test
    public void SumOfMatrixWithContinue_SkipAtIndex_RowOfMatrix(){
        Basic basic =new Basic ();
        int sumOfElementsInMatrix=basic.labelWithContinue(0);
        assertEquals(7,sumOfElementsInMatrix);
    }
}
