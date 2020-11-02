Feature: Map

Scenario: Validate San Francisco map details and get directions
   Given user is navigate to "https://map.google.com"
   When user search for "San Francisco, California"
   Then user verify the coordinates for "San Francisco" are 37.757815,-122.5076407
   		And user search for driving directions "car" from "Chico, California" to "San Francisco, California"
   		And user see two or more routes are displayed in the list
   		And print the route title, distance in miles, and the travel time to a file titled "D:\routes.txt"