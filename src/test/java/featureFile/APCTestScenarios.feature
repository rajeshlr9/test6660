Feature: This feature file contains the APC Regression Scenarios.

@InBoundScenario_APC_1 @IBRegScenarios_APC @DailyRegression_APC 
Scenario: Receiving SingleLine Lot Items for Cooler type item.
	Given I have excel data
	| APC_IBScenario001 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
	
@InBoundScenario_APC_2 @IBRegScenarios_APC @DailyRegression_APC
Scenario: Receiving SingleLine Normal Items for Ambient type item.
	Given I have excel data
	| APC_IBScenario002 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
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
	And user log out from application 
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_3 @IBRegScenarios_APC @DailyRegression_APC
Scenario: Receiving for SingleLine Serial Items for Ambient type item.
	Given I have excel data
	| APC_IBScenario003 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - SerailItems" for dropping into fedexnet application
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
	And user log out from application 
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_4 @IBRegScenarios_APC @DailyRegression_APC
Scenario: Receiving and Putaway for SingleLine Normal Items for Hazmat type item. 
	Given I have excel data
	| APC_IBScenario004 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - NormalItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_5 @IBRegScenarios_APC @DailyRegression_APC
Scenario:  Receiving and Putaway for SingleLine Lot Items for Freezer type item. 
	Given I have excel data
	| APC_IBScenario005 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens Items screen and find putaway type
	And user opens RF menu and completes Receiving using "MM1 Recv-Ptwy FRZ" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
		
@InBoundScenario_APC_6 @IBRegScenarios_APC @DailyRegression_APC
Scenario: Receiving and Putaway for SingleLine Lot Items for Abaxis type item. 
	Given I have excel data
	| APC_IBScenario006 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	  
@InBoundScenario_APC_7 @IBRegScenarios_APC @DailyRegression_APC
Scenario:  Receiving Multiline Lot Items of Cooler type having both items and quantity differ.  
	Given I have excel data
	| APC_IBScenario007 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_8 @IBRegScenarios_APC @DailyRegression_APC
Scenario:  Receiving Multiline Normal Items of Ambient type having both items and quantity differ. 
	Given I have excel data
	| APC_IBScenario008 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - NormalItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_9 @IBRegScenarios_APC @DailyRegression_APC
Scenario:  Receiving Multiline Serial Items of Ambient having both items differ but quantity same.
	Given I have excel data
	| APC_IBScenario009 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - SerialItems" for dropping into fedexnet application
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
	And user log out from application	
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_10 @IBRegScenarios_APC @DailyRegression_APC
Scenario:  Receiving Multiline Lot Items with Same Items and Same Quantity for Abaxis Item  
	Given I have excel data
	| APC_IBScenario010 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application
	
@InBoundScenario_APC_11 @IBRegScenarios_APC @DailyRegression_APC
Scenario: Rceiving Multiline Normal Items with Same Item and Same Quantity for Hazmat Item.  
	Given I have excel data
	| APC_IBScenario011 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine PO - NormalItems" for dropping into fedexnet application
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
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "861" file in fedexnet
	Then user log out from Fedenxet application

@InBoundScenario_APC_12	@IBRegScenarios_APC @DailyRegression_APC
Scenario:  Create and Upload X12 file Using Kelli and Veirify ASN Staus in Manhattan. 
 	Given I have excel data
	| APC_KelliScenario001 |
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
		
@OutBoundScenario_APC_1	@OBRegScenarios_APC  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal Item
	Given I have excel data
	| APC_OBScenario01 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
		
@OutBoundScenario_APC_2	@OBRegScenarios_APC  @DailyRegression_APC
Scenario: SingleLine LTL DO Order for Normal Item
	Given I have excel data
	| APC_OBScenario02 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
		
@OutBoundScenario_APC_3	@OBRegScenarios_APC  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Serial Item
	Given I have excel data
	| APC_OBScenario05 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - SerailItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application 
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_4	@OBRegScenarios_APC  @DailyRegression_APC
Scenario: SingleLine LTL DO Order for Serial Item
	Given I have excel data
	| APC_OBScenario06 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - SerailItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application

@OutBoundScenario_APC_5	@OBRegScenarios_APC @DailyRegression_APC
Scenario: Multiline Parcel Do Order for Normal Items having Same Items Id
	Given I have excel data
	| APC_OBScenario07 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine DO - NormalItemsProdStaus" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "170 - Manifested"
	And user opens DO screen and searches for the DistributionOrder and verify its status "170 - Manifested"
	Then user search for DO and confirms it
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped"  
	Then user log out from application 
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_6	@OBRegScenarios_APC_Ignore @DailyRegression_APC_Ignore
Scenario: Multiline Parcel Order for Normal Items having differnt Items Id
	Given I have excel data
	| APC_OBScenario08 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_7	@OBRegScenarios_APC @DailyRegression_APC
Scenario:  Multiline LTL Order with Normal Items having differnt Items Id
	Given I have excel data
	| APC_OBScenario09 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_8 @OBRegScenarios_APC @DailyRegression_APC
Scenario:  Multiline Parcel Order with Serial Items having differnt Items Id
	Given I have excel data
	| APC_OBScenario10 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine DO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_9 @OBRegScenarios_APC @DailyRegression_APC
Scenario:  Multiline LTL Order with Serial Items having differnt Items Id
	Given I have excel data
	| APC_OBScenario11 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC MultiLine DO - SerialItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
	
@OutBoundScenario_APC_10 @OBRegScenarios_APC_Ignore @DailyRegression_APC_Ignore
Scenario: SingleLine LTL Do Order for Lot Items
	Given I have excel data
	| APC_IBScenario012 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application     
	Given I have excel data
	| APC_OBScenario12 |
	#Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	#And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
	
@OutBoundScenario_APC_11 @OBRegScenarios_APC_Ignore @DailyRegression_APC_Ignore
Scenario: SingleLine Parcel DO Order with Lot Items.
	Given I have excel data
	| APC_IBScenario012 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine PO - LotItems" for dropping into fedexnet application
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
	And user log out from application  
	Given I have excel data
	| APC_OBScenario13 |
	Given user update EDI file "APC SingleLine DO - LotItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	

#@OutBoundScenario_APC_14 @OBRegScenarios_APC  @DailyRegression_APC
#Scenario: SingleLine LTL DO Order for Normal Item having Ambient item
#	Given I have excel data
#	| APC_OBScenario15 |
#	Given Open the chrome browser by selenium
#	Given user update EDI file "APC SingleLine DO - NormalItems" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "850" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
#	Then user verifies the item details in Distribuion Order page 
#	And user runs the "APC LTL Pick Wave"
#	Then user views wave and verify the allocation of inventory 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
#	And fetch the OLPN number
#	And user open RF Menu and complete the pick tasks created 
#	And user open RF Menu and complete the pack tasks created
#	And user opens the OLPN screen and retrieve the splitted oLPN
#	And user perform weigh and manifest and verify status "160 - Weighed"
#	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
#	And user navigates to shippment planning workspace 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
#	And user log out from application	

@OutBoundScenario_APC_12	@OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal Item Hazmath type
	Given I have excel data
	| APC_OBScenario14 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_13	@OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal Item for Pack instruction
	Given I have excel data
	| APC_OBScenario15 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems - Pack" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page 
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
		
@OutBoundScenario_APC_14	@OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal Item for UPSN service
	Given I have excel data
	| APC_OBScenario16 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems - UPSN" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_15	@OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine LTL DO Order for Normal Item for International order
	Given I have excel data
	| APC_OBScenario17 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems - InternationalOrder" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created
 	And user open RF Menu and complete the pack tasks created
	#Then fetch the OLPN number with only 30 weighed status 
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	#And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_16	@OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal item Hazmath type for UPSN service
	Given I have excel data
	| APC_OBScenario18 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems - UPSN" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_17 @OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine LTL DO Order for Normal Item having Cooler item with temp strip
	Given I have excel data
	| APC_OBScenario19 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - TempStrip" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "APC LTL Pick Wave"
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And fetch the OLPN number
	And user open RF Menu and complete the pick tasks created 
	And user open RF Menu and complete the pack tasks created
	And user opens the OLPN screen and retrieve the splitted oLPN
	And user perform weigh and manifest and verify status "160 - Weighed"
	And user opens RF menu and completes Shipping using "MM1 Anchor oLPN" menu 
	And user opens DO screen and searches for the DistributionOrder and verify its status "165 - Staged" 
	And user navigates to shippment planning workspace 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 	
	And user log out from application
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	
@OutBoundScenario_APC_18 @OBRegScenarios_APC1  @DailyRegression_APC
Scenario: SingleLine Parcel DO Order for Normal Item for International order with item cost more than twenty five hundred
	Given I have excel data
	| APC_OBScenario20 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC SingleLine DO - NormalItems - LargeCost" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	Then user verifies the shipVia populated in Distribuion Order page
	And user runs the "APC PCL Pick Wave"
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
	And user logs into the FedexNet application for verify files
	And user verify the "856" file in fedexnet
	Then user log out from Fedenxet application
	


