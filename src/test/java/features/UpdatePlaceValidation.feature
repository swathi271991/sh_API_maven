Feature: Validate Update Place Validation

Scenario: validating the place_id has been updated by using update Place API

Given User has Add Place Payload
When user calls "UpdatePlace" API using "UPDATE" http Request using <name> <address> and <phone>
Then validate the updated address

