package skypay.SkypayBankingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkypayBankingServiceApplication {

    public static void main(String[] args) { SpringApplication.run(SkypayBankingServiceApplication.class, args);
        Account account = new Account();

        account.addTransaction("10-01-2012", 1000);
        account.addTransaction("13-01-2012", 2000);
        account.addTransaction("14-01-2012", -500);

        account.printStatement();
    }

}


