Feature: Quality point tech website
@TC_01
Scenario: Performing all operations
    Given Launch Browser and Navigate to url
    When Entering Username,Password and Click on Login button 
    Then Verification of Login Successfull message 
    Then Clicking on employee details and create new user
    Then Verification of new user page 
  	Then Entering Employee Details and Click on Save Details
  	Then Verification of Employee Details saved sucessfully message
  	Then Clicking on Employee Details link
  	Then Verification of new user details is displayed in table or not
  	Then Clicking on Logout
  	Then Verification of logout successfull message
  	Then Close the Browser