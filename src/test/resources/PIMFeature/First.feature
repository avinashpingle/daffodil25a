

Feature: This feature tests all the functionaltities of PIM Menu

Background:
	Given save the details
	When save the details
	
	

#Vishal
Scenario: Verify if employee name appears while creating an user
	When User opens PIM Menu
	And adds user with name Rishi Kapoor
	And save the details
	Then verify if the user is created with same name in Admin menu
	

#Tushar
Scenario: Verify if user role is creatd
	When user opens pim menu
	
