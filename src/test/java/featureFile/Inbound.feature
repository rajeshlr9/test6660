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
	
	