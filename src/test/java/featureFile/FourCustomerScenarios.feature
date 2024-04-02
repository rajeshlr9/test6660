Feature: Four Customer scenarios

@THH001 @SingleLine_THH @Regression_THH @IBRegScenarios_THH
Scenario: Receiving Case: ASN Load using Kelli for SingleLine Serial Tracked Item.Complete Receiving and Putaway.
Creating ASN through Kelli, checking status of the shipment for Single Line Serial Tracked Item. Complete Putaway.
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
	
@THH002 @MultiLine_THH @Regression_THH @IBRegScenarios_THH
Scenario: Receiving Case: Multiline ASNLoad having Serial Tracked and Lot Revision with Serial Tracked items using Kelli for THH.
Creating ASN through Kelli, checking status of the shipment for Multi Line Serial Tracked Item. Complete Putaway.
 	Given I have excel data
	| THH_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Multi Line ASN" Kelli Upload Sheet
	And user upload the "Multi Line ASN" Load file in Kelli
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
	
@THH003 @InvalidItem_THH @Regression_THH @IBRegScenarios_THH
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Create ASN using Kelli for Singleline ASN Load having Invalid Item. Validate ASN should not available in Manhattan.
	Given I have excel data
	| THH_KelliScenario004 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "InvalidItem" Kelli Upload Sheet
	And user upload the "InvalidItem" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And verify ASN not created and reached to Manhattan
	
@THM001 @SingleLine_THM @Regression_THM @IBRegScenarios_THM
Scenario: Receiving Case : SingleLine ASNLoad for THM Using Kelli having Items with Lot and Revision.Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Single Line with Lot and Revision Item. Complete Putaway.
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

@THM002 @MultiLine_THM @Regression_THM @IBRegScenarios_THM
Scenario: Receiving Case : Multiline ASNLoad having Normal and serial Tracked items using Kelli for THM.
Creating ASN through Kelli, checking status of the shipment for Multi Line Normal and Serial Tracked Item. Complete Putaway.
 	Given I have excel data
	| THM_KelliScenario002 |
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
	
@THM003 @InvalidItem_THM @Regression_THM @IBRegScenarios_THM
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Create ASN using Kelli for Singleline ASN Load having Invalid Item. Validate ASN should not available in Manhattan.
	Given I have excel data
	| THM_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "InvalidItem" Kelli Upload Sheet
	And user upload the "InvalidItem" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And verify ASN not created and reached to Manhattan
	#Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	#Then user opens ASN screen and searches for the ASN to be not available in Manhattan 

@TRN001 @SingleLine_TRN @Regression_TRN @IBRegScenarios_TRN
Scenario: Receiving Case : MultiLine ASNLoad file for TRN Using  Kelli for Normal Items with different UOM.Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Multi Line Normal Item. Complete Putaway.
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
	
@TRN002 @MultiLine_TRN @Regression_TRN @IBRegScenarios_TRN
Scenario: Receiving Case :  MultiLine ASNLoad file for TRN Using Kelli for Item with Serial Tracked. Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Single Line Serial Tracked Item. Complete Putaway.

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
	
@TRN003 @InvalidItem_TRN @Regression_TRN @IBRegScenarios_TRN
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Create ASN using Kelli for Singleline ASN Load having Invalid Item. Validate ASN should not available in Manhattan.
	Given I have excel data
	| TRN_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "InvalidItem" Kelli Upload Sheet
	And user upload the "InvalidItem" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And verify ASN not created and reached to Manhattan


@TRN004 @SingleLineEDI_TRN @Regression_THH @IBRegScenarios_TRN
Scenario: Receiving Case : ASN Load using Fedex Net for Item having Serial Tracked One Line Two QTY. 
Creating ASN through FedEx Net, checking status of the shipment, verify serial Numbers in two lines and complete receiving and Putaway.
	Given I have excel data
	| TRN_IBScenario004 |
	And Open the chrome browser by selenium
	When user update "TRN_Single_Line_PO" for dropping into fedexnet application	
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application
	
@TRN005 @DuplicateASN_TRN @Regression_THH @IBRegScenarios_TRN
Scenario: Receiving Case : Duplicate ASN Load using Fedex Net for Item having SerialTracked One Line Two QTY. 
Creating ASN through FedEx Net and checking status.Upload same Inbound XMl file.Manually check in email for the Alert for Duplicate ASN.
	Given I have excel data
	| TRN_IBScenario004 |
	And Open the chrome browser by selenium
	When user update "TRN_Single_Line_PO" for dropping into fedexnet application	
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"

@ILW001 @SingleLine_ILW @Regression_ILW @IBRegScenarios_ILW
Scenario: Receving Case : Single ASNLoad file for ILW Using Kelli for Item with Lot Revision and Expary.Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Single Line with Lot, Revision and Expary Item. Complete Putaway.
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
	
@ILW002 @MultiLine_ILW @Regression_ILW @IBRegScenarios_ILW
Scenario: Receving Case: MultiLine ASNLoad file for ILW Using Kelli for Item with Revision Lot and Serialzed.Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Multi Line Lot, Revision and Serialized Item. Complete Putaway.
 	Given I have excel data
	| ILW_KelliScenario002 |
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

@ILW003 @InvalidItemASN_ILW @Regression_ILW @IBRegScenarios_ILW
Scenario: Receiving Case : Single Line, Single iLPN with invalid item
Create ASN using Kelli for Singleline ASN Load having Invalid Item. Validate ASN should not available in Manhattan.
	Given I have excel data
	| ILW_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "InvalidItem" Kelli Upload Sheet
	And user upload the "InvalidItem" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And verify ASN not created and reached to Manhattan

@ILW004 @SingleLine_ILW @Regression_ILW @IBRegScenarios_ILW
Scenario: Receiving Case : Single ASNLoad file for ILW Using Kelli for Item with SerialTracked.Complete Putaway.
Creating ASN through Kelli, checking status of the shipment for Single Line Serial Tracked Item. Complete Putaway.
	Given I have excel data
	| ILW_KelliScenario004 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Serial Tracked" Kelli Upload Sheet
	And user upload the "Serial Tracked" Load file in Kelli
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
	
@THMOutBound @Regression_THM @OBRegScenarios_THM
Scenario: Create an order using O2S application for THM customer 
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

@THHOutBound @Regression_THH @OBRegScenarios_THH
Scenario: Create an order using O2S application for THH customer 
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
	
@ILWOutBound @Regression_ILW @OBRegScenarios_ILW
Scenario: Create an order using O2S application for ILW customer 
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
	
@TRNOutBound @Regression_TRN @OBRegScenarios_TRN
Scenario: Create an order using O2S application for TRN customer 
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
