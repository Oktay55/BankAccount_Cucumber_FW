Feature: Bank Account (Add, Edit, Delete) Functionality Test

  Background: Login to  Website
    Given User is on login page
    When User enter admin credentials
    Then User should login successfully
    And User click Setup on Navigation Bar
    And User click on Parameters under Setup
    And User click on the Bank Account


  Scenario: Add Bank Account
    And User click on plus sign to add "ToffeeBank", "TP45 76", "USD" and "11" and click save button
    Then Success create message should be displayed



  Scenario: Add same data Bank Account
    And User click on plus sign to add same data "ToffeeBank", "TP45 76", "USD" and "11" and click save button
    Then Unsuccessful message should display



  Scenario: Edit Bank Account
    And User search for "ToffeeBank" and click search
    And User edit current Bank name and change it to "PeanutBank"
    Then Success edit message should be displayed



  Scenario: Delete Bank Account
    And User search for "PeanutBank"
    And User delete Bank Account
    Then Success delete message should be displayed



  Scenario: Accessing deleted Bank Account
    And User search deleted data "PeanutBank"
    Then User should see no data to display message

