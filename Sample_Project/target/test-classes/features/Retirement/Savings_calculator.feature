Feature: How much savings Money retirement calculator form

  @Exampl123
  Scenario Outline: savings Money retirement calculator

    When Open the savings money retirement application URL
    Then Click on what is your current age field <Current_Age>
    Then Enter the At what age do you plan to retire field <Retire_Age>
    Then Enter the What is your current annual income field <Current_annual_income>
    Then Enter the What is your spouses annual income field <Spouse_annual_income>
    Then Enter the What is your current retirement savings balance field <Savings_balance>
    Then Enter the How much are you currently saving each year for retirement field <Retirement>
    Then Enter the What is the rate of increase in your savings each year field <Savings_each_year>
    Then Click on Yes toggle button Should we include Social Security benefits
    Then Enter the Social Security override amount <Security_override_amount>
    Then Click on calculate button
    Examples:
      | Current_Age | Retire_Age | Current_annual_income | Spouse_annual_income | Savings_balance | Retirement | Savings_each_year | Security_override_amount |
      |  40         |  68        | 10000                 | 5000                 | 2500            |10          |5                 |    4000                  |