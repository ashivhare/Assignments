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

Feature: Login Action
   
  @MultiWayFlightBookingTest
  Scenario Outline: Searching the flight for one way journey
    Given user is on clear trip search flight Page "<Browser>"
    When User click on "<TripType>"
    And User enters "<FromCity1>", "<ToCity1>", "<FromCity2>", "<ToCity2>", "<FromCity3>" and "<ToCity3>"
    And User enters "<DepartOn1>", "<DepartOn2>", "<DepartOn3>", "<AdultsCount>", "<ChildrenCount>", "<InfantsCount>" and "<ClassOfTravel>"
    Then User clicks on the searchflight button
    And User gets available flights for the given details

    Examples: 
      | Browser  | TripType | FromCity1  | ToCity1   | DepartOn1  |FromCity2  |  ToCity2   | DepartOn2 |FromCity3  |  ToCity3   | DepartOn3 | AdultsCount   | ChildrenCount   | InfantsCount  |ClassOfTravel|
		  | Mozilla  | MultiCity| Pune 	     | Mumbai	   |20-02-2019  |Mumbai		  | Delhi		   |29-03-2019 |Delhi		   | Chennai	  | 12-06-2019| 2			        |	1		        		| 1             |Economy	  |
    
    