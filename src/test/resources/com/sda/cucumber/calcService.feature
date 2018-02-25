Feature: CalcService

  Scenario: Should Add Digits In String And Produce Result
    Given I initialize CalcService
    And I pass 2;3;4 value
    When I execute calculate method
    Then I get correct result


  Scenario: Should return 0 when null text is passed
    Given I initialize CalcService
    And I pass null
    When I execute calculate method
    Then I get 0 as a result


  Scenario: Should return 0 when blank text is passed
    Given I initialize CalcService
    And I pass blank
    When I execute calculate method
    Then I get 0 as a result

  Scenario: Should return correct value when mixed with letters text is passed
    Given I initialize CalcService
    And I pass 2a;3;4b value
    When I execute calculate method
    Then I get result for text with letters

  Scenario: Should return correct value when recipe list is passed
    Given I initialize CalcService
    And I pass 2 jablka;3 jajka;5 ziemniakow value
    When I execute calculate method
    Then I get result for recipe

  Scenario: Test
    Given I initialize CalcService
    And I pass 5 value
    When I execute calculate method
    Then I get result for recipe
