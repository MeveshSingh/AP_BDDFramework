Feature: Test end to end git repository functionality

  Scenario: create a new repository
    Given user create a new repository by entering repo name,desc, homepage, repo type and issue type
    When user hit post request
    Then user validate status "postcode" is 201
    And user validate status "line" is "HTTP/1.1 201 Created"
    And user validate response body
    And user validate response content type header is "application/json; charset=utf-8"

  Scenario: verify user is created or not
    Given user get request specification object and add bearer token
    When user hit get request
    Then user validate status "getcode" is 200
    And user validate status "getline" is "HTTP/1.1 200 OK"
    And user validate response body
    And user validate response content type header is "application/json; charset=utf-8"

  Scenario: update repository name
    Given user get request specification object and add bearer token and user added latest repo name
    When user hit patch request
    Then user validate status "patchcode" is 200
    And user validate status "patchline" is "HTTP/1.1 200 OK"
    And user validate response body
    And user validate response content type header is "application/json; charset=utf-8"

  Scenario: verify user is created or not
    Given user get request specification object and add bearer token
    When user hit get request
    Then user validate status "getcode" is 200
    And user validate status "getline" is "HTTP/1.1 200 OK"
    And user validate response body
    And user validate response content type header is "application/json; charset=utf-8"
    
   Scenario: delete created respository
    Given user get request specification object and add bearer token
    When user hit delete request
    Then user validate status "deletecode" is 204
    And user validate status "deleteline" is "HTTP/1.1 204 No Content"
    
    
