Feature: Tranzact automation testing API
  
  Background: 
    * url 'http://api.countrylayer.com/v2'
    * header Accept = 'application/json'
    * def expectedOutputGB = read("responseGB.json")
    
  #Simple get request for GB
  Scenario: Get only GB
    Given path '/name/United Kingdom of Great Britain and Northern Ireland'
    And param access_key = '6a90841bb1015b2a36ad776addbff791'
    When method GET
    Then status 200
    And match response  == expectedOutputGB
