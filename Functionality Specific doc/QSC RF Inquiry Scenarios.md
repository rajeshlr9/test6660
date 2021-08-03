Feature: MM3 Inquiry feature

@QSC_IN001 @Regression_QSC @QSC_InquiryProcess
Scenario: MM3 ASN Inquiry
	Given I have excel data
	| QSC_INScenario001 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 ASN Inquiry" is displaying data
	Then user log out from application
	
@QSC_IN002 @Regression_QSC @QSC_InquiryProcess
Scenario: MM3 Item Inquiry
	Given I have excel data
	| QSC_INScenario002 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 Item Inquiry" is displaying data
	Then user log out from application
	
@QSC_IN003 @Regression_QSC @QSC_InquiryProcess
Scenario: MM3 Location Inquiry
	Given I have excel data
	| QSC_INScenario003 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 Location Inquiry" is displaying data
	Then user log out from application
	
@QSC_IN004 @Regression_QSC @QSC_InquiryProcess
Scenario: MM3 iLPN Inquiry
	Given I have excel data
	| QSC_INScenario004 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 iLPN Inquiry" is displaying data
	Then user log out from application
	
@QSC_IN005 @Regression_QSC @QSC_InquiryProcess
Scenario: MM3 oLPN Inquiry
	Given I have excel data
	| QSC_INScenario005 |
	And Open the chrome browser by selenium
	When user logs into the Manhattan application
	Then user opens RF menu and go to Inquiry & validate "MM3 oLPN Inquiry" is displaying data
	Then user log out from application
	