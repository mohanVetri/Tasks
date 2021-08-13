import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SbiBankTest {
    @Test
    public void test_SbiObject_NotNull(){
        RbiBank sbiBank = new SbiBank();
        assertNotNull(sbiBank);
    }

    @Test
    public void test_Interest_ReturnsInteger(){
        RbiBank sbiBank = new SbiBank();
        int interest=sbiBank.interest();
        assertTrue(Integer.class.isInstance(interest));
    }

    @Test
    public void test_Interest_OfSbiBank(){
        RbiBank sbiBank = new SbiBank();
        int interest=sbiBank.interest();
        assertEquals(14,interest);
    }

    @Test
    public void test_TypeOfBank_ReturnsString(){
        RbiBank sbiBank = new SbiBank();
        String bankType=sbiBank.typeOfBank();
        assertTrue(String.class.isInstance(bankType));
    }
    
    @Test
    public void test_TypeOfBank(){
        SbiBank sbiBank = new SbiBank();
        String bankType=sbiBank.getRbitypeOfBank();
        assertEquals("Government Bank",bankType);
    }
}
