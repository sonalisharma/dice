import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class codecrackerStepdefs {

    private static String codecrackerCmd = "java -cp target/codecracker.jar Main %s";

    private int howMany;
    private String progArg;
    private String[] stdouts;

    private String runCommand() throws Throwable {
        String line;
        String stdout = "";
        String cmd = String.format(codecrackerCmd, progArg);
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

    @Given("^I run the programs for the first time$")
    public void I_run_the_programs_for_the_first_time() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I hit enter$")
    public void I_hit_enter() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the number generated should be between (\\d+) and (\\d+)$")
    public void the_number_generated_should_be_between_and(int arg1, int arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^the number is generated$")
    public void the_number_is_generated() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the number is not displayed$")
    public void the_number_is_not_displayed() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the digits in the generated number should be unique$")
    public void the_digits_in_the_generated_number_should_be_unique() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^That I enter a number$")
    public void That_I_enter_a_number() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^the hint is shown$")
    public void the_hint_is_shown() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the output should give (\\d+) before (\\d+) and (\\d+) comes before (\\d+)$")
    public void the_output_should_give_before_and_comes_before(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^that I start breaking the code with \"([^\"]*)\"$")
    public void that_I_start_breaking_the_code_with(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I try to stop the nuke with the input \"([^\"]*)\"$")
    public void I_try_to_stop_the_nuke_with_the_input(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I should see the following prompt \"([^\"]*)\"$")
    public void I_should_see_the_following_prompt(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I start with a number (\\d+)$")
    public void I_start_with_a_number(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I pass (\\d+) and the actual number is (\\d+)$")
    public void I_pass_and_the_actual_number_is(int arg1, int arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the output should be \\(Guesses Remaining: (\\d+)\\) What is your guess\\? (\\d+)$")
    public void the_output_should_be_Guesses_Remaining_What_is_your_guess(int arg1, int arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the output should be You have guessed the secret code. You win!$")
    public void the_output_should_be_You_have_guessed_the_secret_code_You_win() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the output should be Sorry. You lost and destroyed the world. RUN!!!$")
    public void the_output_should_be_Sorry_You_lost_and_destroyed_the_world_RUN_() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
