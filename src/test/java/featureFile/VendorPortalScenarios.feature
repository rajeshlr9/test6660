Feature: Vendor Portal Scenarios

@InBoundScenario_VP_APC_Test_01	@IBRegScenarios_VP_APC_Test_01 @IBRegScenarios_VP_APC_Reg
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Normal Item in ASN" Kelli Upload Sheet
	And user upload the "Single Line Normal Item in ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
		
@InBoundScenario_VP_APC_Test_02	@IBRegScenarios_VP_APC_Test_02
Scenario:  Create and Upload X12 file Using Kelli with serial Item and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Serial Item in ASN" Kelli Upload Sheet
	And user upload the "Single Line Serial Item in ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
	
@InBoundScenario_VP_APC_Test_03	@IBRegScenarios_VP_APC_Test_03
Scenario:  Create and Upload X12 file Using Kelli with Lot Item and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario004 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Lot Item in ASN" Kelli Upload Sheet
	And user upload the "Single Line Lot Item in ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
		
@InBoundScenario_VP_APC_Test_04	@IBRegScenarios_VP_APC_Test_04
Scenario:  SingleLine Normal Items 
 	Given I have excel data
	| APC_IBScenario013 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
	
@InBoundScenario_VP_APC_Test_05	@IBRegScenarios_VP_APC_Test_05
Scenario: SingleLine Lot Items for Abaxis type item. 
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
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
	
@InBoundScenario_VP_APC_Test_06	@IBRegScenarios_VP_APC_Test_06
Scenario: Multiline Serial Items Items for Ambient type item.
	Given I have excel data
	| APC_IBScenario014 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 