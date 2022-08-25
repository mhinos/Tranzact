Feature: Tranzact automation testing API
  
  Background: 
    * url 'http://api.countrylayer.com/v2'
    * header Accept = 'application/json'
    * def expectedOutputUS = read("responseUS.json")
    
  #Simple get request for US
  Scenario: Get only USA
    Given path '/name/United States of America'
    And param access_key = '6a90841bb1015b2a36ad776addbff791'
    When method GET
    Then status 200
    And print response
    And match response  == expectedOutputUS