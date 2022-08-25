Feature: Tranzact automation testing API
  
  Background: 
    * url 'http://api.countrylayer.com/v2'
    * header Accept = 'application/json'
    * def expectedOutPutrequest = read("responsePost.json")
    * def expectedOutNotFound = read("responseNotFound.json")
   
  
  #Post request - Happy path : with read response from file
  Scenario: Post request
    Given url 'http://api.countrylayer.com/v2'
    And request {name: "Test Country",alpha2_code: "TC",alpha3_code: "TCY"}
    And param access_key = '6a90841bb1015b2a36ad776addbff791'
    When method Post
    Then status 200
    And print response
    And match response  == expectedOutPutrequest
 
