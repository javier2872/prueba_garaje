@ALL_TESTS
@MORTY @API
Feature: Check Morty is into episode 20 of Rick and Morty
  As a regular user
  I want to check features

  Scenario: verify. if is Morty
    Given a call "https://rickandmortyapi.com/api/episode/20"
    When send a request HTTP GET
    Then check datas of the response
    And say hi to morty