Feature: Inbound Scenarios


	
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
	
	@tag1002 @Smoke
Scenario: B-345747 MANH - Receive and bypass stage or holding
Creating ASN through Post Message UI and complete receiving bypasing through staging location & validating LPN in Inventory by location
	Given I have excel data
	| Scenario2 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	Then user opens Inventory by location screen and validates the LPN created  
	Then user log out from application 
   
	@tag1003 @Smoke
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
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	

	@tag1004
Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
Creating ASN through Post Message UI and validate Overage percentage - allowable percentage  for customer receive as an associate
	Given I have excel data
	| Scenario3 |
	And Open the chrome browser by selenium
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
	
	
	@tag1005
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
	
	@tag1006
Scenario: Multi Line Receiving
Creating 2 line ASN through Post Message UI, checking status of the shipment and complete receiving in Staging location through RF Menu
	Given I have excel data
	| Scenario5 |
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

	
	@tag1007
Scenario: B-441160 Receiving Returned Un-Delivered Product using blind receipt
Receiving of Un-Delivered Product using blind receipt in MM3 returns menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario6 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	
	@tag1008
Scenario: B-441160 Receiving Returned Un-Delivered Product by creating ASN
Receiving of Un-Delivered Product in MM3 returns menu by creating ASN and verifying the status of the ASN 
	Given I have excel data
	| Scenario7 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
    When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user log out from application 
	
	@tag1009
Scenario: B-459309 Receive Damages: Receiving Damaged Product using MM3 Recv-Damages option from RF Menu using supervispr credentials
Receiving of Damaged Products in MM3 Recv-Damages option from RF menu and verifying the status of the ASN 
	Given I have excel data
	| Scenario10 |
	And Open the chrome browser by selenium
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
	
	@tag1010
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
	
	@tag1011
Scenario: B-467729 – Configure Manhattan for RF lock/unlock iLPN: Lock an iLPN using the user provided lock code
Create an iLPN using RF MM3 Create iLPN option and apply the lock code provided by user
	Given I have excel data
	| Scenario12 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
	And user opens RF menu and go to invenorty & perform "RF MM3 Create iLPN" operation
	And user open iLPN and applies the lock code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And validates the PIX Transactions "300,606" for this operation
	Then user log out from application 
	
	@tag1012
Scenario: B-467729 – Configure Manhattan for RF lock/unlock iLPN: Unlock an iLPN which already has some lock
	Given I have excel data
	| Scenario13 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	And user open iLPN and unlock the existing code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And validates the PIX Transactions "300,606" for this operation
	Then user log out from application 
	
	@tag1013
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Increase iLPN qty having no lock code before ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN and PIX transaction
	Given I have excel data
	| Scenario14 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	And user opens RF menu and "Increase" iLPN quantity using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Increase Qty" in iLPN
	And user views ASN, and validate ASN details
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 


@tag1014
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Decrease iLPN qty having no lock code before ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| Scenario15 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	And user opens RF menu and "Decrease" iLPN quantity using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Decrease Qty" in iLPN
	And user views ASN, and validate ASN details
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 
	
	@tag1015
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Increase iLPN qty having unallocatable lock code after ASN verification
Creating ASN through Post Message UI and complete receiving and verify the ASN & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN and PIX transaction
	Given I have excel data
	| Scenario16 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started"
	And user verifies the ASN
	And user opens RF menu and "Increase" iLPN quantity using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Increase Qty" in iLPN
	And user views ASN, and validate ASN details
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 


@tag1016
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Decrease iLPN qty having unallocatable lock code after ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| Scenario17 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started"
	And user verifies the ASN
	And user opens RF menu and "Decrease" iLPN quantity using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Decrease Qty" in iLPN
	And user views ASN, and validate ASN details
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 
	
	@tag1017
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Delete line from an iLPN having no lock code before ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by deletinh the line & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| Scenario18 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	And user opens RF menu and "Delete Line" from an iLPN using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Delete Line" in iLPN
	And user views ASN, and validate ASN details after deleting a line from iLPN
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 
	
@tag1018
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Delete line from an iLPN having unallocatable lock code after ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| Scenario19 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started"
	And user verifies the ASN
	And user opens RF menu and "Delete Line" from an iLPN using "Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Delete Line" in iLPN
	And user views ASN, and validate ASN details after deleting a line from iLPN
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 
	
	@tag1019
Scenario: B-474831 FXL-FFD-CIL-MH_Inventory Control-Base Transactions# 4- Consume iLPN having no lock
Creating ASN through Post Message UI and complete receiving bypasing through staging location & 
validating iLPN have no lock & consume the iLPN using RF Menu. Also validate PIX transaction
	Given I have excel data
	| Scenario20 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	#Then user opens ASN screen and searches for the ASN and verify its status "InTransit" 
	#And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "QSC Recv BpStgD" menu
	#And user views ASN, get and verify item details
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user opens RF menu and go to invenorty & perform "Consume iLPN" operation
	Then user search for the LPN in iLPN screen, and validate the iLPN status
	And validates the PIX Transactions "300" for consuming iLPN
	Then user log out from application 
	
	@tag1020
Scenario: B-474831 FXL-FFD-CIL-MH_Inventory Control-Base Transactions# 4- Consume iLPN having lock code
Creating iLPN through MM3 Create iLPN menu & applythe lock code,validating iLPN have some lock code & consume 
the iLPN using RF Menu. Also validate PIX transaction.
Given I have excel data
	| Scenario21 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials 
	And user opens RF menu and go to invenorty & perform "RF MM3 Create iLPN" operation
	And user open iLPN and applies the lock code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user opens RF menu and go to invenorty & perform "Consume iLPN" operation
	Then user search for the LPN in iLPN screen, and validate the iLPN status
	And validates the PIX Transactions "606" for consuming iLPN
	Then user log out from application 
	
	@tag1021
Scenario: B- 466712 Putaway – Un-Delivered Products that was received in MM3 returns
Receiving of Un-Delivered Product using MM3 returns menu and complete putaway to inspection area Validate the 
iLPN moved to inspection area and	“QSCINS” Locations Current Quantity will be incremented with no of LPN’s moved to location
	Given I have excel data
	| Scenario22 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Supervisor" Credentials
	#When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
   # And user update xml itemDetails from excel sheet
   # And user opens post message screen and upload file in order to create ASN 
	#Then user verify the response 
	#And user views ASN, get and verify item details 
	#And user opens RF menu and completes Receiving using "MM3 Returns" menu
	#Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	#Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "QSCINS" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy-Sys Dir" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QSCINS" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone
	Then user log out from application 
	
	
	@tag1022
Scenario: B- 466712 Putaway – Damaged Products that was received using MM3 Recv-Damages having lock code DM-Damaged Return
Receiving of Damaged Product in MM3 Recv-Damages menu and complete putaway to inspection area. Validate the iLPN moved 
to inspection area and	“QSCINS” Locations Current Quantity will be incremented with no of LPN’s moved to location
	Given I have excel data
	| Scenario23 |
	When user logs into Manhattan application using "Associate" Credentials 
    When user create xml file using "Single Line ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
    And user update xml itemDetails from excel sheet
    And user opens post message screen and upload file in order to create ASN 
	Then user verify the response 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "QSCINS" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy-Sys Dir" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QSCINS" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone
	Then user log out from application 
	
	@tag1023
Scenario: B- 466712 Putaway – Damaged Products that was received using blind receipt in MM3 returns
Receiving of Damaged Product using blind receipt in MM3 returns menu and complete putaway to inspection area
Validate the iLPN moved to inspection area and	“QSCINS” Locations Current Quantity will be incremented with no of LPN’s 
moved to location
	Given I have excel data
	| Scenario24 |
	And Open the chrome browser by selenium
	When user logs into Manhattan application using "Associate" Credentials
	And user opens RF menu and completes Receiving using "MM3 Returns" menu
	Then user opens ASN screen and searches for the ASN and verify its status "Receiving Started" 
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "QSCINS" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy-Sys Dir" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QSCINS" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone
	Then user log out from application 