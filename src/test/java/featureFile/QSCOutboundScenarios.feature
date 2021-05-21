Feature: QSC Outbound Scenarios 

@QSC_OB000 @Regression_QSC @QSC_PostMessage 
Scenario: Distribution Order Shipping - Single Line 
	Given I have excel data 
		| QSC_OBScenario001 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application 
	
@QSC_OB001 @Regression_QSC @QSC_Shipping 
Scenario: Distribution Order Shipping - Single Line 
	Given I have excel data 
		| QSC_OBScenario001 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then user search for DO and confirms it 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	Then user log out from application 
	
	
@QSC_OB002 @Regression_QSC @QSC_Shipping 
Scenario: Distribution Order Shipping - Multi Line 
	Given I have excel data 
		| QSC_OBScenario002 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then user search for DO and confirms it 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	Then user log out from application 
	
@QSC_OB003 @Regression_QSC @QSC_Shipping 
Scenario: Distribution Order Shipping - Single Line Shortage 
	Given I have excel data 
		| QSC_OBScenario003 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify order got deselected from wave 
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application 
	
	
@QSC_OB004 @Regression_QSC @QSC_AdjustoLPN 
Scenario: Modify\Adjust Olpn from Manhattan UI -Single Line, OLPN in Printed status and Order at DC Allocated status 
	Given I have excel data 
		| QSC_OBScenario004 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	Then user views and Adjust the oLPN 
	Then user log out from application 
	
	
@QSC_OB005 @Regression_QSC @QSC_AdjustoLPN 
Scenario: Modify\Adjust Olpn from Manhattan UI Single Line,OLPN in Weighed status and Order at Weighed status-New Quantity  lesser than Current Quantity 
	Given I have excel data 
		| QSC_OBScenario005 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then user views and Adjust the oLPN 
	Then user log out from application 
	
@QSC_OB006 @Regression_QSC @QSC_AdjustoLPN 
Scenario: Modify\Adjust Olpn from Manhattan UI Single Line,OLPN in Weighed status and Order at Weighed status-New Quantity  more than Current Quantity 
	Given I have excel data 
		| QSC_OBScenario006 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then user views and Adjust the oLPN 
	Then user log out from application 
	
@QSC_OB007 @Regression_QSC @QSC_AdjustoLPN 
Scenario: Distribution Order Shipping - Multi Line,One Line at Printed status and second line as Weighed,
correspondingly the order is at In Packing,New Quantity  more than Current Quantity 
	Given I have excel data 
		| QSC_OBScenario007 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete a single task created 
	Then user open Task screen & validate the status of single task 
	And user opens DO screen and searches for the DistributionOrder and verify its status "140 - In Packing" 
	Then user views and Adjust the oLPN 
	Then user log out from application 
	
@QSC_OB008 @Regression_QSC @QSC_AdjustoLPN 
Scenario: Distribution Order Shipping - Multi Line,One Line at Printed status and second line as Weighed,correspondingly
the order is at In Packing,New Quantity lesser than Current Quantity 
	Given I have excel data 
		| QSC_OBScenario008 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete a single task created 
	Then user open Task screen & validate the status of single task 
	And user opens DO screen and searches for the DistributionOrder and verify its status "140 - In Packing" 
	Then user views and Adjust the oLPN 
	Then user log out from application 
	
	
	###########################Jaya#################
	
@QSC_OB009 @Regression_QSC @QSC_SplitCombineoLPN
Scenario: Spliting the OLPN at Printed status 
	Given I have excel data 
		| QSC_OBScenario009 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	Then fetch the OLPN number
	Then user opens RF menu and perform "MM3 split OLPN" operation in inventory menu	
	Then user opens the OLPN screen and verify the splitted oLPNS status
	Then user log out from application
	
@QSC_OB010 @Regression_QSC @QSC_SplitCombineoLPN
Scenario: Spliting the OLPN at Weighed status 
	Given I have excel data 
		| QSC_OBScenario010 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number
	Then user opens RF menu and perform "MM3 split OLPN" operation in inventory menu	
	Then user opens the OLPN screen and verify the splitted oLPNS status
	Then user log out from application
	
@QSC_OB011 @Regression_QSC @QSC_SplitCombineoLPN 
Scenario: Combine the OLPN at printed status 
	Given I have excel data 
		| QSC_OBScenario011 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	Then fetch the OLPN number
	Then user opens RF menu and perform "MM3 cmbne OLPN" operation in inventory menu	
	Then user opens the OLPN screen and verify the combined oLPNS status
	Then user log out from application	
	
@QSC_OB012 @Regression_QSC @QSC_SplitCombineoLPN
Scenario: Combine the OLPN at weighed status 
	Given I have excel data 
		| QSC_OBScenario012 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number
	Then user opens RF menu and perform "MM3 cmbne OLPN" operation in inventory menu	
	Then user opens the OLPN screen and verify the combined oLPNS status
	Then user log out from application	
	
	###########################Jaya#################
	
@QSC_OB013 @Regression_QSC @QSC_CanceloLPN 
Scenario: Cancel OLPN - Cancel the OLPN at Printed status (SingleLine Sceanrios) 
	Given I have excel data 
		| QSC_OBScenario013 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	Then fetch the OLPN number 
	Then user opens RF menu and perform "MM3 Cancel oLPN" operation in inventory menu 
	And user opens the oLPN details in Distribuion Order page and and verify its status "99 - Cancelled" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled" 
	And validates the PIX message "620 - Order transactions"
	Then user log out from application 
	
	
@QSC_OB014 @Regression_QSC @QSC_CanceloLPN 
Scenario: Cancel OLPN - Cancel the OLPN at Weighed status (SingleLine Sceanrios) 
	Given I have excel data 
		| QSC_OBScenario014 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
	Then fetch the OLPN number 
	Then user opens RF menu and perform "MM3 Cancel oLPN" operation in inventory menu 
	And user opens the oLPN details in Distribuion Order page and and verify its status "99 - Cancelled" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "200 - Cancelled" 
	And validates the PIX message "620 - Order transactions"
	Then user log out from application 
	
@QSC_OB015 @Regression_QSC @QSC_CanceloLPN 
Scenario: Cancel OLPN - Cancel the OLPN at Shipped status (SingleLine Sceanrios) 
	Given I have excel data 
		| QSC_OBScenario015 |
	And Open the chrome browser by selenium 
	When user update "Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released"
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	Then user views wave and verify the allocation of inventory 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated"
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete the tasks created 
	Then user open Task screen & validates the status of tasks 
	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed"
	Then user search for DO and confirms it 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	Then fetch the OLPN number 
	Then user opens RF menu and perform "MM3 Cancel oLPN" operation in inventory menu 
	And user opens the oLPN details in Distribuion Order page and and verify its status "90 - Shipped" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
	And validates the PIX message "620 - Order transactions"
	Then user log out from application 
	
@QSC_OB016 @Regression_QSC @QSC_CanceloLPN 
Scenario: Cancel OLPN - Cancel the OLPN at Printed status (MultiLine Sceanrios) 
	Given I have excel data 
		| QSC_OBScenario016 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	Then fetch the OLPN number 
	Then user opens RF menu and perform "MM3 Cancel oLPN" operation in inventory menu 
	And user verifies the oLPN details in Distribuion Order page  
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And validates the PIX message "620 - Order transactions"
	Then user log out from application 
	
@QSC_OB017 @Regression_QSC @QSC_CanceloLPN 
Scenario: Cancel OLPN - Cancel the OLPN at Weighed status (MultiLine Sceanrios) 
	Given I have excel data 
		| QSC_OBScenario017 |
	And Open the chrome browser by selenium 
	When user update "Multi Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet 
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user verifies the item details in Distribuion Order page 
	And user runs the "Standard wave" 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And user open Task screen & verifies task is created for DO in the wave process 
	And user open RF Menu and complete a single task created 
	Then user open Task screen & validate the status of single task
	And user opens DO screen and searches for the DistributionOrder and verify its status "140 - In Packing" 
	Then fetch the OLPN number 
	Then user opens RF menu and perform "MM3 Cancel oLPN" operation in inventory menu 
	And user verifies the oLPN details in Distribuion Order page 
	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
	And validates the PIX message "620 - Order transactions"
	Then user log out from application 
	
