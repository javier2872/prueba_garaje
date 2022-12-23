@ALL_TESTS
@FOUND_CEO @WEB
Feature: Look for the CEO Alberto Barrio
  As a regular user
  I want to look for Alberto Barrio

  Scenario: look for a QA offer
    Given a guest user in "https://garajedeideas.com/"
    When user goes to the Talent page
    And user goes to Team section
    Then the first member is Alberto Barrio, our beloved CEO
