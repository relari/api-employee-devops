Feature: Sample Feature

  Scenario Outline: Use case - Delete employee with id = <idEmployee>
    Given url baseUrl + applicationApiPath + '/' + idEmployee
    When method DELETE
    Then status <statusCode>
  Examples:
    | idEmployee   | statusCode |
    | 0 | 204        |
    | 1 | 204        |

#    Then print 'The value of the list is: '