Feature: Validating GET place

Scenario: Get Place Validation

Given User has Add Place Payload
When user calls "GETPlace" API using "GET" http Request using <name> <address> and <phone>
Then Then API call should be successfull with status code 200
And Response should be displayed
