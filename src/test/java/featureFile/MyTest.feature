Feature: Execute Selenium Scripts from LeanFT Tool
  I want to use this template for my feature file

  @tag1
  Scenario: Print Hello using Selenium
    Given Open the Chrome by selenium
    When abc
    Then Close browser opened by selenium

  @tag2
  Scenario: Print Hello using LeanFT
    Given Open the Chrome by leanft
    When abc
  # Then Close_browser_opened_by_Leanft
  
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
    And Login to OMS using Selenium
      | Username | Password |
      |   867949 | Manage16 |
    And Search for the dropped order using Selenium
    And Resume the incomplete order using Selenium
    Then Order is placed successfully

  @tag5
  Scenario: Complete adhoc move in Putty using Leanft
    Given Open Putty
    When user login to Putty
      | Username | Password    | NodeId    | NodePassword |
      | yanqarf1 | QA36playgnd | Mphasis04 | Mphas004     |
    And Complete adhoc move
      | Start_Location | ItemID   | Quantity | SuggestedLoc |
      | STG001R        | 7181E-01 |        1 | BB2314C3     |
    Then Items are moved successfully
