Feature: This feature file contains ATM customer Outbound Scenarios 

@OutBoundScenario_ATM_MIA-001 @DailyRegression_ATM @OBRegScenarios_ATM
	Scenario: Create an order using O2S application and do PPS in vendor portal for Normal item. 
	
	Given I have excel data 
		| ATM_OBScenario004 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
	#Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "MIA - ATM WAVE TEMPLATE"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application
	
	@OutBoundScenario_ATM_MIA-002 @DailyRegression_ATM @OBRegScenarios_ATM
	Scenario: Create an order using O2S application and do PPS in vendor portal for FIFO item. 
	
	Given I have excel data 
		| ATM_OBScenario005 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
#	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "MIA - ATM WAVE TEMPLATE"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user log out from application
	
	@OutBoundScenario_ATM_MIA-003 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Manhattan for SingleLine Serial Item in Vendor Portal.
	Given I have excel data
	| ATM_OBScenario006 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the O2S application 
	Then user search order from FedexNet and verify status is booked 
	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user log out from application
	
	@OutBoundScenario_ATM_MIA-004 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Manhattan for SingleLine Serial Expiry Item in Vendor Portal.
	Given I have excel data
	| ATM_OBScenario007 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - ExpItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the O2S application 
	Then user search order from FedexNet and verify status is booked 
	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
  Then user search for DO and confirms it
  And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application

@OutBoundScenario_ATM_MIA-005 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Manhattan for SingleLine Normal Item in Vendor Portal.
	Given I have excel data
	| ATM_OBScenario008 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the O2S application 
	Then user search order from FedexNet and verify status is booked 
	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
  Then user search for DO and confirms it
  And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application
	
	@OutBoundScenario_ATM_MIA-006 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Manhattan for SingleLine Lot Item in Vendor Portal.
	Given I have excel data
	| ATM_OBScenario009 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the O2S application 
	Then user search order from FedexNet and verify status is booked 
	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user log out from application
	
	@OutBoundScenario_ATM_MIA-007 @DailyRegression_ATM @OBRegScenarios_ATM
	Scenario: Create an order using O2S application and do PPS in vendor portal for serial item. 
	
	Given I have excel data 
		| ATM_OBScenario010 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
#	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "MIA - ATM WAVE TEMPLATE"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user log out from application
	
	@ATM_OBScenario002 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Vendor Portal for SingleLine Normal Item in MEM1.
	Given I have excel data
	| ATM_OBScenario002 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
#	And user logs into the O2S application 
#	Then user search order from FedexNet and verify status is booked 
#	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
#	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "MIA - ATM WAVE TEMPLATE"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	Then user log out from application
	And user logs into the O2S application 
	And user navigate to VendorPortal and click on Ship Tab
	And user validate the DO search field
	And user completes pps in vendor portal
	Then user log out from Vendor Portal application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application
	
	@ATM_OBScenario003 @DailyRegression_ATM @OBRegScenarios_ATM
	Scenario: Create an order using O2S application. 
	
	Given I have excel data 
		| ATM_OBScenario003 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application
	
	@ATM_OBScenario006 @DailyRegression_ATM @OBRegScenarios_ATM 
	Scenario: Create an order using FedexNet and PPS in Manhattan for SingleLine Serial Item in MEM1.
	Given I have excel data
	| ATM_OBScenario006 |
	Given Open the chrome browser by selenium
	Given user update EDI file "ATM SingleLine DO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the O2S application 
	Then user search order from FedexNet and verify status is booked 
	Then user log out from O2S application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
#	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	#Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ATM PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	#Edit Tracking number and save it in header section
	#And user update the tracking number for DG item and save it in header
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	#Then user log out from application