Feature: Four Customer scenarios

@THMOBScenario1 @DailyRegression_THM @OBRegScenarios_THM
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THM_OBScenario1 |
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
	And user runs the "THM PCL Wave"
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


@THMOBScenario2 @DailyRegression_THM @OBRegScenarios_THM
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THM_OBScenario2 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "THM PCL Wave"
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

@THMOBScenario3 @DailyRegression_THM @OBRegScenarios_THM
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THM_OBScenario3 |
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
	And user runs the "THM PCL Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	#Then user log out from application


@THMOBScenario4 @DailyRegression_THM @OBRegScenarios_THM
Scenario: Cancel an order using Manhattan application. 
	Given I have excel data 
		| THM_OBScenario4 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"
	Then user log out from application
	And user logs into the O2S application 
	Then user Search Order And verify status of order is "(Cancelled)" and Item status is "FailedBook"
	Then user log out from O2S application 


@THHOBScenario1 @THHOutBound @DailyRegression_THH @OBRegScenarios_THH
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THH_OBScenario1 |
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
	And user runs the "THH PCL Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application
	
	
@THHOBScenario2 @THHOutBound @DailyRegression_THH @OBRegScenarios_THH
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THH_OBScenario2 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "THH PCL Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application

@THHOBScenario3 @THHOutBound @DailyRegression_THH @OBRegScenarios_THH
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| THH_OBScenario3 |
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
	And user runs the "THH PCL Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application
	
	
	@THHOBScenario4 @DailyRegression_THM @OBRegScenarios_THM
	Scenario: Cancel an order using Manhattan application. 
	Given I have excel data 
		| THH_OBScenario4 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"
	Then user log out from application
	And user logs into the O2S application 
	Then user Search Order And verify status of order is "(Cancelled)" and Item status is "FailedBook"
	Then user log out from O2S application 
	
@ILWOBScenario1 @ILWOutBound @DailyRegression_ILW @OBRegScenarios_ILW
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| ILW_OBScenario1 |
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
	And user runs the "ILW PCL Wave"
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
	
	@ILWOBScenario2 @ILWOutBound @DailyRegression_ILW @OBRegScenarios_ILW
	Scenario: Create an order using O2S application. 
	Given I have excel data 
		| ILW_OBScenario2 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "ILW PCL Wave"
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

@ILWOBScenario3 @ILWOutBound @DailyRegression_ILW @OBRegScenarios_ILW
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| ILW_OBScenario3 |
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
	And user runs the "ILW PCL Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And fetch the ILPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application	

	@ILWOBScenario4 @DailyRegression_ILW @OBRegScenarios_ILW
	Scenario: Cancel an order using Manhattan application. 
	Given I have excel data 
		| ILW_OBScenario4 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"
	Then user log out from application
	And user logs into the O2S application 
	Then user Search Order And verify status of order is "(Cancelled)" and Item status is "FailedBook"
	Then user log out from O2S application 

@ILWOBScenario5 @ILWOutBound @DailyRegression_ILW @OBRegScenarios_ILW
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| ILW_OBScenario5 |
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
	And user runs the "ILW PCL Wave"
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
	
@TRNOBScenario1 @DailyRegression_TRN @OBRegScenarios_TRN
Scenario: Create an order using O2S application. 
	Given I have excel data 
		| TRN_OBScenario1 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	#Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "TRN PCL Wave"
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

	@TRNOBScenario2 @TRNOutBound @DailyRegression_TRN @OBRegScenarios_TRN
	Scenario: Create an order using O2S application. 
	Given I have excel data 
		| TRN_OBScenario2 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "multiLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "TRN PCL Wave"
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


	@TRNOBScenario3 @DailyRegression_TRN @OBRegScenarios_TRN
	Scenario: Create an order using O2S application. 
	Given I have excel data 
		| TRN_OBScenario3 |
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
	And user runs the "TRN PCL Wave"
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

	@TRNOBScenario4 @DailyRegression_TRN @OBRegScenarios_TRN
	Scenario: Cancel an order using Manhattan application. 
	Given I have excel data 
		| TRN_OBScenario4 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem" 
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"
	Then user log out from application
	And user logs into the O2S application 
	Then user Search Order And verify status of order is "(Cancelled)" and Item status is "FailedBook"
	Then user log out from O2S application 
	
	
	@TRNOBScenario5 @DailyRegression_TRN @OBRegScenarios_TRN 
	Scenario: Receiving SingleLine Lot Items for Cooler type item.
	Given I have excel data
	| TRN_OBScenario5 |
	Given Open the chrome browser by selenium
	Given user update EDI file "TRN SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "TRN PCL Wave"
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
	And user update the tracking number for DG item and save it in header
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	#Then user log out from application

	@TRNOBScenario6 @DailyRegression_TRN @OBRegScenarios_TRN
	Scenario: Create an order using O2S application. 
	Given I have excel data 
		| TRN_OBScenario6 |
	Given User Open the chrome browser using selenium 
	And user logs into the O2S application 
	Then user create an order in O2S application for "singleLineItem"
	Then user verify order created successfuly 
	Then user search order and verify status is booked 
	Then user log out from O2S application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#validate for dgstatus
	Then user verify the DGRequired Status as "YES"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "TRN PCL Wave"
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
	And user update the tracking number for DG item and save it in header
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	#Then user log out from application
	
@TRN006 @SingleLineItemDO_TRN @Regression_TRN @OBRegScenarios_TRN
Scenario: Create an order using O2S application for TRN customer 
	Given I have excel data 
		| TRN_OBScenario6 |
	And Open the chrome browser by selenium
	When user update "TRN_Single_Line_DO" for dropping into fedexnet application	
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application
	
@THH006 
Scenario: Create an order using O2S application for TRN customer 
	Given I have excel data 
		| THH_OBScenario5 |
	And Open the chrome browser by selenium
	When user update "THH_Single_Line_DO" for dropping into fedexnet application	
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application