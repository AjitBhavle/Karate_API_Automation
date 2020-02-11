#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test Employee API's
	Background:
		* url apiURL
		* def createData = read('classpath:com/altimetrik/microserivces/orchestration/createEmp.json')
  	* print apiURL
	
  Scenario: Create Employee

  
    Given url apiURL
    And path 'api/users'
    And request createData
    When method POST
    Then status 201
    And match response contains {name:"Ajit Bhavle",job:"SDET"}
    And print response.name 
    
    
  Scenario: Get all employee data
    Given url apiURL
    And path 'api/users?page=2' 
    When method get
    Then status 200
