Feature: Keep tracks of the transactions that was on an account
  As a client
  I want to keep tracks of the transactions made on my account with their types and the date it happened.

  Scenario: A client executes operations onto his account
    Given A client creates his bank account
    When He deposits "5" into his bank account
    And He deposits "10" into his bank account
    And He withdraws "2" from his bank account
    And He withdraws "10" from his bank account
    Then His report displays
"""
Your current balance is: 3.00
DEPOSIT   |5.00      |02/02/2019 14:05:30|
DEPOSIT   |10.00     |02/02/2019 14:05:30|
WITHDRAW  |-2.00     |02/02/2019 14:05:30|
WITHDRAW  |-10.00    |02/02/2019 14:05:30|

"""

