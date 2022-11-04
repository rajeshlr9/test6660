Feature: APC Test Scenarios 

@ScriptDevelopment_APC_VerifyAsnStatus
Scenario: Create and Upload X12 File for Single Line ASN Order Creation
Creating ASN through Post Message UI, Upload X12 Files for Single Line ASN Creation
	Given I have excel data
	| APC_IBScenario001 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC Single Line PO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	And user logs into the Manhattan application
	Then user opens ASN screen and searches for the ASN and verify its status "20 - InTransit" 
	
@ScriptDevelopment_APC
Scenario: Create and Upload X12 File for MultiLine ASN Order Creation
Creating ASN through Post Message UI, Upload X12 Files for Single Line ASN Creation
	Given Open the chrome browser by selenium
	Given user update EDI file "APC Multiline Serialized ASN" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "856" XML file in fedexnet
	Then user log out from Fedenxet application
	
@ScriptDevelopment_APC_VerifyDOStatus
Scenario: Create and Upload X12 File for SingleLine DO Order Creation
Creating ASN through Post Message UI, Upload X12 Files for Single Line ASN Creation
	Given I have excel data
	| APC_IBScenario001 |
	Given Open the chrome browser by selenium
	Given user update EDI file "APC Single Line DO" for dropping into fedexnet application
	And user logs into the FedexNet application
	And user upload "850" XML file in fedexnet
	Then user log out from Fedenxet application
	#And user logs into the Manhattan application
	#And user opens DO screen and searches for the DistributionOrder and verify its status "110 - Released" 

@ScriptDevelopment_APC_KelliUpload	
Scenario: Uploading the Single ASNLoad file from the Kelli application and validating order created in Manhattan Successfully
 	Given I have excel data
	| APC_KelliScenario001 |
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
	