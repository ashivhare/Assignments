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

Feature: Flight Booking
   
 @ReturnFlightBookingTest
  Scenario Outline: Searching the flight for round trip journey
    Given user is on clear trip search flight Page "<Browser>"
    When User click on "<TripType>"
    And User enters "<FromCity>" and "<ToCity>"
    And User enters "<DepartOn>", "<ReturnOn>", "<AdultsCount>", "<ChildrenCount>", "<InfantsCount>", "<ClassOfTravel>"
    Then User clicks on the searchflight button
    And User gets available flights for the given details

    Examples: 
      | Browser  | TripType | FromCity  | ToCity   | DepartOn  |ReturnOn  | AdultsCount   | ChildrenCount   | InfantsCount  |ClassOfTravel|
      | Mozilla  | RoundTrip| Pune 			| Mumbai	 |20-12-2018 |29-12-2018|2							| 1								|	1							|Economy			|
    
    