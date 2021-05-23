Feature: Edit Lead to the Leaftaps Application

Background:
Given Launch Chrome browser for Delete Lead
When Load URL for Delete Lead 'http://leaftaps.com/opentaps'
And Type username for Delete Lead as 'DemoSalesManager' 
And Type password for Delete Lead as 'crmsfa'
And Click Login Button for Delete Lead
Then Verify Login is successful for Delete
And Click CRM SFA for Delete
And Click Leads Tab for Delete

Scenario Outline: Delete a Lead with mandatory fields

Then To Click on the Find Leads for Delete
And To click on phone number tab for Delete
And Enter phone number for Delete as <phoneNumber>
And Submit Find Leads button for Delete
And Capture LeadId for Delete
And Click first matching Result for Delete
And Click Delete Button
And Click Find Leads for Delete
And Send LeadId button
And Click Find Leads Button for Delete
Then Verify No Records Display Message 

Examples:
|phoneNumber|
|8|
|9|