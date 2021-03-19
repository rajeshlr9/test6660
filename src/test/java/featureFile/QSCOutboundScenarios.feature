Feature: QSC Outbound Scenarios

@QSC_OB001 @Regression_QSC
Scenario: Distribution Order Shipping - Single Line
	Given I have excel data
	| QSC_OBScenario001 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the tasks created
	Then user open Task screen & validates the status of tasks
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application


@QSC_OB002 @Regression_QSC
Scenario: Distribution Order Shipping - Multi Line
	Given I have excel data
	| QSC_OBScenario002 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the tasks created
	Then user open Task screen & validates the status of tasks
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application
	
	@QSC_OB003 @Regression_QSC
Scenario: Distribution Order Shipping - Single Line Shortage 
	Given I have excel data
	| QSC_OBScenario003 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify order got deselected from wave
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user log out from application
	
	
@QSC_OB099 @Regression_QSC
Scenario: Modify\Adjust Olpn from Manhattan UI -Single Line OLPN in Printed status and Order at DC Allocated status
	Given I have excel data
	| QSC_OBScenario004 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	#Then user views wave and verify the allocation of inventory
	Then user views wave and verify the oLPN Number
	
	@QSC_OB0991 @Regression_QSC
Scenario: Distribution Order Shipping - Single Line
	Given I have excel data
	| QSC_OBScenario005 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user validated some oLPN Number
	
	

	@QSC_OB0992 @Regression_QSC
	Scenario: Modify\Adjust Olpn from Manhattan UI Single Line  OLPN in Weighed status and Order at Weighed status-New Quantity  lesser than Current Quantity 
	Given I have excel data
	| QSC_OBScenario004 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the tasks created
	Then user open Task screen & validates the status of tasks
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user views wave and verify the oLPN Number
	
	@QSC_OB0993 @Regression_QSC
	Scenario: Modify\Adjust Olpn from Manhattan UI Single Line  OLPN in Weighed status and Order at Weighed status-New Quantity  more than Current Quantity
	Given I have excel data
	| QSC_OBScenario005 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the tasks created
	Then user open Task screen & validates the status of tasks
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user views wave and verify the oLPN Number
	
	
	@QSC_OB994 @Regression_QSC
Scenario: Distribution Order Shipping - Multi Line
	Given I have excel data
	| QSC_OBScenario006 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the tasks created
	Then user open Task screen & validates the status of tasks
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user views wave and verify the oLPN Number
	
	@QSC_OB995 @Regression_QSC
Scenario: Distribution Order Shipping - Multi Line
	Given I have excel data
	| QSC_OBScenario002 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens Distribution Order Profile in order to create DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	And user runs the "Standard wave"
	Then user views wave and verify the allocation of inventory
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete a single task created
	Then user open Task screen & validate the status of single task