Feature: Tranzact automation testing API
  
  Background: 
    * url 'http://api.countrylayer.com/v2'
    * header Accept = 'application/json'
    * def expectedOutNotFound = read("responseNotFound.json")
 
 
  
  #Try to get information for inexistent countries and validate the response
  Scenario: Get unexistent country
    Given url 'http://api.countrylayer.com/v2/name/MFHV'
    And param access_key = '6a90841bb1015b2a36ad776addbff791'
    When method GET
    Then status 404
    And print response
    And match response == expectedOutNotFound