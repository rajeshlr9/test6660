Feature: This CIL Sanity Suite feature file contains sanity scenarios.

@Sanity_CIL @Inbound_SingleLine_APC
Scenario: Receiving SingleLine Normal Items for Ambient type item.
	Given I have excel data
	| APC_IBScenario002 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
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
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application

@Sanity_CIL @Inbound_SingleLine_UsingKelli_APC
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario001 |
	Given Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
		
@Sanity_CIL @Outbound_SingleLine_APC
Scenario: SingleLine LTL DO Order for Normal Item
	Given I have excel data
	| APC_OBScenario02 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems" for dropping into fedexnet application
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
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@Sanity_CIL1 @O2S_SingleLine_NVI
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| O2S_IntegrationScenario01 |
	Given User Open the chrome browser using selenium
	And user logs into the O2S application 
	#Then user create an order in O2S application for "singleLineItem" 
	Then user create an order for "NVI" customer in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into Manhattan application for "NVI" customer
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user log out from the application