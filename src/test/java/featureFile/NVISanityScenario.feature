Feature: Navico Inbound And Outbound Scenarios

@NVI_SanityScenarioTestingIB001 @IBSanityScenario_NVI @NVI_Rec&Putaway @Sanity_NVI
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

@NVI_SanityScenarioTestingIB002 @IBSanityScenario_NVI @NVI_Rec&Putaway @Sanity_NVI
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
	
@NVI_SanityScenarioTestingIB003 @IBSanityScenario_NVI @NVI_BlindReceipt @Sanity_NVI
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
	
@NVI_SanityScenarioTestingIB004 @IBSanityScenario_NVI @NVI_SplitiLPN @Sanity_NVIIgnoreDueToInspectionZoneIssue
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
	
@NVI_SanityScenarioTestingOB001 @OBSanityScenario_NVI @NVI_SplitiLPN @Sanity_NVI
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
	
@NVI_SanityScenarioTestingOB002 @OBSanityScenario_NVI @NVI_SplitiLPN @Sanity_NVI
Scenario: Distribution Order creation - Multi Line LTL FDFE LTLP 
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

@NVI_SanityScenarioTestingIB001_1 @IBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI
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
	
@NVI_SanityScenarioTestingIB002_1 @IBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI	
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
	
@NVI_SanityScenarioTestingIB003_1 @IBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI	
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
	
@NVI_SanityScenarioTestingIB004_1 @IBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI	
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
	
@NVI_SanityScenarioTestingOB001_1 @OBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI	
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

@NVI_SanityScenarioTestingOB002_1 @OBSanityScenarioL4NVI_NVI @SanityL4NVI_NVI	
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