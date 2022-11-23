Feature: This feature file contains the APC Regression Scenarios for both Inbound and Outbound scenarios.

@InBoundScenario_APC_1 @IBRegScenarios_APC
Scenario: Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Lot Items  for Cooler type item.
	Given I have excel data
	| APC_IBScenario001 |
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
	And user log out from application   
	
@InBoundScenario_APC_2 @IBRegScenarios_APC
Scenario: Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Normal Items  for Ambient type item.
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
	Then user log out from application 
	
@InBoundScenario_APC_3 @IBRegScenarios_APC
Scenario: Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Serial Items  for Ambient type item.
	Given I have excel data
	| APC_IBScenario003 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - SerailItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application  
	
@InBoundScenario_APC_4 @IBRegScenarios_APC
Scenario: Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Normal Items for Hazmat type item. 
	Given I have excel data
	| APC_IBScenario004 |
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
	And user log out from application
	
@InBoundScenario_APC_5 @IBRegScenarios_APC
Scenario:  Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Normal Items for Freezer type item. 
	Given I have excel data
	| APC_IBScenario005 |
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
	And user log out from application 
	
@InBoundScenario_APC_6 @IBRegScenarios_APC
Scenario:  Create, Upload,Veirify ASN Staus and Complete Receiving for SingleLine Lot Items for Abaxis type item. 
	Given I have excel data
	| APC_IBScenario006 |
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
	And user log out from application
	  
@InBoundScenario_APC_7	@IBRegScenarios_APC
Scenario:  Create, Upload X12 file Using Kelli and Veirify ASN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
	
@InBoundScenario_APC_8 @IBRegScenarios_APC
Scenario:  Receiving Multiline Lot Items with Differnt Quantity.  
	Given I have excel data
	| APC_IBScenario007 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application
	
@InBoundScenario_APC_9 @IBRegScenarios_APC
Scenario:  Receiving Multiline Normal Items with Same Quantity. 
	Given I have excel data
	| APC_IBScenario008 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application	
	
@InBoundScenario_APC_10 @IBRegScenarios_APC
Scenario:  Receiving Multiline Serial Items with Same Quantity. 
	Given I have excel data
	| APC_IBScenario009 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application	
	
@InBoundScenario_APC_11 @IBRegScenarios_APC
Scenario:  Receiving Multiline Lot Items with Same Quantity.  
	Given I have excel data
	| APC_IBScenario010 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application
	
@InBoundScenario_APC_12 @IBRegScenarios_APC
Scenario:  Receiving Multiline Lot Items with Same Quantity.  
	Given I have excel data
	| APC_IBScenario011 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application
	
@ScriptDevelopment_APC_VerifyDOStatus
Scenario: Create and Upload X12 File for SingleLine DO Order Creation
Creating ASN through Post Message UI, Upload X12 Files for Single Line ASN Creation
	Given I have excel data
	| APC_IBScenario001 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	#And user logs into the Manhattan application
	#And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
