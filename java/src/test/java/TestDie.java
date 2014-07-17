import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class TestDie {
    
    private Die d;

    private static class MinRandom extends Random {
        public int nextInt(int n) {
            // 0 inclusive in random number generation.
            return 0;
        }
    }
    
    private static class MaxRandom extends Random {
        public int nextInt(int n) {
            // Exclusive max.
            return n-1;
        }
    }
    
    @Before
    public void setUp() {
        d = new Die();
    }
    
    @After
    public void tearDown() {
        d = null;
    }
    
    @Test
    public void testFaces() {
        assertEquals(d.getFaces(), 6);
        
        Die d2 = new Die(20);
        assertEquals(d2.getFaces(), 20);
    }

    @Test
    public void testRoll() {
        d.setRand(new MinRandom());
        // Test that logic works by removing random.
        assertEquals(d.roll(), 1);
        
        d.setRand(new MaxRandom());
        assertEquals(d.roll(), d.getFaces());
    }
}
