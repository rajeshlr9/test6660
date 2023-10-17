Feature: This feature file contains the O2S Integration Test Scenarios. 

@O2SIntegrationTestScenarios @CreateOrderSingleLineItem 
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
	
@O2SIntegrationTestScenarios @CreateOrderMultiLineItemSameItem 
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
	
@O2SIntegrationTestScenarios @CreateOrderMultiLineItemDifferentItem 
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
	
@O2SIntegrationTestScenarios @CreateOrderForReturn 
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
	
@O2SIntegrationTestScenarios @CreateOrderSingleLineItemWIP 
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
	And user runs the "NVI No-KIT Wave - LTL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number 
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	And user log out from application 