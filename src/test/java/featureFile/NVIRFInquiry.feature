Feature: MM3 Inquiry feature

@NVI_IN001 @Regression_NVI @NVI_InquiryProcess
Scenario: MM3 ASN Inquiry : 30 - Receiving Started
	Given I have excel data
	| NVI_INScenario001 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 ASN Inquiry" is displaying data
	Then user log out from application
	
@NVI_IN002 @Regression_NVI @NVI_InquiryProcess
Scenario: MM3 ASN Inquiry : 40 - Receiving Verified
	Given I have excel data
	| NVI_INScenario002 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 ASN Inquiry" is displaying data
	Then user log out from application
	
