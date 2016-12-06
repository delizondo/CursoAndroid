Feature: Login feature

  Scenario: As a user I do a search
    Given the app has launched
    Then I press view with id "search"
    Then I search for the movie "Batman"
    Then I press view with id "button1"
    Then I wait for 5 seconds
    Then I should see "Batman Begins"
