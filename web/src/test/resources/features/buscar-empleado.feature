Feature: get demos

  Scenario Outline: Use case - Get employee by id = <idEmployee>
    Given url baseUrl + applicationApiPath + '/' + idEmployee
    When method GET
    Then status <statusCode>
  Examples:
    | idEmployee   | statusCode |
    | 0 | 500        |
    | 1 | 200        |