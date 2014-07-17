import java.util.*;

public class Die {
    private int faces;
    public Random rand = new Random();
    
    public Die() {
        faces = 6;
    }
    
    public Die(int numFaces) {
        faces = numFaces;
    }
    
    public int getFaces() {
        return this.faces;
    }
    
    public void setRand(Random rand) {
        this.rand = rand;
    }
    
    public int roll() {
        return rand.nextInt(faces) + 1;
    }
    
}
