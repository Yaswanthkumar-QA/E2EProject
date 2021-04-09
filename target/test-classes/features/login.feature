Feature: Login into a application

Scenario Outline: Positive test validation

Given Initialize browser with chrome
And Navigate to "http://www.qaclickacademy.com" site
And click on login button to land on secure singnin page
When User enters <username> and <password> and logs in
Then verifies that user is successfully logs in or not
And Close Browsers

Examples:
|username			|password		|
|test99@gmail.com	|123456			|
|test1234@gmail.com	|1234			|
