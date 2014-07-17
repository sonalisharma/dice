Feature: Dice Rolling program
    As a game player
    I want a script that rolls dice for me
    So that I can write some tests

    Scenario Outline: Correct usage
        Given I run the program "10" times
        When I pass <argument>
        Then I should be within <min> and <max>
        
        Examples:
            | argument    | min | max |
            |             | 1   | 6   |
            | d6          | 1   | 6   |
            | 2d6         | 2   | 12  |
            | 2d6+1       | 3   | 13  |
            
    Scenario Outline: Incorrect usage
        Given I run the program "1" times
        When I pass <argument>
        Then I should see the usage
        
        Examples:
            | argument    |
            | abc         |
            | d0          |

        