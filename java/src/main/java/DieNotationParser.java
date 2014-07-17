import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DieNotationParser {
    private static final Pattern pattern = Pattern.compile("(\\d*)?d([1-9][\\d]*)\\+?(\\d+)?");
    private Matcher matches;
    private boolean valid;

    public DieNotationParser(String notation) {
        matches = pattern.matcher(notation);
        valid = matches.find();
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public int rolls() {
        int r;
        try {
            r = Integer.parseInt(matches.group(1));
        }
        catch (NumberFormatException e) {
            // default
            r = 1;
        }
        return r;
    }

    public int faces() {
        int f;
        try {
            f = Integer.parseInt(matches.group(2));
        }
        catch (NumberFormatException e) {
            // default
            f = 1;
        }
        return f;
    }

    public int bonus() {
        int b;
        try {
            b = Integer.parseInt(matches.group(3));
        }
        catch (NumberFormatException e) {
            // default
            b = 0;
        }
        return b;
    }

}
