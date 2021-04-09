Feature: Kelliupload scenario

    @KELLI001 @Regression @QSC_KelliASNLoad
Scenario: Uploading the ASNLoad file from the Kelli application and validating
 the file uploaded successfully
	Given Open the IE by selenium
	And user logs into the kelli application 
	And user updates data in ASN Upload Sheet
	When user upload the ASN Load file 
	Then user view the logs and validates the success message for ASN Load
	Then user logout from the kelli application

	@KELLI002 @Regression @QSC_KelliItemLoad
	  Scenario: Uploading the ItemLoad file from the Kelli application and validating
 the file uploaded successfully
	  Given Open the IE by selenium
	  And user logs into the kelli application
	  And user updates data in Item Upload Sheet
	  When user upload the Item Load file 
	  Then user view the logs and validates the success message for Item Load
	  Then user logout from the kelli application
	  
	  @KELLI003 @Regression @QSC_KelliLocationLoad
	  Scenario: Uploading the Item Load file from the Kelli application and validating
 the file uploaded successfully
	  Given Open the IE by selenium
	  And user logs into the kelli application
	  And user updates data in Item Upload Sheet
	  When user upload the Item Load file 
	  Then user view the logs and validates the success message for Location Load
	  Then user logout from the kelli application
	  
	  @KELLI004 @Regression @QSC_KelliOrderLoad
	  Scenario: Uploading the Order Load file from the Kelli application and validating
 the file uploaded successfully
	  Given Open the IE by selenium
	  And user logs into the kelli application
	  And user updates data in Item Upload Sheet
	  When user upload the Item Load file 
	  Then user view the logs and validates the success message for Order Load
	  Then user logout from the kelli application