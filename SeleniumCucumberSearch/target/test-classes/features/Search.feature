Feature: Search functionality

  Scenario: Valid search term
    Given I am on the search page
    When I search for "Selenium"
    Then I should see results related to "Selenium"
    Then I close the search page

  Scenario: Invalid search term
    Given I am on the search page
    When I search for "dacwdyaboiwcutbAWfvaw"
    Then I should see no results
    Then I close the search page

  Scenario: Search suggestions
    Given I am on the search page
    When I type "Seleniu" in the search box
    Then I should see search suggestions related to "Selenium"
    Then I close the search page

  Scenario: Search results pagination
    Given I am on the search page
    When I search for "Selenium"
    And I navigate to the second page of search results
    Then I should see results related to "Selenium" on the second page
    Then I close the search page
