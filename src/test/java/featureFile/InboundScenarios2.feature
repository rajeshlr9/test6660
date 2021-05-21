Feature: Inbound Scenarios

@tagq3 
Scenario: 
	Open Browser by selenium and complete login using LeanFT (Work on same application) 
	Given Open the IE by selenium 
	Then Attach LeanFT IE browser to seleniumTest 
	Then Login to OMS by LeanFT 
	Then Close browser opened by LeanFT 
	
@tagq4 
Scenario: Create Order via Filezilla using Leanft and Resume order in O2S via Selenium(Work on 2 application) 
	Given Open Filezilla 
	When user connects to EMC customer and drop an OB order 
	#When User open Browser 
	#And Login to OMS using Selenium 
	#And Search for the dropped order using Selenium 
	#And Resume the incomplete order using Selenium 
	#Then Order is placed successfully 
	
@tagq641 
Scenario: Cream the butter
	Given I have excel data
	| Scenario9 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Admin" Credentials
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user log out from application	
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Admin" Credentials
	#Then user log out from application	
	
	
@tagq5 
Scenario: Complete adhoc move in Putty using Leanft 
	Given Open Putty 
	When user login to Putty 
	And Complete adhoc move 
		| Start_Location | ItemType | ItemID   | Quantity | SuggestedLoc |
		| STG001R        | Normal   | 7181E-01 |        1 |              |
	Then Items are moved successfully 
	
@tagq7 
Scenario: Create an Order in O2S using Selenium by taking data from Excel 
	Given I have excel data 
		| Scenario7 |
	When User open Browser 
	And Login to OMS using Selenium 
	And Add destination Details 
	And Add Inventory Details 
	And Enter Route Details 
	And Enter Placement Details 
	Then Order is placed successfully 
	
@tagq87 
Scenario: Veriy ASN creation through Post MessageUI1 
	Given I have excel data
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	When user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails <noOfItem> from sheet "<SheetName>" with "<ShippedQty>","<QtyUOM>","<TCName>" for receiving ASN 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu for "50" item in "STG001R" 
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application	
	
@tagq56
Scenario: Veriy ASN creation through Post MessageUI1 
	Given I have excel data
	| Scenario87 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	When user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails <noOfItem> from sheet "<SheetName>" with "<ShippedQty>","<QtyUOM>","<TCName>" for receiving ASN 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	
	@taqg2001
Scenario: Veriy ASN creation through Post MessageUI-excel-linux
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| Scenario1 |
	And Set the chrome browser by seleniumi in linux
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	
	
	@tagq1001
Scenario: Veriy ASN creation through Post MessageUI-excel
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| Scenario1 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	
	@tagq1002
Scenario: B-345747 MANH - Receive and bypass stage or holding
Creating ASN through Post Message UI and complete receiving bypasing through staging location & validating LPN in Inventory by location
	Given I have excel data
	| Scenario2 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	Then user opens Inventory by location screen and validates the LPN created  
	Then user log out from application 
   
	@tag1q003
Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
Creating ASN through Post Message UI and validate Overage percentage - allowable percentage  for customer
	Given I have excel data
	| Scenario3 |
	And Set the chrome browser by seleniumi in linux
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu  
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	

	@tagq1004
Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
Creating ASN through Post Message UI and validate Overage percentage - allowable percentage  for customer receive as an associate
	Given I have excel data
	| Scenario3 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	When user logs into Manhattan application using "Admin" Credentials
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	Then user log out from application 
	When user logs into Manhattan application using "Associate" Credentials
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu  
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 	
	
	
	@tagq1005
Scenario: B-345784 MANH - Break Split LPN IB
Creating ASN through Post Message UI and receiving in 2 LPN's. Move few quantities from 1st LPN to 2nd location & validating LPN's in Inventory by location
	Given I have excel data
	| Scenario4 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu 
	Then user break Split LPN and move to another LPN of same ASN 
	Then user opens Inventory by location screen and validates the LPN moved
	#Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started"
	Then user log out from application 
	
	@tagq1006
Scenario: Multi Line Receiving
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| Scenario5 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started"
	Then user log out from application 

	
	@tagq1007
Scenario: B-441160 Receiving Returned Un-Delivered Product using blind receipt
Receiving of Un-Delivered Product using blind receipt in MM3 returns menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario6 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	
	@tagq1008
Scenario: B-441160 Receiving Returned Un-Delivered Product by creating ASN
Receiving of Un-Delivered Product in MM3 returns menu by creating ASN and verifying the status of the ASN 
	Given I have excel data
	| Scenario7 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	
	@tagq1009
Scenario: Receiving Damaged Product using MM3 Recv-Damages option from RF Menu using supervispr credentials
Receiving of Damaged Products in MM3 Recv-Damages option from RF menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario10 |
	And Set the chrome browser by seleniumi in linux
	#And Open the chrome browser by selenium
	When user logs into Manhattan application using "Supervisor" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	@tagq1010
Scenario: Receiving of Damaged Returned Product using blind receipt
Receiving of Damaged Returned Product using blind receipt in MM3 returns menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario11 |
	And Set the chrome browser by seleniumi in linux
	When user logs into Manhattan application using "Associate" Credentials  
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	@tagq1011
Scenario: Lock an iLPN using the user provided lock code
Create an iLPN using RF MM3 Create iLPN option and apply the lock code provided by user
	Given I have excel data
	| Scenario12 |
	And Set the chrome browser by seleniumi in linux
	And user opens RF menu and create iLPN using "RF MM3 Create iLPN" menu
	And user open iLPN and applies the lock code
	Then user validates that lock code is applied successfully
	Then user log out from application 
	
	
	@tag11010
Scenario: B-459309 Receive Damages: Receiving of Damaged Returned Product using blind receipt
Receiving of Damaged Returned Product using blind receipt in MM3 returns menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario11 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials  
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	
@Scenarioq9999
Scenario Outline: Verify ASN creation through Post MessageUI 
	Given user log in to the Manhattan application 
	Given Open the chrome browser by selenium
	And user logs into the Manhattan application
	When user create xml file with <noOfItem> updated DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails <noOfItem> from sheet "<SheetName>" with "<ShippedQty>","<QtyUOM>","<TCName>" for receiving ASN 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu for <noOfItem> item in "<RecivingLoc>" 
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	
	Examples: 
		| TCName      | noOfItem | SheetName | ShippedQty | QtyUOM | RecivingLoc | ShipByDate|
		| Scenario8   |        1 | Item      | 50/        | EA/    | STG001R     | 07-31-2020|
		
		
@QSC_oldPostmsg
Scenario: Verify ASN creation through Post MessageUI-excel
Creating ASN through Post Message UI & verifying the response, checking status of the shipment
	Given I have excel data
	| QSC_IBScenario001 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
	
	
@QSC_OBoldpost
Scenario: Distribution Order Shipping - Single Line 
	Given I have excel data 
		| QSC_OBScenario001 |
	And Open the chrome browser by selenium 
	When user logs into the Manhattan application 
	When user create xml file using "Single Line DO" with updated DO_No 
	And user update xml itemDetails from excel sheet for DO
	And user opens post message screen and upload file in order to create DO 
	Then user verify the response for DO creation
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application 	