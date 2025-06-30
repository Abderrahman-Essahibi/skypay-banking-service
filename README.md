## Skypay Banking Service – Technical Test

This project is a response to the Skypay technical test, which consists of implementing a simple banking system in Java. It supports:

*  Depositing money
*  Withdrawing money
*  Printing a bank statement

The goal was to follow strict interface constraints, apply clean code practices, and test the logic thoroughly without using any databases or repositories.


##  Tech Stack

* **Java 17**
* **Maven**
* **JUnit 4**
* (Optional) **Spring Boot** used only for project structure

## Project Structure

```
src
├── main
│   ├── java
│   │   └── skypay
│   │       └── SkaypayBankingService
│   │           ├── AccountService.java     
│   │           ├── Account.java           
│   │           └── Main.java            
├── test
│   └── java
│       └── skypay
│           └── skypayh_technical_test
│               └── AccountTest.java        # Junit test 
```

---

## How to Run

### Run Unit Tests

```bash
mvn test
```

### Run the App (CLI demo)

If you included a `Main.java` for CLI input:

```bash
mvn compile exec:java -Dexec.mainClass="skypay.SkypayBankingService.Main"
```

> Or just run `Main` directly from IntelliJ.

---

##  Features & Rules Followed

* Implements exact interface provided: `AccountService`
* No external storage (in-memory using `ArrayList`)
* Handles input validation (e.g. negative deposit or overdraft)
* Clear printed bank statements
* Fully tested with JUnit 5


## Example Statement Output


DATE       | AMOUNT | BALANCE
14-01-2012 |   -500 |    2500
13-01-2012 |   2000 |    3000
10-01-2012 |   1000 |    1000


## By : 
ES-SAHIBI Abderrahman 

