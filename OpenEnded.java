
package openended;
import java.util.*;

public class OpenEnded {

   
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        User user1 = new User("14101-221-1234-12", "Abdullah Ali", "House 3, St 18, Gulshan Iqbal, Karachi");
        User user2 = new User("12832-123-2112-21", "Hafsa Malik", "House 23, St 1, Ayesha Manzil, Karachi");
        User user3 = new User("28411-236-5434-23", "Aina Raziq", "House 45, St 6, Blue Area, Islamabad");

        BankAccount acc1 = new BankAccount(user1, "1234-5678-9101-1213", 1234, 20000);
        BankAccount acc2 = new BankAccount(user2, "0987-6543-2109-8765", 1587, 1100);
        BankAccount acc3 = new BankAccount(user3, "2819-3728-2781-4567", 4567, 45000);

        Bank bank1 = new Bank(123456, "Allied Bank, Margalla Town, Islamabad");
        bank1.setAccount(acc1);
        bank1.setAccount(acc2);
        Bank bank2 = new Bank(789012, "Bank Alfalah, F8 - Markaz, Islamabad");
        bank2.setAccount(acc3);

        AtmMachine atm = new AtmMachine();
        atm.setBanks(bank1);
        atm.setBanks(bank2);

        atm.promptMenu();
        
    }

}
