Feature: get demos

  Scenario Outline: Use case - Save employee
    Given url baseUrl + applicationApiPath
    When header Content-Type = 'application/json'
#    And request { description: '<inputText>'}
    And request
    """
      {
          "firstName": "Renzo",
          "fatherLastName": "Lavado",
          "motherLastName": "Rivas",
          "gender": "M",
          "birthdate": "03-05-1995",
          "documentType": "DNI",
          "documentNumber":"70605398",
          "company" : {
              "jobTitle": "DEVELOPER",
              "salary": 2700.0
          },
          "address": {
              "email" :"renzolavador@gmail.com",
              "phoneNumber": "979896723"
          }
      }
    """
    When method POST
    Then status <statusCode>
    Examples:
      | inputText   | statusCode |
      | Description | 201        |
#      | Case with description is Hello       | Hello       | 201        |
#      | Case with description is World       | World       | 201        |
#      | Case with description is Text        | Text        | 201        |
#      | Case with description is Hello World | Hello World | 400        |
