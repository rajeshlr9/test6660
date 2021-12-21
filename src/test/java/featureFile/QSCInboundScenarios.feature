Feature: QSC Inbound Scenarios

#@QSC_IB000 @Regression_QSC @QSC_LoginFunctionality @Smoke_QSC
#Scenario: Verify Manhattan login using different user roles
#	Given I have excel data
#	| QSC_IBScenario000 |
#	And Open the chrome browser by selenium
#	When user logs into Manhattan application using "Admin" Credentials
#	Then user log out from application 
#	And user logs into the Manhattan application
#	Then user log out from application 
#	When user logs into Manhattan application using "Supervisor" Credentials
#	Then user log out from application 

@QSC_IB001 @Regression_QSC  @Smoke_QSC @QSC_EDIOrderReceiving @QSC_Inbound
Scenario: Verify ASN creation through EDI
Creating ASN through EDI & checking status of the shipment
	Given I have excel data
	| QSC_IBScenario001 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 

	
	@QSC_IB002 @Regression_QSC  @QSC_Rec&Putaway @SanityTest_QSC @QSC_Inbound
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
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN
	Then user log out from application 
	
	@QSC_IB00321 @Regression_QSC  @QSC_Rec&Putaway @QSC_Inbound
Scenario: Receiving Case : Single Line, Multiple iLPN
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location 
through RF Menu
	Given I have excel data
	| QSC_IBScenario002_1 |
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
	
	@QSC_IB003 @Regression_QSC @QSC_BypassStagingLocationRec @SanityTest_QSC @QSC_Inbound
Scenario: B-345747 MANH - Receive and bypass stage or holding
Creating ASN through Post Message UI and complete receiving bypasing through staging location & validating LPN in Inventory by location
	Given I have excel data
	| QSC_IBScenario003 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes "MM3 Rec-CASE-Ptwy" operation in Misc menu
	Then user opens Inventory by location screen and validates the LPN created  
	And user open reserve locations and naviagtes to validate iLPN
	Then user log out from application 
   
#	@QSC_IB004  @Regression_QSC @QSC_OverReceive
#Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
#Creating ASN through Post Message UI and validate Overage percentage - allowable percentage  for customer
#	Given I have excel data
#	| QSC_IBScenario004 |
#	And Open the chrome browser by selenium
#	When user update "Single Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu  
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
#	Then user log out from application 
	

#	@QSC_IB004_01 @Regression_QSC @QSC_OverReceive
#Scenario: B-345766 Configure Receipt for Overage percentage -  allowable percentage  for customer
#Creating ASN through Post Message UI using admin credentials and validate Overage percentage - allowable percentage  for customer receive as an associate
#	Given I have excel data
#	| QSC_IBScenario004 |
#	And Open the chrome browser by selenium
#	When user update "Single Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	When user logs into Manhattan application using "Admin" Credentials
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	Then user log out from application 
#	And user logs into the Manhattan application
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu  
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
#	Then user log out from application 	
	
	
	@QSC_IB005 @Regression_QSC @QSC_SplitiLPN @QSC_Inbound
Scenario: B-345784 MANH - Break Split LPN IB
Creating ASN through Post Message UI and receiving in 2 LPN's. Move few quantities from 1st LPN to 2nd location & validating LPN's in Inventory by location
	Given I have excel data
	| QSC_IBScenario005 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu 
	Then user break Split LPN and move to another LPN of same ASN 
	Then user opens Inventory by location screen and validates the LPN moved
	#Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	Then user log out from application 
	
	@QSC_IB006 @Regression_QSC @QSC_Rec&Putaway @QSC_Inbound
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

	
	@QSC_IB007 @Regression_QSC @QSC_BlindReceipt @QSC_Inbound
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
	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC111A1"
	Then user log out from application
	
	
#	@QSC_IB008 @Regression_QSC  @QSC_UnDeliveredReceive
#Scenario: B-441160 Receiving Returned Un-Delivered Product by creating ASN & completing putaway
#Receiving of Un-Delivered Product in MM3 Rtrn/Ovrg menu by creating ASN and verifying the status of the ASN & completing Putaway
#	Given I have excel data
#	| QSC_IBScenario008 |
#	And Open the chrome browser by selenium
#	And user logs into the Manhattan application 
#    When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
#    And user update xml itemDetails from excel sheet
#    And user opens post message screen and upload file in order to create ASN 
#	Then user verify the response 
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
#	And user verifies the ASN "40 - Receiving Verified"
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
#	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
#	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
#	Then validates that the iLPN is also moved to inspection zone "QC111A1"
#	Then user log out from application
	
	@QSC_IB009 @Regression_QSC @QSC_DamagedReceivePutaway @QSC_Inbound
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
	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC111A1"
	Then user log out from application
	
	@QSC_IB010 @Regression_QSC @QSC_BlindReceipt @QSC_Inbound
Scenario: B-459309 Receive Return Damages- Receiving of Damaged Returned Product using blind receipt & completing Putaway
Receiving of Damaged Returned Product using blind receipt in MM3 Rtrn/Ovrg menu and verifying the status of the ASN & completing Putaway
	Given I have excel data
	| QSC_IBScenario010 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application  
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started" 
	And user verifies the ASN "40 - Receiving Verified"
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC111A1"
	Then user log out from application
	
	@QSC_IB010_1 @Regression_QSC @QSC_BlindReceipt @QSC_Inbound
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
	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
	Then validates that the iLPN is also moved to inspection zone "QC111A1"
	Then user log out from application
	
	@QSC_IB011 @Regression_QSC @QSC_LockUnlockFunctionality @QSC_Inbound
Scenario: B-467729 – Configure Manhattan for RF lock-unlock iLPN-- Lock an iLPN using the user provided lock code
Create an iLPN using RF MM3 Create iLPN option and apply the lock code provided by user
	Given I have excel data
	| QSC_IBScenario011 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and go to invenorty & perform "RF MM3 Create iLPN" operation
	And user open iLPN and applies the lock code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And validates the PIX Transactions "300,606" for this operation
	Then user log out from application 
	
	@QSC_IB012 @Regression_QSC @QSC_LockUnlockFunctionality @QSC_Inbound
Scenario: B-467729 – Configure Manhattan for RF lock-unlock iLPN-- Unlock an iLPN which already has some lock
	Given I have excel data
	| QSC_IBScenario012 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application
	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
	And user open iLPN and unlock the existing code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And validates the PIX Transactions "300,606" for this operation
	Then user log out from application 
	
	@QSC_IB013 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 Inventory Adjustments- Increase iLPN qty having no lock code
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN and PIX transaction
	Given I have excel data
	| QSC_IBScenario013 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application 
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details
	And user opens RF menu and completes "MM3 Rec-CASE-Ptwy" operation in Misc menu
	And user opens RF menu and "Increase" iLPN quantity using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Increase Qty" in iLPN
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 


@QSC_IB014 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 Inventory Adjustments- Decrease iLPN qty having no lock code
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| QSC_IBScenario014 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes "MM3 Rec-CASE-Ptwy" operation in Misc menu
	And user opens RF menu and "Decrease" iLPN quantity using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Decrease Qty" in iLPN
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 
	
	@QSC_IB015 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 Inventory Adjustments- Increase iLPN qty having unallocatable lock code
Creating ASN through Post Message UI and complete receiving and verify the ASN & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN and PIX transaction
	Given I have excel data
	| QSC_IBScenario015 |
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
	#And user verifies the ASN "40 - Receiving Verified"
	And user opens RF menu and "Increase" iLPN quantity using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Increase Qty" in iLPN
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 


@QSC_IB016 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 Inventory Adjustments- Decrease iLPN qty having unallocatable lock code
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| QSC_IBScenario016 |
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
	#And user verifies the ASN "40 - Receiving Verified"
	And user opens RF menu and "Decrease" iLPN quantity using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Decrease Qty" in iLPN
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 
	
	@QSC_IB017 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 Inventory Adjustments- Delete line from an iLPN having no lock code
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by deleting the line & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| QSC_IBScenario017 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes "MM3 Rec-CASE-Ptwy" operation in Misc menu
	And user opens RF menu and "Delete Line" from an iLPN using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Delete Line" in iLPN
	And validates the PIX Transactions "300" for modifying iLPN
	Then user log out from application 
	
@QSC_IB018 @Regression_QSC @QSC_InventoryAdjustments @QSC_Inbound
Scenario: B-427075 FXL-FFD-CIL-MH_I Inventory Adjustments- Delete line from an iLPN having unallocatable lock code after ASN verification
Creating ASN through Post Message UI and complete receiving bypasing through staging location & modify the 
iLPN by increasing the quantity & verify the iLPN, ASN & PIX transaction
	Given I have excel data
	| QSC_IBScenario018 |
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
	#And user verifies the ASN "40 - Receiving Verified"
	And user opens RF menu and "Delete Line" from an iLPN using "MM3 Modify iLPN" menu in Inventory
	Then user search for the LPN in iLPN screen, and validate the modification "Delete Line" in iLPN
	And user views ASN, and validate ASN details after deleting a line from iLPN
	And validates the PIX Transactions "606" for modifying iLPN
	Then user log out from application 
	
	@QSC_IB019 @Regression_QSC @QSC_ConsumeiLPN @QSC_Inbound
Scenario: B-474831 FXL-FFD-CIL-MH_Inventory Control-Base Transactions# 4- Consume iLPN having no lock
Creating ASN through Post Message UI and complete receiving bypasing through staging location & 
validating iLPN have no lock & consume the iLPN using RF Menu. Also validate PIX transaction
	Given I have excel data
	| QSC_IBScenario019 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user opens RF menu and completes "MM3 Rec-CASE-Ptwy" operation in Misc menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user opens RF menu and completes "MM3 Consume iLPN" operation in Misc menu
	Then user search for the LPN in iLPN screen, and validate the iLPN status
	And validates the PIX Transactions "300" for consuming iLPN
	Then user log out from application 
	
	@QSC_IB020 @Regression_QSC  @QSC_ConsumeiLPN @QSC_Inbound
Scenario: B-474831 FXL-FFD-CIL-MH_Inventory Control-Base Transactions# 4- Consume iLPN having lock code
Creating iLPN through MM3 Create iLPN menu & applythe lock code,validating iLPN have some lock code & consume 
the iLPN using RF Menu. Also validate PIX transaction.
Given I have excel data
	| QSC_IBScenario020 |
	And Open the chrome browser by selenium
	And user logs into the Manhattan application 
	And user opens RF menu and go to invenorty & perform "RF MM3 Create iLPN" operation
	And user open iLPN and applies the lock code
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user opens RF menu and completes "MM3 Consume iLPN" operation in Misc menu
	Then user search for the LPN in iLPN screen, and validate the iLPN status
	And validates the PIX Transactions "606" for consuming iLPN
	Then user log out from application
	
#	@QSC_IB021 @Regression_QSC @QSC_PutawayDamagedAndUndeliveredProducts
#Scenario: B- 466712 Putaway – Un-Delivered Products that was received in MM3 Rtrn/Ovrg
#Receiving of Un-Delivered Product using MM3 Rtrn/Ovrg menu and complete putaway to inspection area Validate the 
#iLPN moved to inspection area and “QC111A1” Locations Current Quantity will be incremented with no of LPN’s moved to location
#	Given I have excel data
#	| QSC_IBScenario021 |
#	And Open the chrome browser by selenium
#	And user logs into the Manhattan application 
#    When user create xml file using "Single Line Return ASN" with updated ASNNo & DeliveryStartDate for ReceivingASN
#    And user update xml itemDetails from excel sheet
#    And user opens post message screen and upload file in order to create ASN 
#	Then user verify the response 
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
#	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
#	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
#	Then validates that the iLPN is also moved to inspection zone "QC111A1"
#	Then user log out from application 
#	
#	
#	@QSC_IB022 @Regression_QSC @QSC_PutawayDamagedAndUndeliveredProducts @SanityTest_QSC
#Scenario: B- 466712 Putaway – Damaged Products that was received using MM3 Recv-Damages
#Receiving of Damaged Product in MM3 Recv-Damages menu and complete putaway to inspection area. Validate the iLPN moved 
#to inspection area and	“QC111A1” Locations Current Quantity will be incremented with no of LPN’s moved to location
#	Given I have excel data
#	| QSC_IBScenario022 |
#	And Open the chrome browser by selenium
#	When user update "Single Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-Damages" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
#	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
#	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
#	Then validates that the iLPN is also moved to inspection zone "QC111A1"
#	Then user log out from application 
#	
#	@QSC_IB023 @Regression_QSC @QSC_PutawayDamagedAndUndeliveredProducts
#Scenario: B- 466712 Putaway – Damaged Products that was received using blind receipt in MM3 Rtrn/Ovrg
#Receiving of Damaged Product using blind receipt in MM3 Rtrn/Ovrg menu and complete putaway to inspection area
#Validate the iLPN moved to inspection area and	“QC111A1” Locations Current Quantity will be incremented with no of LPN’s 
#moved to location
#	Given I have excel data
#	| QSC_IBScenario023 |
#	And Open the chrome browser by selenium
#	And user logs into the Manhattan application
#	And user opens RF menu and completes Receiving using "MM3 Rtrn/Ovrg" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	And user open reserve locations & naviagtes to "QC111A1" zone and fetches the current quantity
#	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
#	Then user navigates to reserve locations & validates that the quantity is increased in "QC111A1" by no of iLPN's moved
#	Then validates that the iLPN is also moved to inspection zone "QC111A1"
#	Then user log out from application 
	
	@QSC_IB024 @Regression_QSC  @QSC_AutoCloseASN @QSC_Inbound
Scenario: Auto Close ASN- Receving qty matches Shipped qty -single Line
Creating ASN through Post Message UI, complete receiving where Receving qty matches Shipped qty, Validating status and PIX messages
	Given I have excel data
	| QSC_IBScenario024 |
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
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And validates the PIX message "603 - Verify receipt"
	Then user log out from application
	
	@QSC_IB025 @Regression_QSC  @QSC_AutoCloseASN @QSC_Inbound
Scenario: Auto Close ASN- Receving qty matches Shipped qty - Multi Line
Creating ASN through Post Message UI, complete receiving of both lines where Receving qty matches Shipped qty, Validating status and PIX messages
	Given I have excel data
	| QSC_IBScenario025 |
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
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And validates the PIX message "603 - Verify receipt"
	Then user log out from application
	
#	@QSC_IB026 @Regression_QSC  @QSC_AutoCloseASN
#Scenario: Auto Close ASN- Receving qty matches Shipped qty - Multi Line, 1st line was over received & 2nd line received completely
#Creating ASN through Post Message UI, complete receiving where Receving qty matches Shipped qty & 1st line was over received & 2nd line received completely,
# Validating status and PIX messages
#	Given I have excel data
#	| QSC_IBScenario026 |
#	And Open the chrome browser by selenium
#	When user update "Multi Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	And validates the PIX message "606 - Un-allocable inventory adjustments"
#	And validates the PIX message "603 - Verify receipt"
#	Then user log out from application
	
	@QSC_IB027 @Regression_QSC  @QSC_AutoCloseASN @QSC_Inbound
Scenario: Auto Close ASN- Receving qty is less than Shipped qty -single Line
Creating ASN through Post Message UI, complete receiving where Receving qty is less than Shipped qty, Validating status and PIX messages
	Given I have excel data
	| QSC_IBScenario027 |
	And Open the chrome browser by selenium
	When user update "Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	Then user log out from application
	
#	@QSC_IB028 @Regression_QSC  @QSC_AutoCloseASN
#Scenario: Auto Close ASN- Receving qty is more than Shipped qty -single Line
#Creating ASN through Post Message UI, complete receiving where Receving qty is more than Shipped qty, Validating status and PIX messages
#	Given I have excel data
#	| QSC_IBScenario028 |
#	And Open the chrome browser by selenium
#	When user update "Single Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	And validates the PIX message "606 - Un-allocable inventory adjustments"
#	And validates the PIX message "603 - Verify receipt"
#	Then user log out from application
	

	@QSC_IB029 @Regression_QSC  @QSC_PartiallyVerified @QSC_Inbound
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
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	Then user log out from application
	
	@QSC_IB030 @Regression_QSC  @QSC_PartiallyVerified @QSC_Inbound
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
	Then user log out from application
	
	@QSC_IB031 @Regression_QSC  @QSC_PartiallyVerified @QSC_Inbound
Scenario: Receiving 1st line with all quantities and 2nd line with partial quantities of an ASN 
Creating ASN through Post Message UI, Complete receiving 1st line with all quantities and 2nd line with partial 
quantities of an ASN , Verify the ASN Manually & validate new multi line ASN is automatically created with 
remaining qty
	Given I have excel data
	| QSC_IBScenario031 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	Then user log out from application
	
	@QSC_IB032 @Regression_QSC  @QSC_PartiallyVerified @QSC_Inbound
Scenario: Receiving Partial Qty from both the lines of an ASN- Multi Line having same items 
Creating ASN through Post Message UI, Complete receiving Receiving Partial Qty from both the lines 
of an ASN- Multi Line having same items, Verify the ASN Manually & validate new multi line ASN is automatically 
created with remaining qty
	Given I have excel data
	| QSC_IBScenario032 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	Then user log out from application
	
#	@QSC_IB033 @Regression_QSC  @QSC_PartiallyVerified
#Scenario: Receiving 1st line with more than shipped quantities and 2nd line with partial quantities - Different item in both lines
#Creating ASN through Post Message UI, 1st line is Over Received and 2nd line with partial quantities of an 
#ASN- Multi Line with different items such that received units must be equals to Total shipped units, Verify 
#the ASN Manually & validate new ASN is automatically created with remaining qty from 2nd line
#	Given I have excel data
#	| QSC_IBScenario033 |
#	And Open the chrome browser by selenium
#	When user update "Multi Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
#	And validates the PIX message "606 - Un-allocable inventory adjustments"
#	And user verifies the ASN "40 - Receiving Verified"
#	And validates the PIX message "603 - Verify receipt"
#	Then user verifies new ASN is created with remaining qty
#	Then user log out from application
	
	@QSC_IB034 @Regression_QSC  @QSC_PartiallyVerified @QSC_Inbound
Scenario: Receiving 1st line with all quantities and 2nd line with partial quantities of an ASN- Multi Line with same items 
Creating ASN through Post Message UI, Receiving 1st line with all quantities and 2nd line with partial quantities of an ASN- Multi Line with same items , Verify 
the ASN Manually & validate new ASN is automatically created with remaining qty from 2nd line
	Given I have excel data
	| QSC_IBScenario034 |
	And Open the chrome browser by selenium
	When user update "Multi Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "30 - Receiving Started"
	And validates the PIX message "606 - Un-allocable inventory adjustments"
	And user verifies the ASN "40 - Receiving Verified"
	And validates the PIX message "603 - Verify receipt"
	Then user verifies new ASN is created with remaining qty
	Then user log out from application
	
#	@QSC_IB035 @Regression_QSC  @QSC_PartiallyVerified
#Scenario: Receiving 1st line with more than shipped quantities and 2nd line with partial quantities - Same Item in both lines
#Creating ASN through Post Message UI, 1st line is Over Received and 2nd line with partial quantities of an 
#ASN, Validate ASN is verified automatically
#	Given I have excel data
#	| QSC_IBScenario035 |
#	And Open the chrome browser by selenium
#	When user update "Multi Line PO" for dropping into fedexnet application
#	And user logs into the FedexNet application
#	And user upload "856" XML file in fedexnet
#	Then user log out from Fedenxet application
#	And user logs into the Manhattan application
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	And validates the PIX message "606 - Un-allocable inventory adjustments"
#	And validates the PIX message "603 - Verify receipt"
#	Then user log out from application
	
	
	@QSC_IB036 @Regression_QSC  @QSC_Putaway @QSC_Inbound
Scenario: Heavy Items Putaway
Receving ASN & completing Heavy Items Putaway
	Given I have excel data
	| QSC_IBScenario036 |
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
	And user open reserve locations and naviagtes to validate iLPN
	Then user log out from application
	
	@QSC_IB037 @Regression_QSC @QSC_Putaway @QSC_Inbound
Scenario: Receiving ASN & completing oversized Putaway
Creating ASN through Post Message UI, checking status of the shipment and completed receiving in Staging location & completing oversized Putaway
Given I have excel data
| QSC_IBScenario037 |
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
And user opens RF menu and completes Putaway using "MM3 Ptwy OverSized" menu
And user open reserve locations and naviagtes to validate iLPN
Then user log out from application
	
	
@QSC_IB038 @Regression_QSC  @QSC_Putaway @QSC_Inbound
Scenario: Normal Items Putaway
Receving ASN & completing Normal Items Putaway
	Given I have excel data
	| QSC_IBScenario038 |
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
	And user open reserve locations and naviagtes to validate iLPN
	Then user log out from application	
	
	
	@QSC_IB042 @Regression_QSC  @QSC_PackCasefromTransitional @QSC_Inbound
Scenario:  MM3 RF Pack Case from Transitional
Given I have excel data
	| QSC_IBScenario042 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	And user opens RF menu and perform "MM3 Pack From Trans" operation in inventory menu
	Then user search for the LPN in iLPN screen, and validate the iLPN statusOB as "10 - In inventory, Not putaway"
	Then user log out from application
	
	
	
