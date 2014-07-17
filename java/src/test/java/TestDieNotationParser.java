import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class TestDieNotationParser {
            
    @Test
    public void testNormalEntries() {
        DieNotationParser dnp = new DieNotationParser("d6");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 1);
        assertTrue(dnp.faces() == 6);
        assertTrue(dnp.bonus() == 0);

        dnp = new DieNotationParser("30d10");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 30);
        assertTrue(dnp.faces() == 10);
        assertTrue(dnp.bonus() == 0);
        
        dnp = new DieNotationParser("d6+1");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 1);
        assertTrue(dnp.faces() == 6);
        assertTrue(dnp.bonus() == 1);
        
        dnp = new DieNotationParser("30d10+99");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 30);
        assertTrue(dnp.faces() == 10);
        assertTrue(dnp.bonus() == 99);
    }

    @Test
    public void testOddEntries() {
        DieNotationParser dnp = new DieNotationParser("0d6");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 0);
        assertTrue(dnp.faces() == 6);
        assertTrue(dnp.bonus() == 0);
        
        dnp = new DieNotationParser("0d10+0");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 0);
        assertTrue(dnp.faces() == 10);
        assertTrue(dnp.bonus() == 0);
        
        dnp = new DieNotationParser("d6-1");
        assertTrue(dnp.isValid() == true);
        assertTrue(dnp.rolls() == 1);
        assertTrue(dnp.faces() == 6);
        assertTrue(dnp.bonus() == 0);
    }

    @Test
    public void testInvalidEntries() {
        DieNotationParser dnp = new DieNotationParser("d0");
        assertTrue(dnp.isValid() == false);
        
        dnp = new DieNotationParser("abc");
        assertTrue(dnp.isValid() == false);
        
        dnp = new DieNotationParser("6d");
        assertTrue(dnp.isValid() == false);
    }

}
