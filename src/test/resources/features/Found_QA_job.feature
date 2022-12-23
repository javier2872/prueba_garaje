@ALL_TESTS
@FOUND_JOB
Feature: Look for a job offer
  As a regular user
  I want to look for a job offer

  Scenario: look for a QA offer
    Given a guest user in "https://garajedeideas.com/"
    When user goes to the Talent page
    And user goes to Join Our Team section
    Then there is only one job offer for a QA Engineer
