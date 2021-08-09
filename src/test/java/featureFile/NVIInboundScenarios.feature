Feature: Inbound Scenarios 

@NVI_IB001 @Regression_NVI @NVI_PostMsg  @Sanity_NVI
Scenario: Verify ASN creation through Post MessageUI-excel 
	Creating ASN through Post Message UI & verifying the response, checking status of the shipment
	Given I have excel data 
		| NVI_IBScenario001 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	Then user log out from application 
	
	
@NVI_IB002 @Regression_NVI @NVI_BypassStagingLocPallet
Scenario: Receiving of ASN bypassing staging location (Pallet) - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (Pallet) - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario002 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
@NVI_IB003 @Smoke @Regression_NVI @NVI_BypassStagingLocationRec 
Scenario: Receiving of ASN bypassing staging location (Pallet) - Single Line, Single Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (Pallet) - Single Line, Single Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario003 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
@NVI_IB004 @Smoke @Regression_NVI @NVI_BypassStagingLocPallet 
Scenario: Partial Receiving of ASN bypassing staging location (Pallet) - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and complete partial receiving bypassing staging 
	location (Pallet) - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario004 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	
@NVI_IB005 @Regression_NVI @NVI_BypassStagingLocPallet 
Scenario: Over Receiving of ASN bypassing staging location (Pallet) - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and complete over receiving bypassing staging 
	location (Pallet) - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario005 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	
@NVI_IB006 @Smoke @Regression_NVI @NVI_BypassStagingLocPallet 
Scenario: Receiving of ASN bypassing staging location (Pallet) - Multi Line, Single Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and complete receiving bypassing staging 
	location (Pallet) - Multi Line, Single Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario006 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
@NVI_IB007 @Smoke @Regression_NVI @NVI_BypassStagingLocPallet 
Scenario: Receiving of ASN bypassing staging location (Pallet) - Multi Line, Multiple Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and complete receiving bypassing staging 
	location (Pallet) - Multi Line, Multiple Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario007 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-PLT-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 

	
	@NVI_IB008 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Receiving of ASN bypassing staging location (case) - Single Line, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (case) - Single Line, Single iLPN
	Given I have excel data 
		| NVI_IBScenario008 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-CASE-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user opens iLPN screen and validate iLPN status "30 - Putaway"
	Then user log out from application 
	
	@NVI_IB009 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Receiving of ASN bypassing staging location (case) - Single Line, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (case) - Single Line, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario009 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-CASE-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user opens iLPN screen and validate iLPN status "30 - Putaway"
	Then user log out from application
	
	@NVI_IB010 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Partial Receiving of ASN bypassing staging location (case) - Single Line, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed partial receiving bypassing staging 
	location (case) - Single Line, Single iLPN
	Given I have excel data 
		| NVI_IBScenario010 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-CASE-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user opens iLPN screen and validate iLPN status "30 - Putaway"
	Then user log out from application
	
	@NVI_IB011 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Over Receiving of ASN bypassing staging location (case) - Single Line, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed over receiving bypassing staging 
	location (case) - Single Line, Single iLPN
	Given I have excel data 
		| NVI_IBScenario011 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-CASE-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user opens iLPN screen and validate iLPN status "30 - Putaway"
	Then user log out from application
	
	@NVI_IB012 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Receiving of ASN bypassing staging location (case) - Multi Line, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (case) - Multi Line, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario012 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Rec-CASE-Ptwy" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user opens iLPN screen and validate iLPN status "30 - Putaway"
	Then user log out from application
	
	@NVI_IB013 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario013 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB014 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Single Line, Single Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Single Line, Single Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario014 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB015 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Multi Line, Single Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Multi Line, Single Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario015 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB016 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Multi Line, Multiple Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Multi Line, Multiple Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario016 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB017 @Regression_NVI @NVI_PalletRec
Scenario: Partial Receiving of ASN on to a Pallet - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed partial receiving in a 
	Pallet - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario017 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB018 @Regression_NVI @NVI_PalletRec
Scenario: Over Receiving of ASN on to a Pallet - Single Line, Single Pallet, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed over receiving in a 
	Pallet - Single Line, Single Pallet, Single iLPN
	Given I have excel data 
		| NVI_IBScenario018 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB019 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Multi Line (same item in both lines), Multiple Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Multi Line(same item in both lines), Multiple Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario019 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application 
	
	@NVI_IB020 @Regression_NVI @NVI_PalletRec
Scenario: Receiving of ASN on to a Pallet - Multi Line (same item in both lines), Single Pallet, Multiple iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving in a 
	Pallet - Multi Line(same item in both lines), Multiple Pallet, Multiple iLPN
	Given I have excel data 
		| NVI_IBScenario020 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-PLT" menu 
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user views ASN, get and verify pallet status is "30 - Putaway" 
	Then user log out from application
	
	@NVI_IB021 @Regression_NVI @NVI_DamagedReceive&Putaway
Scenario: Receive Damages- Receiving Damaged Product using MM3 Recv-Damages & complete Putaway - Single Line
Receiving of Damaged Products in MM3 Recv-Damages option & complete Putaway
	Given I have excel data
	| NVI_IBScenario021 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "NV111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "NV111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "NV111A1"
	Then user log out from application 
	
	@NVI_IB022 @Regression_NVI @NVI_DamagedReceive&Putaway
Scenario: Receive Damages- Receiving Damaged Product using MM3 Recv-Damages & complete Putaway - Multi Line
Receiving of Damaged Products in MM3 Recv-Damages option & complete Putaway
	Given I have excel data
	| NVI_IBScenario022 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file using "Multi Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "NV111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "NV111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "NV111A1"
	Then user log out from application 
	
	@NVI_IB023 @Regression_NVI @NVI_UnDeliveredReceive&Putaway
	Scenario: Receiving Returned Un-Delivered Product by creating ASN & completing Putaway - Single Line
Receiving of Un-Delivered Product in MM3 returns menu by creating ASN, validating lock code and completing putaway
	Given I have excel data
	| NVI_IBScenario023 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "NV111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "NV111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "NV111A1"
	Then user log out from application

	@NVI_IB024 @Regression_NVI @NVI_UnDeliveredReceive&Putaway
	Scenario: Receiving Returned Un-Delivered Product using blind receipt & completing Putaway
Receiving Returned Un-Delivered Product using blind receipt & validaing lock code, Completing putaway 
Given I have excel data
	| NVI_IBScenario024 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "NV111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "NV111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "NV111A1"
	Then user log out from application 
	
	
	@NVI_IB025 @Regression_NVI @NVI_CaseRec&Putaway
Scenario: Receiving Case : Single Line, Single iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| NVI_IBScenario025 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails from excel sheet 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	#Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 