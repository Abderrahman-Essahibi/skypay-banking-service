package skypay.SkypayBankingService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SkypayBankingServiceApplicationTests {

        @Test
        void depositTest() {
            Account account = new Account();
            account.deposit(1000);
            assertEquals(1000, account.getBalance());
        }

        @Test
        void withdrawDecreaseBalanceTest() {
            Account account = new Account();
            account.deposit(1000);
            account.withdraw(400);
            assertEquals(600, account.getBalance());
        }

        @Test
        void withdrawingTooMuchTest() {
            Account account = new Account();
            account.deposit(200);
            assertThrows(IllegalStateException.class, () -> account.withdraw(500));
        }

        @Test
        void depositingNegativeAmountTest() {
            Account account = new Account();
            assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        }
    }


