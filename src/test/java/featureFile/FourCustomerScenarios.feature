Feature: Four Customer scenarios

@THH001 @THH_KelliASNLoad @DailyRegression_THH @IBRegScenarios_THH
Scenario: Uploading the Single ASNLoad file for THH using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| THH_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	#And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	#Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 
	
@TRN001 @TRN_KelliASNLoad @DailyRegression_TRN @IBRegScenarios_TRN_1
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| TRN_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Multi Line ASN" Kelli Upload Sheet
	And user upload the "Multi Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 	
	
@TRN002 @TRN_KelliASNLoad @DailyRegression_TRN @IBRegScenarios_TRN
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| TRN_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 	
	
@ILW001 @ILW_KelliASNLoad @DailyRegression_ILW @IBRegScenarios_ILW
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| ILW_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 
	
@THM001 @THM_KelliASNLoad @DailyRegression_THM @IBRegScenarios_THM
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| THM_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application
	
#@FUJ001 @FUJ_KelliASNLoad @DailyRegression_FUJ
#Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
# 	Given I have excel data
#	| FUJ_KelliScenario001 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	When user updates data in "Single Line ASN" Kelli Upload Sheet
#	And user upload the "Single Line ASN" Load file in Kelli
#	#Then user view the logs and validates the success message for ASN Load
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And fetches the actual ASN number and PO Number uploaded from Kelli
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	And user opens Items screen and find putaway type 
#	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	Then user log out from application 

@THMOutBound @DailyRegression_THM @OBRegScenarios_THM
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

@THHOutBound @DailyRegression_THH @OBRegScenarios_THH
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
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application
	
@ILWOutBound @DailyRegression_ILW @OBRegScenarios_ILW
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
	
@TRNOutBound @DailyRegression_TRN @OBRegScenarios_TRN
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

