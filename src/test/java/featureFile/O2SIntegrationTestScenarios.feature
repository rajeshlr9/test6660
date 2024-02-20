Feature: This feature file contains the O2S Integration Test Scenarios. 

@O2SIntegrationScenarios @CreateOrderSingleLineItem @OBRegScenarios_O2S_NVI @DailyRegression_O2S_NVI 
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| O2S_IntegrationScenario01 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user log out from application 
	
@O2SIntegrationScenarios @CreateOrderMultiLineItemSameItem @OBRegScenarios_O2S_NVI @DailyRegression_O2S_NVI 
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| O2S_IntegrationScenario03 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user log out from application 
	
@O2SIntegrationScenarios @CreateOrderMultiLineItemDifferentItem @OBRegScenarios_O2S_NVI @DailyRegression_O2S_NVI 
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| O2S_IntegrationScenario04 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user log out from application 
	
@O2SIntegrationScenarios @CreateOrderForReturn @OBRegScenarios_O2S_NVI @DailyRegression_O2S_NVI 
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| O2S_IntegrationScenario02 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "retunItemAndReplace" 
	Then user verify order created successfuly 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user log out from application