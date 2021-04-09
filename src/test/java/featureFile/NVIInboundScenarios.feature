Feature: Inbound Scenarios 

@NVI_IB001 @Regression_NVI @NVI_PostMsg 
Scenario: Verify ASN creation through Post MessageUI-excel 
	Creating ASN through Post Message UI & verifying the response, checking status of the shipment
	Given I have excel data 
		| NVI_Scenario001 |
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
		| NVI_Scenario002 |
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
		| NVI_Scenario003 |
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
		| NVI_Scenario004 |
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
		| NVI_Scenario005 |
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
		| NVI_Scenario006 |
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
		| NVI_Scenario007 |
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
	
@NVI_IB108 @Smoke @Regression_NVI @NVI_BypassStagingLocPallet 
Scenario: Verify pallet status 
	Login and validate Pallet status
	Given I have excel data 
		| NVI_Scenario007 |
	And Open the chrome browser by selenium 
	And user logs into the Manhattan application 
	Then user views ASN, get and verify pallet details
	
	@NVI_IB008 @Regression_NVI @NVI_BypassStagingLocCase
Scenario: Receiving of ASN bypassing staging location (case) - Single Line, Single iLPN
	Creating ASN through Post Message UI, checking status of the shipment and completed receiving bypassing staging 
	location (case) - Single Line, Single iLPN
	Given I have excel data 
		| NVI_Scenario008 |
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
		| NVI_Scenario009 |
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
		| NVI_Scenario010 |
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
		| NVI_Scenario011 |
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
		| NVI_Scenario012 |
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