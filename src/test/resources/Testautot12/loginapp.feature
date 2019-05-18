Feature: Login with data valid
Scenario: Login successfully
Given Open App
When Input username and password valid
Then Login success with notify popup 