Feature: Navico Inbound And Outbound Scenarios

@NAVICO_IB001 @NAVICO_InBoundScenario @Sanity_NAVICO
Scenario: Verify ASN creation through EDI - Single Line
Creating ASN through EDI & checking status of the shipment
	Given I have excel data
	| NVI_IBScenario001 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
	
@NAVICO_IB002 @NAVICO_InBoundScenario @Sanity_NAVICO
Scenario: Verify ASN creation through EDI - Multiline
	Given I have excel data
	| NVI_IBScenario006 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application	
	
@NAVICO_IB003 @NAVICO_InBoundScenario @Sanity_NAVICO
Scenario: Verify ASN creation through EDI
Creating ASN through EDI & performing Receving for Single Line
	Given I have excel data
	| NVI_IBScenario001 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN
	Then user log out from application 
	
@NAVICO_OB01 @NAVICO_OutBoundScenario @Sanity_NAVICO
Scenario: Distribution Order creation - Single Line LTL LTL LTL 
	Given I have excel data 
		| NVI_OBScenario001 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page
	Then user log out from application 
	
@NAVICO_OB02 @NAVICO_OutBoundScenario @Sanity_NAVICO
Scenario: Distribution Order creation - Multi Line LTL LTL LTL 
	Given I have excel data 
		| NVI_OBScenario002 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user log out from application
	
@NAVICO_OB04 @NAVICO_OutBoundScenario @Sanity_NAVICO
Scenario: Distribution Order creation - Multi Line different items Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario004 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	Then user log out from application

@NAVICO_OB03 @NAVICO_OutBoundScenario @Sanity_NAVICO
Scenario: Distribution Order creation - Single Line Serialized Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario003 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 