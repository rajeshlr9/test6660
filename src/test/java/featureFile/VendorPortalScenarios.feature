Feature: This feature file contains Vendor Portal Scenarios 

#@InBoundScenario_VP_APC_Test_01	@IBRegScenarios_VP_APC @DailyRegression_VP_APC 
#Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN and LPN Staus in Manhattan. 
# 	Given I have excel data
#	| APC_KelliScenario002 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	When user updates data in "Single Line Normal Item in ASN" Kelli Upload Sheet
#	And user upload the "Single Line Normal Item in ASN" Load file in Kelli
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And fetches the actual ASN number and PO Number uploaded from Kelli
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 		
##				
#@InBoundScenario_VP_APC_Test_02	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario:  Create and Upload X12 file Using Kelli with serial Item and Veirify ASN and LPN Staus in Manhattan. 
# 	Given I have excel data
#	| APC_KelliScenario003 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	When user updates data in "Single Line Serial Item in ASN" Kelli Upload Sheet
#	And user upload the "Single Line Serial Item in ASN" Load file in Kelli
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And fetches the actual ASN number and PO Number uploaded from Kelli
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 
#	
#@InBoundScenario_VP_APC_Test_03	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario:  Create and Upload X12 file Using Kelli with Lot Item and Veirify ASN and LPN Staus in Manhattan. 
# 	Given I have excel data
#	| APC_KelliScenario004 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	When user updates data in "Single Line Lot Item in ASN" Kelli Upload Sheet
#	And user upload the "Single Line Lot Item in ASN" Load file in Kelli
#	#Then user view the logs and validates the success message for ASN Load
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And fetches the actual ASN number and PO Number uploaded from Kelli
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 
#		
#@InBoundScenario_VP_APC_Test_04	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario:  SingleLine Normal Items 
# 	Given I have excel data
#	| APC_IBScenario013 |
#	Given Open the chrome browser by selenium
#	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 
#	
#@InBoundScenario_VP_APC_Test_05	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: SingleLine Lot Items for Abaxis type item. 
#	Given I have excel data
#	| APC_IBScenario006 |
#	Given Open the chrome browser by selenium
#	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 
#	
#@InBoundScenario_VP_APC_Test_06	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: Multiline Serial Items Items for Ambient type item.
#	Given I have excel data
#	| APC_IBScenario014 |
#	Given Open the chrome browser by selenium
#	Given user update EDI file "APC MultiLine PO - SerialItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
#	Then user log out from application 
#	
#@InBoundScenario_VP_APC_Test_07	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: Single Line Normal Items and Verify the ASN details in Manhattan and Vendor Portal 
#	Given I have excel data
#	| APC_IBScenario013 |
#	Given User Open the chrome browser using selenium 
#	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details
#	Then user log out from the application 
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Receipt Number" search field
#	Then user log out from O2S application
#	
#@InBoundScenario_VP_APC_Test_08	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: SingleLine Lot Items for and Verify the ASN details in Manhattan and Vendor Portal 
#	Given I have excel data
#	| APC_IBScenario001 |
#	Given User Open the chrome browser using selenium 
#	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user log out from the application 
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Lot Number" search field
#	Then user log out from O2S application
#	
#@InBoundScenario_VP_APC_Test_09	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: Multiline Serial Items Items for Ambient type item and Verify the ASN details in Manhattan and Vendor Portal 
#	Given I have excel data
#	| APC_IBScenario003 |
#	And User Open the chrome browser using selenium
#	Given user update EDI file "APC SingleLine PO - SerailItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user log out from application 
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Serial Number" search field
#	Then user log out from O2S application
#
#@InBoundScenario_VP_APC_Test_10	@IBRegScenarios_VP_APC @DailyRegression_VP_APC
#Scenario: Multiline Serial Items Items for Ambient type item and Verify the ASN details in Manhattan and Vendor Portal 
#	Given I have excel data
#	| APC_IBScenario014 |
#	Given User Open the chrome browser using selenium
#	Given user update EDI file "APC MultiLine PO - SerialItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details  
#	Then user log out from application
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Receipt Number" search field
#	Then user log out from O2S application 

@InBoundScenario_ATM_01	@IBRegScenarios_ATM @Regression_ATM
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| ATM_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Normal" Kelli Upload Sheet
	And user upload the "Single Line Normal" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application 
	
@InBoundScenario_ATM_02	@IBRegScenarios_ATM @Regression_ATM
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| ATM_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Serial" Kelli Upload Sheet
	And user upload the "Single Line Serial" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application
	
@InBoundScenario_ATM_03	@IBRegScenarios_ATM @Regression_ATM
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN and LPN Staus in Manhattan. 
 	Given I have excel data
	| ATM_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line Lot" Kelli Upload Sheet
	And user upload the "Single Line Lot" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user opens ASN screen and navigate to LPNs Tab and verify its status "In-Transit"
	Then user log out from application
	
@InBoundScenario_ATM_04	@IBRegScenarios_ATM @Regression_ATM
Scenario: Single Line Normal Items and Verify the ASN details in Manhattan and Vendor Portal  
 	Given I have excel data
	| ATM_KelliScenario001 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Single Line Normal" Kelli Upload Sheet
	And user upload the "Single Line Normal" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Receipt Number" search field
	Then user log out from O2S application 
	
@InBoundScenario_ATM_05	@IBRegScenarios_ATM @Regression_ATM
Scenario: SingleLine Lot Items for and Verify the ASN details in Manhattan and Vendor Portal 
	Given I have excel data
	| ATM_KelliScenario002 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Single Line Lot" Kelli Upload Sheet
	And user upload the "Single Line Lot" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Lot Number" search field
	Then user log out from O2S application
	
@InBoundScenario_ATM_06	@IBRegScenarios_ATM @Regression_ATM
Scenario: SingleLine Serial Items for and Verify the ASN details in Manhattan and Vendor Portal 
	Given I have excel data
	| ATM_KelliScenario003 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Single Line Serial" Kelli Upload Sheet
	And user upload the "Single Line Serial" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Serial Number" search field
	Then user log out from O2S application

@InBoundScenario_ATM_07	@IBRegScenarios_ATM @Regression_ATM
Scenario: Multiline Serial Items Items for Ambient type item and Verify the ASN details in Manhattan and Vendor Portal 
	Given I have excel data
	| ATM_KelliScenario004 |
	Given User Open the chrome browser using selenium 
	And user logs into the kelli application 
	When user updates data in "Multi Line Normal" Kelli Upload Sheet
	And user upload the "Multi Line Normal" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal Tab
	And user validate the ASN using "Receipt Number" search field
	Then user log out from O2S application

@InBoundScenario_ATM_08	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_LotItem
Scenario: ASN Creation with Lot Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario001 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Lot Number" search field
#	Then user log out from O2S application
	
@InBoundScenario_ATM_09	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_SerialItem
Scenario: ASN Creation with Serial Items  using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario002 |
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Serial Number" search field
#	Then user log out from O2S application

@InBoundScenario_ATM_10	@IBRegScenarios_ATM @Regression_ATM @ATM_SingleLinePO_NormalItem
Scenario: ASN Creation with Normal Items using EDI file and validate ASN in Manhattan
	Given I have excel data 
		| ATM_IBScenario003|
	Given User Open the chrome browser using selenium 
	Given user update EDI file "ATM SingleLine PO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details  
	Then user log out from application
#	And user logs into the O2S application 
#	And user navigate to VendorPortal Tab
#	And user validate the ASN using "Serial Number" search field
#	Then user log out from O2S application
	