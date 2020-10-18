Feature: Outbound Scenarios



	
	
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
	
	