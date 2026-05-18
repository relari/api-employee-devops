Feature: get demos

  Scenario: Use case - List employees
    Given url baseUrl + applicationApiPath
    When method get
    Then status 200