Feature: Four Customer scenarios

@THH001 @THH_KelliASNLoad @DailyRegression_THH
Scenario: Uploading the Single ASNLoad file for THH using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| THH_KelliScenario002 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	#And user opens RF menu and completes Receiving using "MM3 Recv-CASE" menu
	#Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified" 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 
	
@TRN001 @TRN_KelliASNLoad @DailyRegression_TRN
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| TRN_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Multi Line ASN" Kelli Upload Sheet
	And user upload the "Multi Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 	
	
@ILW001 @ILW_KelliASNLoad @DailyRegression_ILW
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| ILW_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application 
	
@THM001 @THM_KelliASNLoad @DailyRegression_THM
Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
 	Given I have excel data
	| THM_KelliScenario001 |
	And Open the chrome browser by selenium
	And user logs into the kelli application 
	When user updates data in "Single Line ASN" Kelli Upload Sheet
	And user upload the "Single Line ASN" Load file in Kelli
	Then user logout from the kelli application
	And user logs into the Manhattan application
	And fetches the actual ASN number and PO Number uploaded from Kelli
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
	And user views ASN, get and verify item details 
	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
	And user opens Items screen and find putaway type 
	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
	Then user search for the LPN in iLPN screen, and validate the lock code
	And user open reserve locations and naviagtes to validate iLPN 
	Then user log out from application
	
#@FUJ001 @FUJ_KelliASNLoad @DailyRegression_FUJ
#Scenario: Uploading the Single ASNLoad file for FUJ Using Kelli and validating order created in Manhattan Successfully
# 	Given I have excel data
#	| FUJ_KelliScenario001 |
#	And Open the chrome browser by selenium
#	And user logs into the kelli application 
#	When user updates data in "Single Line ASN" Kelli Upload Sheet
#	And user upload the "Single Line ASN" Load file in Kelli
#	#Then user view the logs and validates the success message for ASN Load
#	Then user logout from the kelli application
#	And user logs into the Manhattan application
#	And fetches the actual ASN number and PO Number uploaded from Kelli
#	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit"
#	And user views ASN, get and verify item details 
#	And user opens RF menu and completes Receiving using "MM1 Recv-iLPN" menu
#	Then user opens ASN screen and searches for the ASN and verify its status "40 - Receiving Verified"
#	And user opens Items screen and find putaway type 
#	And user opens RF menu and completes Putaway using "MM1 Ptwy iLPN" menu
#	Then user search for the LPN in iLPN screen, and validate the lock code
#	Then user log out from application 