Feature: Inbound Scenarios

@tag3 
Scenario: 
	Open Browser by selenium and complete login using LeanFT (Work on same application) 
	Given Open the IE by selenium 
	Then Attach LeanFT IE browser to seleniumTest 
	Then Login to OMS by LeanFT 
	Then Close browser opened by LeanFT 
	
@tag4 
Scenario: 
	Create Order via Filezilla using Leanft and Resume order in O2S via Selenium(Work on 2 application) 
	Given Open Filezilla 
	When user connects to EMC customer and drop an OB order 
	When User open Browser 
	And Login to OMS using Selenium 
	And Search for the dropped order using Selenium 
	And Resume the incomplete order using Selenium 
	Then Order is placed successfully 
	
@tag5 
Scenario: Complete adhoc move in Putty using Leanft 
	Given Open Putty 
	When user login to Putty 
	And Complete adhoc move 
		| Start_Location | ItemType | ItemID   | Quantity | SuggestedLoc |
		| STG001R        | Normal   | 7181E-01 |        1 |              |
	Then Items are moved successfully 
	
@tag7 
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
	
@tag87 
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
	
@tag56
Scenario: Veriy ASN creation through Post MessageUI1 
	Given I have excel data
	| Scenario87 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	When user create xml file with Item Value updated with DeliveryStartDate for ReceivingASN 
	And user update xml itemDetails <noOfItem> from sheet "<SheetName>" with "<ShippedQty>","<QtyUOM>","<TCName>" for receiving ASN 
	And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	
	@tag1001
Scenario: Veriy ASN creation through Post MessageUI-excel
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location through RF Menu
	Given I have excel data
	| Scenario1 |
	And Open the chrome browser by selenium
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
	
	@tag1002
Scenario: B-345747 MANH - Receive and bypass stage or holding
Creating ASN through Post Message UI and complete receiving bypasing through staging location & validating LPN in Inventory by location
	Given I have excel data
	| Scenario2 |
	And Open the chrome browser by selenium
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
   
	@tag1003
Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
Creating ASN through Post Message UI and validate Overage percentage - allowable percentage  for customer
	Given I have excel data
	| Scenario3 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu  
	Then user log out from application 
	
	@tag1004
Scenario: B-345784 MANH - Break Split LPN IB
Creating ASN through Post Message UI and receiving in 2 LPN's. Move few quantities from 1st LPN to 2nd location & validating LPN's in Inventory by location
	Given I have excel data
	| Scenario4 |
	And Open the chrome browser by selenium
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
	
@tag81 
Scenario: Veriioppfy ASN creation through Post MessageUI1 
	Given I have excel data
	| Scenario4 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	Then user break Split LPN and move to another LPN of same ASN 
@tag82 
Scenario: Veriioppfy ASN creation through Post MessageU 
	Given I have excel data
	| Scenario1 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	
@Scenario8 
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
