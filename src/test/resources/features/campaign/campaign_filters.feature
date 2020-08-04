Feature: Check on SPKeyword filters

  Scenario: SPKeyword search without filters
    Given no spkeyword filters
    When I search spkeywords
    Then the returned spkeyword response should match the mock response


  Scenario: SPKeyword search with impression filter
    Given the following spkeyword filters:
      | name        | value | operator     |
      | impressions | 20000 | GREATER_THAN |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response

