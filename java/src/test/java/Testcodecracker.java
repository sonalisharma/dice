/**
 * Created by sonalisharma on 7/17/14.
 */

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;
public class Testcodecracker {

    @Test
    public void generate4digitRandomNumber()
    {
        Codecraker c = new Codecraker();
        assertEquals(4, c.generateNumber().length);
    }

    @Test
    public void numberShouldBeRandom()
    {
        Codecraker c = new Codecraker();
        int[] number1 = c.generateNumber();
        int[] number2 = c.generateNumber();
        assertNotEquals(number1, number2);
    }

    @Test
    public void digitsShouldBeUnique()
    {
        Codecraker c = new Codecraker();
        int[] number1 = c.generateNumber();
        boolean flag = false;
        HashMap<Integer,Integer> hm = new HashMap();
        for(int i=0;i<number1.length;i++)
        {
            if(hm.containsKey(number1[i]))
            {
                flag = true;
                break;
            }
            else
            {
                hm.put((Integer)number1[i],0);
            }
        }
        assertFalse(flag);
    }

    @Test
    public void abcIsInInvalidInput()
    {
        Codecraker c = new Codecraker();
        assertFalse(c.validateNumber("abc"));
    }

    @Test
    public void _1234IsValidInput()
    {
        Codecraker c = new Codecraker();
        assertTrue(c.validateNumber("1234"));
    }

    @Test
    public void _12345IsInValidInput()
    {
        Codecraker c = new Codecraker();
        assertFalse(c.validateNumber("12345"));
    }

    @Test
    public void guess2345ForCorrectNumber5378ShouldReturn2100()
    {
        Codecraker c = new Codecraker();
        assertEquals("2100",c.generateClue("2345"));
    }

    @Test
    public void guess2348ForCorrectNumber5378ShouldReturn2210()
    {
        Codecraker c = new Codecraker();
        assertEquals("2210",c.generateClue("2345"));
    }

}
