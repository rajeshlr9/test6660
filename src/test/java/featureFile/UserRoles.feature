Feature: user roles

@Rooney1 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__01|
	And Open the chrome browser by selenium
	When user log in to the Rooney application
    Then user create a user role With different Role
    And user logs into the Manhattan application
    Then user change the mode and validate the user role
    Then user log out from application
    
@Rooney2 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__02|
	And Open the chrome browser by selenium
	When user log in to the Rooney application
    Then user create a user role With different Role
    And user logs into the Manhattan application
    Then delete the user role
    Then user log out from application
    
 @Rooney3 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__03|
	And Open the chrome browser by selenium
	When user log in to the Rooney application 
	Then user create a user role Without BusinessUnit
	
@Rooney4 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__04|
	And Open the chrome browser by selenium
	When user log in to the Rooney application 
	Then user create a user role Without Region
	
@Rooney5 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__05|
	And Open the chrome browser by selenium
	When user log in to the Rooney application 
	Then user create a user role Without FirstName
	
#@Rooney6 @UserRoles
#Scenario: Users create a user role Without UserName
#    Given I have excel data
#	|Rooney__06|
#	And Open the chrome browser by selenium
#	When user log in to the Rooney application 
#	Then user create a user role Without UserName
#	
#    
#@Rooney7 @UserRoles
#Scenario: User add data for user
#    Given I have excel data
#	|Rooney__07|
#	And Open the chrome browser by selenium
#	When user log in to the Rooney application 
#	Then user create a user role Updating the new UserName
#    And user logs into the Manhattan application
#    Then user change the mode and validate the Username and user role
#    Then user log out from application
#    
#    
#@Rooney8 @UserRoles
#Scenario: User add data for user
#    Given I have excel data
#	|Rooney__08|
#	And Open the chrome browser by selenium
#	When user log in to the Rooney application 
#	Then user create a user role with wrong password
	
@Rooney9 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__09|
	And Open the chrome browser by selenium
	When user log in to the Rooney application
	Then user create a user role With different Role
    And user logs into the Manhattan application
    Then user change the mode and validate the user role
    Then user log out from application
    
    
@Rooney10 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__10|
	And Open the chrome browser by selenium
	When user log in to the Rooney application
	Then user create a user role with one role without exiting and refreshing trying to add a new role
    And user logs into the Manhattan application
    Then validate the user role with two different Roles
    Then user log out from application
    
    
@Rooney11 @UserRoles
Scenario: User add data for user
     Given I have excel data
    |Rooney__11|
    And Open the chrome browser by selenium
	When user log in to the Rooney application
	Then user create a user role with three Role
    And user logs into the Manhattan application
    Then validate the multiple roles for userrole
    Then user log out from application
	
  @Rooney12 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__12|
	And Open the chrome browser by selenium
	When user log in to the Rooney application 
	Then user create a user role Without LastName
		
  @Rooney13 @UserRoles
Scenario: User add data for user
    Given I have excel data
	|Rooney__13|
	And Open the chrome browser by selenium
	When user log in to the Rooney application 
	Then user check business unit is not mapped to the region
	

 