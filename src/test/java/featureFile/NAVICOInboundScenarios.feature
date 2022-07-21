Feature: Navico Inbound And Outbound Scenarios

@NAVICO_IB001 @NAVICO_InBoundScenario @NVI_EDIOrderReceiving @Sanity_NAVICO 
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
	
@NAVICO_IB002 @NAVICO_InBoundScenario @NVI_EDIOrderReceiving @Sanity_NAVICO
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
	
@NAVICO_IB003 @NAVICO_InBoundScenario @NVI_Rec&Putaway @Sanity_NAVICO
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
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
	
@NAVICO_IB004 @NAVICO_InBoundScenario @NVI_Rec&Putaway @Sanity_NAVICO
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario026 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN to be not available in Manhattan
	Then user log out from application
	
@NAVICO_IB005 @NAVICO_InBoundScenario @NVI_BlindReceipt @Sanity_NAVICO
Scenario: B-441160 Receiving Returned Un-Delivered Product using blind receipt & Putaway
Receiving of Un-Delivered Product using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario027 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code 
	Then user log out from application
	
@NAVICO_IB006 @NAVICO_InBoundScenario @NVI_PartiallyVerified @Sanity_NAVICO
Scenario: Receiving Partial Qty from an ASN- Single Line
Creating ASN through Post Message UI, Complete receiving of partial qty, Verify the ASN Manually & validate new ASN is
automatically created with remaining qty
	Given I have excel data
	| NVI_IBScenario028 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	#Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
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
	
@NAVICO_IB007 @NAVICO_InBoundScenario @NVI_PartiallyVerified @Sanity_NAVICO
Scenario: Receiving Partial Qty from both the lines of an ASN- Multi Line
Creating ASN through Post Message UI, Complete receiving of partial qty from both the lines, Verify the ASN Manually & 
validate new multi line ASN is automatically created with remaining qty for both lines
	Given I have excel data
	| NVI_IBScenario029 |
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
	
@NAVICO_IB008 @NAVICO_InBoundScenario @NVI_Rec&Putaway @Sanity_NAVICO
Scenario: Multi Line Receiving- Multi Line, Multiple iLPN
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario030 |
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

@NAVICO_IB009 @NAVICO_InBoundScenario @NVI_SplitiLPN@Sanity_NAVICO
Scenario: Over Receiving of Products using blind receipt & Putaway
Over reciving of products using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario033 |
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
	
@NAVICO_IB010 @NAVICO_InBoundScenario @NVI_SplitiLPN@Sanity_NAVICO
Scenario: B-459309 Receive Damages- Receiving Damaged Product using MM3 Recv-Damages & Putaway
Receiving of Damaged Products in MM3 Recv-Damages option from RF menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| NVI_IBScenario034 |
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
	And user open reserve locations & naviagtes to "0357E060M" zone and fetches the current quantity	
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "0357E060M" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "0357E060M"
	Then user log out from application
	
@NAVICO_IB011 @NAVICO_InBoundScenario @NVI_SplitiLPN@Sanity_NAVICO
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
	
#@NAVICO_IB009 @NAVICO_InBoundScenario @NVI_SplitiLPN@Sanity_NAVICO
#Scenario: B-345784 MANH - Break Split LPN IB
#Creating ASN through Post Message UI and receiving in 2 LPN's. Move few quantities from 1st LPN to 2nd location & validating LPN's in Inventory by location
#	Given I have excel data
#	| NVI_IBScenario031 |
#	And Open the chrome browser by selenium
#	When user update "Single Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu 
#	Then user break Split LPN and move to another LPN of same ASN 
#	Then user opens Inventory by location screen and validates the LPN moved
#	#Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
#	Then user log out from application 
#	
#@NAVICO_IB010 @NAVICO_InBoundScenario @NVI_LockUnlockFunctionality @Sanity_NAVICO
#Scenario: B-467729 – Configure Manhattan for RF lock-unlock iLPN-- Lock an iLPN using the user provided lock code
#Create an iLPN using RF MM3 Create iLPN option and apply the lock code provided by user
#	Given I have excel data
#	| QSC_IBScenario011 |
#	And Open the chrome browser by selenium
#	And user logs into the Manhattan application 
#	And user opens RF menu and go to invenorty & perform "RF MM3 Create iLPN" operation
#	And user open iLPN and applies the lock code
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And validates the PIX Transactions "300,606" for this operation
#	Then user log out from application 
#	
#@NAVICO_IB011 @NAVICO_InBoundScenario @NVI_LockUnlockFunctionality @Sanity_NAVICO
#Scenario: B-467729 – Configure Manhattan for RF lock-unlock iLPN-- Unlock an iLPN which already has some lock
#	Given I have excel data
#	| QSC_IBScenario012 |
#	And Open the chrome browser by selenium
#	And user logs into the Manhattan application
#	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
#	And user open iLPN and unlock the existing code
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And validates the PIX Transactions "300,606" for this operation
#	Then user log out from application 
#

@NAVICO_IB012 @NAVICO_InBoundScenario @NVI_Rec&Putaway @Sanity_NAVICO @DailyRegressionL4Env_NAVICO
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario035 |
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
	
@NAVICO_IB013 @NAVICO_InBoundScenario @NVI_Rec&Putaway @Sanity_NAVICO @DailyRegressionL4Env_NAVICO
Scenario: Multi Line Receiving- Multi Line, Multiple iLPN
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario036 |
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
	
@NAVICO_OB03 @NAVICO_OutBoundScenario @Sanity_NAVICO
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

@NAVICO_OB05 @NAVICO_OutBoundScenario @Sanity_NAVICO
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
	
@NAVICO_OB06Test
Scenario: Distribution Order creation - Single Line Serialized Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario005 |
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
	
@NAVICO_OB07Test
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| NVI_OBScenario006 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
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

@NAVICO_OB08Test
Scenario: Distribution Order creation - Multi Line Parcel PO FDE
	Given I have excel data 
		| NVI_OBScenario007 |
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
	
@NAVICO_OB09Test
Scenario: Distribution Order creation - Single Line Non Serialized Parcel F2D FDE
	Given I have excel data 
		| NVI_OBScenario005 |
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
	
@NAVICO_OB10Test
Scenario: Distribution Order creation - Multi Line LTL	FDFE LTLP 
	Given I have excel data 
		| NVI_OBScenario009 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
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

@NAVICO_OB11Test
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| NVI_OBScenario006 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"