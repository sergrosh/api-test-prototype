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

  Scenario: SPKeyword search with spend filter
    Given the following spkeyword filters:
      | name  | value | operator |
      | spend | 69.71 | EQUAL    |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response

  Scenario: SPKeyword search with acos filter
    Given the following spkeyword filters:
      | name | value | operator     |
      | acos | 71.67 | GREATER_THAN |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response

  Scenario: SPKeyword search with campaignId filter
    Given the following spkeyword filters:
      | name       | value           | operator |
      | campaignId | 111111120000264 | EQUAL    |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response

  Scenario: SPKeyword search with 4 filters impressions, spend, acos and campaignId filter
    Given the following spkeyword filters:
      | name        | value           | operator     |
      | impressions | 9000            | GREATER_THAN |
      | spend       | 69.71           | EQUAL        |
      | acos        | 71.67           | GREATER_THAN |
      | campaignId  | 111111120000264 | EQUAL        |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response

  Scenario: SPKeyword search with 5 filters impressions, spend, acos, average spc and campaignId filter
    Given the following spkeyword filters:
      | name        | value           | operator     |
      | impressions | 9000            | GREATER_THAN |
      | spend       | 69.71           | EQUAL        |
      | acos        | 71.67           | GREATER_THAN |
      | campaignId  | 111111120000264 | EQUAL        |
      | averageCpc  | 0.98            | EQUAL        |
    When I search spkeywords
    Then the returned spkeywords should match the criterias
    And the returned spkeyword response should match the mock response
