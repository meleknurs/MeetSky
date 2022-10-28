Feature: Contacts Module Functionality
  Agile story: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module


  Background:
    Given the user is on the login page
    And the user enters the contacts menu


  Scenario: Creating new contact verification
    When  user click new contact button
    And user enter first and last name in the new contact box
    Then user should able to see new contact in the All contacts column
  @wip
  Scenario: Creating new contact without input verification
    When  user click new contact button
    And user click enter without typing any input
    And user refresh the page
    Then user should see that empty contact names disappeared

  Scenario: Seeing all the contacts and total number of contacts verification
    When user click All contacts button
    Then user should able to see the contact list in the middle column
    Then user should able to see total number near the All contacts button

  Scenario: Changing profile picture of contact verification
    When user click picture icon under the contact name
    And user select choose from Files option
    And user select an image
    And user click Choose button
    Then user should be able to see chosen picture as a profile picture

  Scenario: Deleting contact verification
    When user click three dots of any contact
    And user select delete option
    Then user should able to see chosen contact is deleted
