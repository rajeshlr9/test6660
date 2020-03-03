Feature: Execute Selenium Scripts from LeanFT Tool
	
  @tag3
  Scenario: Open Browser by selenium and complete login using LeanFT (Work on same application)
    Given Open the IE by selenium
    Then Attach LeanFT IE browser to seleniumTest
    Then Login to OMS by LeanFT
    Then Close browser opened by LeanFT

  @tag4
  Scenario: Create Order via Filezilla using Leanft and Resume order in O2S via Selenium(Work on 2 application)
    Given Open Filezilla
    When user connects to EMC customer and drop an OB order
    When User open Browser
    And Login to OMS using Selenium
    And Search for the dropped order using Selenium
    And Resume the incomplete order using Selenium
    Then Order is placed successfully

    
   @tag5
  Scenario: Complete adhoc move in Putty using Leanft
    Given Open Putty
    When user login to Putty
    And Complete adhoc move
      | Start_Location | ItemType | ItemID   | Quantity | SuggestedLoc |
      | STG001R        | Normal   | 	7181E-01 |        1 |              |

    Then Items are moved successfully
    
    @tag7
    Scenario: Create an Order in O2S using Selenium by taking data from Excel
    Given I have excel data
    |	Scenario7	|
    When User open Browser
    And Login to OMS using Selenium
    And Add destination Details
    And Add Inventory Details
    And Enter Route Details
    And Enter Placement Details
	  Then Order is placed successfully
