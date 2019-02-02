Feature: Deposit money into client account
    As a client
    I want to be able to deposit money into my bank account

    Scenario: A client deposits money into his empty bank account
        Given A client creates his bank account
        When He deposits "10" into his bank account
        Then His new balance is "10"

