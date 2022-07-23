Feature: Delete Place API validation

@Test
Scenario: Validating Delete Place

Given User has an Add Place Payload
When user calls "DeletePlace" API using "DELETE" http Request using <name> <address> and <phone>
Then validate the place id has been deleted

