Feature: Withdraw money into client account
    As a client
    I want to be able to withdraw money from my bank account

    Scenario: A client withdraws money into his bank account
        Given A client with "10" into his bank account
        When He withdraws "5" from his bank account
        Then His new balance after the withdraw is "5"

