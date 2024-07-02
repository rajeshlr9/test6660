Feature: This feature file contains COM customer Vendor Portal Scenarios 

@InBoundScenario_COM_New1	@IBRegScenarios_COM @Regression_COM
Scenario: Single Line Normal Items and Verify the ASN details in Manhattan and Vendor Portal  
 	Given I have excel data
	| COM_KelliScenario001 |
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

@InBoundScenario_COM_New2	@IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
Scenario: ASN Creation with Normal Items using EDI file and validate ASN in Manhattan and Complete Receiving in VP
					and validate in Manhattan the status for receiving verified
	
	Given I have excel data 
		| COM_IBScenario001|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - NormalItems" for dropping into fedexnet application
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
	

	
@InBoundScenario_COM_New3	@IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_SerialItem
Scenario: ASN Creation with Serial Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| COM_IBScenario002 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - SerialItems" for dropping into fedexnet application
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

@InBoundScenario_COM_New4	@IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_SerialItem
Scenario: ASN Creation with Serial Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| COM_IBScenario003 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "20 - InTransit"
	And user views Shipment, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Lot Number" search field
	And user completes receiving in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the Shipment and verify its status "40 - Receiving Verified"
	Then user log out from application
	
	@InBoundScenario_COM_New5	@IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_LotItem
Scenario: ASN Creation with Hazardous Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| COM_IBScenario004 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - HazItems" for dropping into fedexnet application
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
	
	@InBoundScenario_COM_New6	@IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: ASN Creation with Normal Items using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| COM_IBScenario005|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - ExpItems" for dropping into fedexnet application
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
	
	@InBoundScenario_COM_New7 @IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| COM_IBScenario007|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - NormalItems" for dropping into fedexnet application
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
	
	@InBoundScenario_COM_New8 @IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| COM_IBScenario008|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - SerialItems" for dropping into fedexnet application
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

@InBoundScenario_COM_New9 @IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| COM_IBScenario009|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - LotItems" for dropping into fedexnet application
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

@InBoundScenario_COM_New10 @IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| COM_IBScenario010|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - HazItems" for dropping into fedexnet application
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

@InBoundScenario_COM_New11 @IBRegScenarios_COM @Regression_COM @COM_SingleLinePO_NormalItem
	Scenario: Receiving SingleLine Normal Items in Manhattan Application.
	Given I have excel data 
		| COM_IBScenario011|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "COM SingleLine PO - ExpItems" for dropping into fedexnet application
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