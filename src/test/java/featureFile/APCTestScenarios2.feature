Feature: This feature file contains the APC Regression Scenarios.

@IBRegScenarios_APC_LotItem1 @LotScenario
Scenario: SingleLine LTL ASN Order for Lot Items
	Given I have excel data
	| APC_IBScenario012 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application  
	
@OBRegScenarios_APC_LotItem1 @LotScenario
Scenario: SingleLine LTL Do Order for Lot Items
	Given I have excel data
	| APC_OBScenario12 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	#And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
