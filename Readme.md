# Bank Kata

Kata to implement a (very) simple bank account solution.

Comes with the mvn wrapper. But you do need a JDK 8 in order to compile the project.
## User stories
US Implemented:
* US 1: As a client, I want to be able to deposit money into my bank account.
* US 2: As a client, I want to be able to withdraw money from my bank account.
* US 3: As a client, I want to keep tracks of the transactions made on my account 
with their types and the date it happened.

Possible improvements :
* Add a formatter package that can format date & amount to improve the StringReporter
* Add a Client
* Add another Reporter (Web for instance)
* ...

## Test
```
./mvnw clean test
```

## Check out the demo
```
./mvnw clean install
./mvnw exec:java -Dexec.mainClass="com.zenikata.bank.demo.DemoBankAccount"
```