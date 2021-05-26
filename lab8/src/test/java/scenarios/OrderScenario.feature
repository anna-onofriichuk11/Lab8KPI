@ApiTests
Feature: Api testing with help of Cucumber

  Scenario: Get gender name by person name
    Given name is "anna"
    When user try to get name by id
    Then user receive status code 200
    And response don't equal zero


  Scenario: Get gender name by person name FAIL
    Given name is "kfmrellr"
    When user try to get name by id
    Then user receive status code 201
    And response don't equal zero