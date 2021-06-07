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
	
@NVI_IN003 @Regression_NVI @NVI_InquiryProcess 
Scenario: MM3 iLPN Inquiry : 10 - In inventory, Not putaway 
	Given I have excel data 
		|NVI_INScenario003|
	And Open the chrome browser by selenium 
	When user logs into the Manhattan application 
	Then user opens RF menu and go to Inquiry & validate "MM3 iLPN Inquiry" is displaying data 
	Then user log out from application 
	
@NVI_IN004 @Regression_NVI @NVI_InquiryProcess 
Scenario: MM3 iLPN Inquiry : 30-putaway 
	Given I have excel data 
		| NVI_INScenario004 |
	And Open the chrome browser by selenium 
	When user logs into the Manhattan application 
	Then user opens RF menu and go to Inquiry & validate "MM3 iLPN Inquiry" is displaying data 
	Then user log out from application 
	
@NVI_IN005 @Regression_NVI @NVI_InquiryProcess 
Scenario: MM3 iLPN Inquiry- iLPN is part of a Pallet 
	Given I have excel data 
		| NVI_INScenario005 |
	And Open the chrome browser by selenium 
	When user logs into the Manhattan application 
	Then user opens RF menu and go to Inquiry & validate "MM3 iLPN Inquiry" is displaying data 
	Then user log out from application 
	
@NVI_IN006 @Regression_NVI @NVI_InquiryProcess 
Scenario: MM3 Item Inquiry 
	Given I have excel data 
		| NVI_INScenario006 |
	And Open the chrome browser by selenium 
	When user logs into the Manhattan application 
	Then user opens RF menu and go to Inquiry & validate "MM3 Item Inquiry" is displaying data 
	Then user log out from application