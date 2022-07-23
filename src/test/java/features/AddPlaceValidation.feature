Feature: Validating Add Place


Scenario Outline: validating a new place_id has been created by using Add Place API

Given User has Add Place Payload
When user calls "AddPlace" API using "POST" http Request using <name> <address> and <phone>
Then API call should be successfull with status code 200
And "status" in the response should be "OK"

Examples:

|name|address|phone|
|shreyanvi|tghu|2345|
|swathi|xyz|4567890|
|rajeev|gjshd|234523|
|sarada|vghjdk|23456|





