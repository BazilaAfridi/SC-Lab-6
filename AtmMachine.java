
package openended;

import java.util.*;
public class AtmMachine {
    private List < Bank > banks;
    private BankAccount verifiedAccount;
    private AtmTransaction transactionObj;
    Scanner myObj = new Scanner(System.in);

    public AtmMachine() {
        banks = new ArrayList < Bank > ();
        transactionObj = new AtmTransaction(this);
    }
    public void setBanks(Bank bank) {
        banks.add(bank);
    }
    public List < Bank > getBanks() {
        return banks;
    }
    public Bank verifyCredentials(String accNum, int pin) {
        Bank userBank = null;
        List<BankAccount> accountsList;
        for (Bank bank: banks) {
            accountsList = bank.getAccountsList();
            for (BankAccount account: accountsList) { 
                if (account.getAccNum().equals(accNum) && account.getPin() == pin) {
                    verifiedAccount = account;
                    userBank = bank;
                }
            }
        }
        return userBank;
    }
    public BankAccount getVerifiedAccount() {
        return verifiedAccount;
    }
    public void promptMenu(){
        int choice,option;
        Bank userBank;
         do {
            System.out.println("Enter Account Number: ");
            String accNum = myObj.next();
            System.out.println("Enter Pin Number: ");
            int pinNum = myObj.nextInt();
            userBank = verifyCredentials(accNum, pinNum);
            BankAccount verifiedAccount = getVerifiedAccount();
            if (verifiedAccount != null) {
                transactionObj.setTransId();
                transactionObj.setDateTime();
                transactionObj.setAccount(verifiedAccount);
                System.out.println("1.\tCheck Balance");
                System.out.println("2.\tWithdraw Money");
                System.out.println("3.\tDeposit Money");
                System.out.println("4.\tTransfer Funds");
                System.out.println("Select your transaction type");
                option = myObj.nextInt();
                if (option == 1) {
                    transactionObj.printReceipt(userBank,option);      
                } else if(option == 2){
                    transactionObj.printReceipt(userBank,option);
                } else if(option == 3){
                    transactionObj.printReceipt(userBank,option);
                } else if(option == 4){
                    transactionObj.printReceipt(userBank,option);
                }
            }
            else {
                System.out.println("Invalid Account");
            }
            System.out.println("Do you wanna continue your transaction? (Press 0 to exit)");
            choice = myObj.nextInt();
        } while (choice != 0);
    }
}
