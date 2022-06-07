Feature: Navico Inbound And Outbound Scenarios

@NVI_IBS001 @NAVICO_InBoundScenario @NVI_EDIOrderReceiving @DailyRegression_NAVICO 
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
	
@NVI_IBS002 @NAVICO_InBoundScenario @NVI_EDIOrderReceiving @DailyRegression_NAVICO
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
	
@NVI_IBS003 @NAVICO_InBoundScenario @NVI_Rec&Putaway @DailyRegression_NAVICO
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
	
@NVI_IBS004 @NAVICO_InBoundScenario @NVI_Rec&Putaway @DailyRegression_NAVICO
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
	
@NVI_IBS005 @NAVICO_InBoundScenario @NVI_BlindReceipt @DailyRegression_NAVICO
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
	
@NVI_IBS006 @NAVICO_InBoundScenario @NVI_PartiallyVerified @DailyRegression_NAVICO
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
	
@NVI_IBS007 @NAVICO_InBoundScenario @NVI_PartiallyVerified @DailyRegression_NAVICO
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
	
@NVI_IBS008 @NAVICO_InBoundScenario @NVI_Rec&Putaway @DailyRegression_NAVICO
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

@NVI_IBS009 @NAVICO_InBoundScenario @NVI_SplitiLPN 
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
	
@NVI_IBS010 @NAVICO_InBoundScenario @NVI_SplitiLPN
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
	
@NVI_IBS011 @NAVICO_InBoundScenario @NVI_SplitiLPN
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
