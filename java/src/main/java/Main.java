public class Main {
    
    public static void main(String [] args) {
        // Usage by default.
        String output = "Usage:\n\tdice [[x]dy[+z]]";
        Die d;
        
        if (args.length >= 1) {
            DieNotationParser parser = new DieNotationParser(args[0]);
            if (parser.isValid()) {
                d = new Die(parser.faces());
                output = String.format("%d", parser.rolls()*d.roll()+parser.bonus());
            }
            // else usage.
        }
        else {
            // default
            d = new Die();
            output = String.valueOf(d.roll());
        }
        System.out.printf("%s\n", output);
    }
    
}
