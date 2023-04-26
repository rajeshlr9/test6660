Feature: QSC Regression Outbound And Inbound Scenarios 


@DailyRegression_QSC @ScenarioIB1 @IBRegScenarios_QSC
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| QSC_IBScenario002 |
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
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application
	
@DailyRegression_QSC @ScenarioIB2 @IBRegScenarios_QSC
Scenario: Multi Line Receiving- Multi Line, Multiple iLPN
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| QSC_IBScenario006 |
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


@DailyRegression_QSC @ScenarioIB3 @IBRegScenarios_QSC
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| QSC_DailyRegressionIB03 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN to be not available in Manhattan 


@DailyRegression_QSC @ScenarioIB5 @IBRegScenarios_QSC
Scenario: B-441160 Receiving Returned Un-Delivered Product using blind receipt & Putaway
Receiving of Un-Delivered Product using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| QSC_IBScenario007 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code
	
	
@DailyRegressionManual_QSC @ScenarioIB6 @IBRegScenarios_QSCManual
Scenario: B-459309 Receive Damages- Receiving Damaged Product using MM3 Recv-Damages & Putaway
Receiving of Damaged Products in MM3 Recv-Damages option from RF menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| QSC_IBScenario009 |
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
	And user open reserve locations & naviagtes to "QC706A1M2" zone and fetches the current quantity	
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC706A1M2" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC706A1M2"
	Then user log out from application
	
@DailyRegressionManual_QSC @ScenarioIB7 @IBRegScenarios_QSCManual
Scenario: Over Receiving of Products using blind receipt & Putaway
Over reciving of products using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| QSC_IBScenario010_1 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "QC819A13G" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC819A13G" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC819A13G"
	Then user log out from application
	
@DailyRegression_QSC @ScenarioIB8 @IBRegScenarios_QSC
Scenario: Uploading the Single ASNLoad file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| QSC_KelliScenario001 |
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
	
@DailyRegression_QSC @ScenarioIB10 @IBRegScenarios_QSC
Scenario: Receiving Partial Qty from an ASN- Single Line
Creating ASN through Post Message UI, Complete receiving of partial qty, Verify the ASN Manually & validate new ASN is
automatically created with remaining qty
	Given I have excel data
	| QSC_IBScenario029 |
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

@DailyRegressionIgnore_QSC @ScenarioOB10_1 @OBRegScenarios_QSCIgnore
Scenario: Distribution Order creation - Single Line Non Serialized Parcel F2D FDE
	Given I have excel data 
		| QSC_DailyRegressionOB10_1 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	
@DailyRegression_QSC @ScenarioIB11 @IBRegScenarios_QSC
Scenario: Receiving Partial Qty from both the lines of an ASN- Multi Line
Creating ASN through Post Message UI, Complete receiving of partial qty from both the lines, Verify the ASN Manually & 
validate new multi line ASN is automatically created with remaining qty for both lines
	Given I have excel data
	| QSC_IBScenario030 |
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
	
@DailyRegression_QSC @ScenarioIB12 @IBRegScenarios_QSC
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through fedexnet, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| QSC_DailyRegressionIB12 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user log out from application 
#	And user logs into the FedexNet application for verify files
#	And user verify the "861" file in fedexnet
#	Then user log out from Fedenxet application	

@DailyRegression_QSC @ScenarioOB01 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line Serialized Parcel PO FDE
	Given I have excel data 
		| QSC_DailyRegressionOB01 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	
	
@DailyRegression_QSC @ScenarioOB02 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line Non Serialized Parcel F2D FDE
	Given I have excel data 
		| QSC_DailyRegressionOB02 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application
		
@DailyRegression_QSC @ScenarioOB3 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| QSC_DailyRegressionOB03 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
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
		
@DailyRegression_QSC @ScenarioOB04 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Multi Line Parcel F2D FDE
	Given I have excel data 
		| QSC_DailyRegressionOB04 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	

@DailyRegression_QSC @ScenarioOB5 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Multi Line LTL	FDFE LTLP 
	Given I have excel data 
		| QSC_DailyRegressionOB05 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number with only 30 weighed status 
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	
	
@DailyRegression_QSC @ScenarioOB6 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line LTL LTL LTL 
	Given I have excel data 
		| QSC_DailyRegressionOB06 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
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
	
@DailyRegressionIGnore_QSC @ScenarioOB8 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE invalid item
	Given I have excel data 
		| QSC_DailyRegressionOB08 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DO

#@DailyRegression_QSC @ScenarioOB10 @OBRegScenarios_QSC
#Scenario: Distribution Order creation - Single Line  SI LTL FDFE LTLE 
#	Given I have excel data 
#		| QSC_DailyRegressionOB10 |
#	And Open the chrome browser by selenium 
#	When user update "Single Line DO" for dropping into fedexnet application 
#	And user logs into the FedexNet application 
#	And user upload "850" XML file in fedexnet 
#	Then user log out from Fedenxet application 
#	And user logs into the Manhattan application 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
#	Then user verifies the item details in Distribuion Order page 
#	And user runs the "LTL Pick Wave" 
#	Then user views wave and verify the allocation of inventory 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
#	And user open Task screen & verifies task is created for DO in the wave process 
#	And user open RF Menu and complete the pick tasks created 
#	And user open RF Menu and complete the pack tasks created 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
#	Then fetch the OLPN number 
#	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
#	And user navigates to shippment planning workspace 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
		
@DailyRegression_QSC @ScenarioOB11 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Single Line LTL FDFE LTLE 
	Given I have excel data 
		| QSC_DailyRegressionOB03 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application 
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application 
	And user logs into the Manhattan application 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user cancels the DO
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled"
	
@DailyRegression_QSC @OBRegScenarios_QSCIgnore @SplitMoveoLPN1_QSC @SplitMoveoLPN_QSC
Scenario: Spliting the OLPN at Weighed status 
	Given I have excel data 
	| QSC_DailyRegressionOB06 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then fetch the OLPN number
	And user opens RF menu and completes "MM3 split OLPN" operation in Misc menu
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest for splitted to OLPN
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu after split move
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged"
	And user navigates to shippment planning workspace
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application	
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application	
	
@DailyRegressionIgnore_QSC @OBRegScenarios_QSCIgnore @SplitMoveoLPN2_QSC @SplitMoveoLPN_QSC
Scenario: Combine the OLPN at weighed status
	Given I have excel data 
		| QSC_DailyRegressionOB05 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then fetch the OLPN number with only 30 weighed status 
	And user opens RF menu and completes split move using "MM3 split OLPN" operation in Misc menu
	And user opens DO screen and searches for the DistributionOrder and verify its status "150 - Packed"
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest for splitted to OLPN
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu after split move
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged"
	And user navigates to shippment planning workspace
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application	
	
@DailyRegressionIgnore_QSC @OBRegScenarios_QSCIgnore @SplitMoveoLPN3_QSC @SplitMoveoLPN_QSC
Scenario: Combine the OLPN at weighed status
	Given I have excel data 
		| QSC_DailyRegressionOB05 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "LTL Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then fetch the OLPN number with only 30 weighed status 
	And user opens RF menu and performs split move using "MM3 split OLPN" operation in Misc menu
	And user opens DO screen and searches for the DistributionOrder and verify its status "150 - Packed"
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest for splitted to OLPN
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM3 Anchor oLPN" menu after split move
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged"
	And user navigates to shippment planning workspace
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	Then user log out from application	
	
@DailyRegression_QSC @ScenarioOB07 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Validation of Error Label
	Given I have excel data 
		| QSC_DailyRegressionOB11 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	
	
@DailyRegression_QSC @ScenarioOB12 @OBRegScenarios_QSC
Scenario: Distribution Order creation - Multi Line Parcel PO FDE
	Given I have excel data 
		| QSC_DailyRegressionOB12 |
	And Open the chrome browser by selenium 
	When user update "Four Line DO" for dropping into fedexnet application 
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	And user updates the shipVia
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Parcel Pick Wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	#Then user search for DO and confirms it
	#And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"
	And user log out from application
#	And user logs into the FedexNet application for verify files
#	And user verify the "856" file in fedexnet
#	Then user log out from Fedenxet application	
	
		