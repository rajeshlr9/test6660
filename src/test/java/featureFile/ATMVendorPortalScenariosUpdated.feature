Feature: This feature file contains ATM customer Vendor Portal Scenarios 

@InBoundScenario_ATM_New1	@IBRegScenarios_ATM @Regression_ATM
Scenario: Single Line Normal Items and Verify the ASN details in Manhattan and Vendor Portal  
 	Given I have excel data
	| ATM_KelliScenario001 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Single Line Normal" Kelli Upload Sheet
	And user upload the "Single Line Normal" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And user fetches the actual ASN number and PO Number uploaded from Optional Field
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Receipt Number" search field
	And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	Then user log out from application

@InBoundScenario_ATM_New2	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
Scenario: ASN Creation with Normal Items using EDI file and validate ASN in Manhattan and Complete Receiving in VP
					and validate in Manhattan the status for receiving verified
	
	Given I have excel data 
		| ATM_IBScenario001|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Shipment Number" search field
  And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	Then user log out from application
	
@InBoundScenario_ATM_New3	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_LotItem
Scenario: ASN Creation with Hazardous Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario002 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - HazItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details 
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Shipment Number" search field
	And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	Then user log out from application
	
@InBoundScenario_ATM_New4	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_SerialItem
Scenario: ASN Creation with Serial Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario003 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Serial Number" search field
	And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	Then user log out from application

@InBoundScenario_ATM_New5	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
Scenario: ASN Creation with Normal Items using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario004|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - ExpItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Shipment Number" search field
  And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	Then user log out from application
	
	@InBoundScenario_ATM_New6 @IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| ATM_IBScenario006|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application
	
	@InBoundScenario_ATM_New7 @IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| ATM_IBScenario007|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application

@InBoundScenario_ATM_New8 @IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| ATM_IBScenario008|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - ExpItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application

@InBoundScenario_ATM_New9 @IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| ATM_IBScenario009|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - HazItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application


@InBoundScenario_ATM_New10	@IBRegScenarios_ATM @Regression_ATM
Scenario: Multiline Serial Items Items for Ambient type item and Verify the ASN details in Manhattan and Vendor Portal 
	Given I have excel data
	| ATM_KelliScenario004 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Multi Line Normal" Kelli Upload Sheet
	And user upload the "Multi Line Normal" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And user fetches the actual ASN number and PO Number uploaded from Optional Field
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Receipt Number" search field
	And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	Then user log out from application