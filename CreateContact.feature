Feature:  Login to the Leaftaps application

Background:
Given  Launch Chrome browser
When  Load URL 'http://leaftaps.com/opentaps/control/main'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And Click Login Button
Then Verify Login is successful

Scenario Outline:
Then Click CRM SFA link
Then Click Contacts tab
Then Click Create Contacts
And Type First Name <fName>
And Type Last Name <lName>
Then Click Create Contacts button
Then Verify Created Contact Successful

Examples:
|fName|lName|
|Dhilip Sudhan|Muralidharan|
|Sruthi|Gopinath|

