$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/featureFiles/DemoFeature.feature");
formatter.feature({
  "name": "Map",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate San Francisco map details and get directions",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is navigate to \"https://map.google.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.user_is_navigate_to(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for \"San Francisco, California\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.user_search_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verify the coordinates for \"San Francisco\" are 37.757815,-122.5076407",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.user_verify_the_coordinates_for_are(java.lang.String,double,double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for driving directions \"car\" from \"Chico, California\" to \"San Francisco, California\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.user_search_for_driving_directions_from_to(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user see two or more routes are displayed in the list",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.user_see_two_or_more_routes_are_displayed_in_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "print the route title, distance in miles, and the travel time to a file titled \"D:\\routes.txt\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.DemoFeatureStepDef.print_the_route_title_distance_in_miles_and_the_travel_time_to_a_file_titled_routes_txt(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});