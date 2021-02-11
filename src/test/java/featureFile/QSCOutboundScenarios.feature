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
	Then user log out from application

