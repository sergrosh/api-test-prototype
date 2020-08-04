Feature: Check on campaign filters

  Scenario: Campaign search without filters
    Given no campaign filters
    When I search campaigns
    Then the returned campaign response should match the mock response


  Scenario: Campaign search with impression filter
    Given the following campaign filters:
      | name        | value | operator     |
      | impressions | 20000 | GREATER_THAN |
    When I search campaigns
    Then the returned campaigns should match the criterias
    And the returned campaign response should match the mock response

