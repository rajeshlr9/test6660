Feature: NVI Regression Scenarios for L4 Environment

@DailyRegressionL4NVI_NVI @NVI_L4_IB001 @IBRegScenariosL4NVI_NVI @NVI_L4_EDIOrderReceiving
Scenario: Verify ASN creation through EDI - Single Line
Creating ASN through EDI & checking status of the shipment
	Given I have excel data
	| NVI_IBScenario038|
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB002 @IBRegScenariosL4NVI_NVI @NVI_L4_EDIOrderReceiving
Scenario: Verify ASN creation through EDI - Multiline
	Given I have excel data
	| NVI_IBScenario039 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application	
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB003 @IBRegScenariosL4NVI_NVI @NVI_L4_Rec&Putaway
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario037 |
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
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB004 @IBRegScenariosL4NVI_NVI @NVI_L4_Rec&Putaway
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario040 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN to be not available in Manhattan
	Then user log out from application
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB005 @IBRegScenariosL4NVI_NVI @NVI_L4_BlindReceipt
Scenario: B-441160 Receiving Returned Un-Delivered Product using blind receipt & Putaway
Receiving of Un-Delivered Product using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario041 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code 
	Then user log out from application
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB006 @IBRegScenariosL4NVI_NVI @NVI_L4_PartiallyVerified
Scenario: Receiving Partial Qty from an ASN- Single Line
Creating ASN through Post Message UI, Complete receiving of partial qty, Verify the ASN Manually & validate new ASN is
automatically created with remaining qty
	Given I have excel data
	| NVI_IBScenario042 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE2" menu
	Then user opens ASN screen and searches for the 2nd ASN and verify its status "40 - Receiving Verified"
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB007 @IBRegScenariosL4NVI_NVI @NVI_L4_PartiallyVerified
Scenario: Receiving Partial Qty from both the lines of an ASN- Multi Line
Creating ASN through Post Message UI, Complete receiving of partial qty from both the lines, Verify the ASN Manually & 
validate new multi line ASN is automatically created with remaining qty for both lines
	Given I have excel data
	| NVI_IBScenario043 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	#And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE2" menu
	Then user opens ASN screen and searches for the 2nd ASN and verify its status "40 - Receiving Verified"
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application
	
@DailyRegressionL4NVI_NVI @NVI_L4_IB008 @IBRegScenariosL4NVI_NVI @NVI_L4_Rec&Putaway
Scenario: Multi Line Receiving- Multi Line, Multiple iLPN
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario044 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
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

#Need to execute below TC Manual if the Inspection Zone changed and did not work
@DailyRegressionL4NVI_NVI_Manual @NVI_L4_IB009 @IBRegScenariosL4NVI_NVI @NVI_L4_BlindRec&Putaway
Scenario: Over Receiving of Products using blind receipt & Putaway
Over reciving of products using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario045 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "NVQIA013R" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "NVQIA013R" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "NVQIA013R"
	Then user log out from application
	
#Need to execute below TC Manual if the Inspection Zone changed and did not work
@DailyRegressionL4NVI_NVI_Manual @NVI_L4_IB010 @IBRegScenariosL4NVI_NVI @NVI_L4_RecDamage&Putaway
Scenario: B-459309 Receive Damages- Receiving Damaged Product using MM3 Recv-Damages & Putaway
Receiving of Damaged Products in MM3 Recv-Damages option from RF menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario046 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open iLPN and unlock the existing code
	#And user open reserve locations & naviagtes to "QC708A1K6" zone and fetches the current quantity
	And user open reserve locations & naviagtes to "0514F039Y" zone and fetches the current quantity	
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	#Then user navigates to reserve locations & validates that the quantity is increased in "0514F039Y" by no of iLPN's moved
	#Then validates that the iLPN is also moved to inspection zone "0514F039Y"
	Then user log out from application
	
#Need to execute below TC Manual if the it did not work
@DailyRegressionL4NVI_NVI_Manual @NVI_L4_IB011 @IBRegScenariosL4NVI_NVI @NVI_L4_LoadASnUsingKelli
Scenario: Uploading the Single ASNLoad file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| NVI_KelliScenario001 |
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
	
#If the below TC failed due to inventory allocation mismatch then need to run the InBound scenario - @NVI_L4_IB003 first.
#While running the InBound Scenario update the Item Id and quantity same as OutBound Scenario.
@DailyRegressionL4NVI_NVI @NVI_L4_OB001 @OBRegScenariosL4NVI_NVI @NVI_L4_SingleLineSerParcelDO
Scenario: Distribution Order creation - Single Line Serialized Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario015 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "NVI No-KIT Wave -PCL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
	
@DailyRegressionL4NVI_NVI @NVI_L4_OB002 @OBRegScenariosL4NVI_NVI @NVI_L4_SingleLineLTLDO
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| NVI_OBScenario016 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	#And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "NVI No-KIT Wave - LTL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number 
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	

@DailyRegressionL4NVI_NVI @NVI_L4_OB003 @OBRegScenariosL4NVI_NVI @NVI_L4_MultiLineSerParcelDO
Scenario: Distribution Order creation - Multi Line Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario017 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "NVI No-KIT Wave -PCL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
	
@DailyRegressionL4NVI_NVI @NVI_L4_OB004 @OBRegScenariosL4NVI_NVI @NVI_L4_SingleLineNonSerParcelDO
Scenario: Distribution Order creation - Single Line Non Serialized Parcel F2D FDE
	Given I have excel data 
		| NVI_OBScenario015 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "NVI No-KIT Wave -PCL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
	
@DailyRegressionL4NVI_NVI @NVI_L4_OB005 @OBRegScenariosL4NVI_NVI @NVI_L4_MultiLineNonSerLTLDO
Scenario: Distribution Order creation - Multi Line LTL	FDFE LTLP 
	Given I have excel data 
		| NVI_OBScenario018 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia	
	Then user verifies the item details in Distribuion Order page 
	And user runs the "NVI No-KIT Wave - LTL" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number with only 30 weighed status 
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	#And user navigates to shippment planning workspace 
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	

@DailyRegressionL4NVI_NVI @NVI_L4_OB006 @OBRegScenariosL4NVI_NVI @NVI_L4_SingleLineCancelDO
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| NVI_OBScenario016 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"