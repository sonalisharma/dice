import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiceStepdefs {
    
    private static String diceCmd = "java -cp target/dice.jar Main %s";
    
    private int howMany;
    private String progArg;
    private String[] stdouts;
    
    private String runCommand() throws Throwable {
        String line;
        String stdout = "";
        String cmd = String.format(diceCmd, progArg);
        Process pr = Runtime.getRuntime().exec(cmd);

        int retVal = pr.waitFor();
        assertEquals(retVal, 0);

        BufferedReader bufferedStdout = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while((line = bufferedStdout.readLine()) != null) {
            stdout += line;
        }
        bufferedStdout.close();
        pr.destroy();
        
        return stdout;
    }
    
    @Given("^I run the program \"(\\d+)\" times$")
    public void I_run_the_program_n_times(int times) throws Throwable {
        howMany = times;
        stdouts = new String[times];
    }
            
    @When("^I pass (.*)$")
    public void I_pass(String argument) throws Throwable {
        progArg = argument.trim();
        
        // Run the program n times, collect results here for comparison.
        for (int i = 0; i < howMany; i++) {
            stdouts[i] = runCommand();
        }
    }

    @Then("^I should be within (\\d+) and (\\d+)$")
    public void I_should_be_within(int min, int max) throws Throwable {
        for (int i = 0; i < stdouts.length; i++) {
            int val = Integer.parseInt(stdouts[i].trim());
            assertTrue(val >= min);
            assertTrue(val <= max);
        }
    }

    @Then("^I should see the usage$")
    public void I_should_see_the_usage() throws Throwable {
        Pattern pattern = Pattern.compile("^Usage:.*");        
        for (int i = 0; i < stdouts.length; i++) {
            Matcher usageMatch = pattern.matcher(stdouts[i]);
            assertTrue(usageMatch.find());
        }
    }
    
}
