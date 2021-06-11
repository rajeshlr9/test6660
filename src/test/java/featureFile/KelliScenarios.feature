Feature: Kelliupload scenario

    @Kelli001 @Regression_QSC @QSC_KelliASNLoad
Scenario: Uploading the Single ASNLoad file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| QSC_KelliScenario001 |
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
	
	@Kelli002 @Regression_QSC @QSC_KelliASNLoad
Scenario: Uploading the Multi ASNLoad file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| QSC_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Multi Line ASN" Kelli Upload Sheet
	And user upload the "Multi Line ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	Then user log out from application 
	
	@Kelli003 @Regression_QSC @QSC_KelliASNLoad
Scenario: Uploading the Single ASNLoad file from the Kelli application and complete receiving & putaway for the order created
 	Given I have excel data
	| QSC_KelliScenario003 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 
	
	@Kelli004 @Regression_QSC @QSC_KelliASNLoad
Scenario: Uploading the Multi ASNLoad file from the Kelli application and complete receiving & Putaway for the order created
 	Given I have excel data
	| QSC_KelliScenario004 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Multi Line ASN" Kelli Upload Sheet
	And user upload the "Multi Line ASN" Load file in Kelli
	#Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Putaway using "MM3 Ptwy CASE" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	Then user log out from application 

	  @Kelli005 @Regression_QSC @QSC_KelliOrderLoad
	  Scenario: Uploading the Single Line Order Load file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| QSC_KelliScenario005 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	And updates "Single Line Order" Load file
	And user upload the "Single Line Order" Load file in Kelli
	#And user gets the logs and validates success message
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
	Then user log out from application 
	
	@Kelli006 @Regression_QSC @QSC_KelliOrderLoad
	  Scenario: Uploading the Multi Line Order Load file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| QSC_KelliScenario006 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	And updates "Multi Line Order" Load file
#	And user upload the "Multi Line Order" Load file in Kelli
#	#And user gets the logs and validates success message
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
#	Then user log out from application 
#	
#	@Kelli007 @Regression_QSC @QSC_KelliOrderLoad
#	  Scenario: Uploading the Single Line Order Load file from the Kelli application and validating order created in Manhattan Successfully & complete Shipping
# 	Given I have excel data
#	| QSC_KelliScenario007 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	And updates "Single Line Order" Load file
#	And user upload the "Single Line Order" Load file in Kelli
#	#And user gets the logs and validates success message
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
#	Then user verifies the item details in Distribuion Order page 
#	And user runs the "Standard wave" 
#	Then user views wave and verify the allocation of inventory 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
#	And user open Task screen & verifies task is created for DO in the wave process 
#	And user open RF Menu and complete the tasks created 
#	Then user open Task screen & validates the status of tasks 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
#	Then user search for DO and confirms it 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
#	Then user log out from application 
#	
#	@Kelli008 @Regression_QSC @QSC_KelliOrderLoad
#	  Scenario: Uploading the Multi Line Order Load file from the Kelli application and validating order created in Manhattan Successfully & complete Shipping
# 	Given I have excel data
#	| QSC_KelliScenario008 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	And updates "Multi Line Order" Load file
#	And user upload the "Multi Line Order" Load file in Kelli
#	#And user gets the logs and validates success message
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 
#	Then user verifies the item details in Distribuion Order page 
#	And user runs the "Standard wave" 
#	Then user views wave and verify the allocation of inventory 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "130 - DC Allocated" 
#	And user open Task screen & verifies task is created for DO in the wave process 
#	And user open RF Menu and complete the tasks created 
#	Then user open Task screen & validates the status of tasks 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "160 - Weighed" 
#	Then user search for DO and confirms it 
#	And user opens DO screen and searches for the DistributionOrder and verify its status "190 - Shipped" 
#	Then user log out from application 
	  
	  @Kelli009 @Regression_QSC @QSC_KelliItemLoad
	  Scenario: Uploading the Item Load file from the Kelli application and validating Item uploaded successfully in Manhattan
	  Given I have excel data
		| QSC_KelliScenario009 |
		And Open the chrome browser by selenium
		And user logs into the kelli application 
	  When user updates data in Item Upload Sheet
	  And user upload the "Item" Load file in Kelli
	 # Then user view the logs and validates the success message
	  Then user logout from the kelli application
	  And user logs into the Manhattan application
	  Then user opens Items screen and validate Item creation
	  
	  @Kelli010 @Regression_QSC @QSC_KelliLocationLoad
	  Scenario: Uploading the Location Load file from the Kelli application and validating Item uploaded successfully in Manhattan
	 Given I have excel data
		| QSC_KelliScenario009 |
		And Open the chrome browser by selenium
		And user logs into the kelli application 
	 And Updates the excel for Location Load
	 And user upload the "Location" Load file in Kelli
	 # Then user view the logs and validates the success message
	  Then user logout from the kelli application
	  And user logs into the Manhattan application
	  Then user opens Items screen and validate Item creation
	  