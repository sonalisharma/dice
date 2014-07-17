Feature: CIA operation diffuse
  As a CIA agent Jack Bauer
  I want to a program to guess a 4 digit code
  So that I can prevent a russian bomb explosion at the white house

  Scenario: Create a four digit numeric code
    Given I run the programs for the first time
    When I hit enter
    Then the number generated should be between 0123 and 9876

  Scenario: The number is not displayed
    Given I run the programs for the first time
    When the number is generated
    Then the number is not displayed

  Scenario: Unique digits
    Given I run the programs for the first time
    When I hit enter
    Then the digits in the generated number should be unique

  Scenario: Displaying the result in proper order
    Given That I enter a number
    When the hint is shown
    Then the output should give 2 before 1 and 1 comes before 0

  Scenario: Invalid input
    Given that I start breaking the code with "1234"
    When I try to stop the nuke with the input "asnht"
    Then I should see the following prompt "Invalid input - code is only numbers"

  Scenario Outline: Guessing a number and win a game
    Given I start with a number 2356
    When I pass <argument> and the actual number is <correct_number>
    Then the output should be <result>

    Examples:
      | argument    | correct_number | result    |
      | 1478        | 2356           | (Guesses Remaining: 8) What is your guess? 0000   |
      | 3489        | 2356           | (Guesses Remaining: 7) What is your guess? 1000   |
      | 2489        | 2356           | (Guesses Remaining: 6) What is your guess? 2000   |
      | 2389        | 2356           | (Guesses Remaining: 5) What is your guess? 2200   |
      | 2360        | 2356           | (Guesses Remaining: 4) What is your guess? 2210   |
      | 2365        | 2356           | (Guesses Remaining: 4) What is your guess? 2211   |
      | 2356        | 2356           | You have guessed the secret code. You win!        |

  Scenario Outline: Guessing a number and lose a game
    Given I start with a number 2356
    When I pass <argument> and the actual number is <correct_number>
    Then the output should be <result>

    Examples:
      | argument    | correct_number | result    |
      | 1478        | 2356           | (Guesses Remaining: 8) What is your guess? 0000   |
      | 3489        | 2356           | (Guesses Remaining: 7) What is your guess? 1000   |
      | 2489        | 2356           | (Guesses Remaining: 6) What is your guess? 2000   |
      | 2389        | 2356           | (Guesses Remaining: 5) What is your guess? 2200   |
      | 2360        | 2356           | (Guesses Remaining: 4) What is your guess? 2210   |
      | 2013        | 2356           | (Guesses Remaining: 3) What is your guess? 2100   |
      | 9145        | 2356           | (Guesses Remaining: 2) What is your guess? 0000   |
      | 3456        | 2356           | (Guesses Remaining: 1) What is your guess? 2210   |
      | 2365        | 2356           | Sorry. You lost and destroyed the world. RUN!!!   |