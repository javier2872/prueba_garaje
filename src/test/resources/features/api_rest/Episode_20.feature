@ALL_TESTS
@E20 @API
Feature: Check features about episode 20 of Rick and Morty
  As a regular user
  I want to check features

  Scenario: features about episode 20
    Given a call "https://rickandmortyapi.com/api/episode/20"
    When send a request HTTP GET
    Then check datas of the response
    And appear 10 characters
    And field created follows ISO-8601