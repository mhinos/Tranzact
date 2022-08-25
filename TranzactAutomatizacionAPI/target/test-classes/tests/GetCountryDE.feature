Feature: Tranzact automation testing API
  
  Background: 
    * url 'http://api.countrylayer.com/v2'
    * header Accept = 'application/json'
    * def expectedOutputDE = read("responseDE.json")
 
    
  #Simple get request for DE
  Scenario: Get only Germany
    Given path '/name/Germany'
    And param access_key = '6a90841bb1015b2a36ad776addbff791'
    When method GET
    Then status 200
    And match response  == expectedOutputDE