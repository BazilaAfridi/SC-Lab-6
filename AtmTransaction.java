
package openended;

import java.util.*;

public class AtmTransaction {
    private String transId;
    private Calendar dateTime = Calendar.getInstance();
    private BankAccount account;
    private AtmMachine atm;
    Scanner myObj = new Scanner(System.in);

    public AtmTransaction(AtmMachine atm)
    {
        this.atm = atm;
    }

    public void setTransId() {
        transId = UUID.randomUUID().toString();
    }
    public String getTransId() {
        return transId;
    }
    public void setDateTime() {
        Date dt = new Date(); 
        dateTime.setTime(dt);
    }
    public Date getDateTime() {
        return dateTime.getTime();
    }
   
    public void setAccount(BankAccount account) {
        this.account = account;
    }
    public BankAccount getAccount() {
        return account;
    }

    private void withdrawMoney(float withdrawAmount, BankAccount account) {
        float amount = account.getAmount(); 
        if (withdrawAmount <= amount && withdrawAmount > 0) {
            amount -= withdrawAmount;
            account.setAmount(amount);
        } else {
            System.out.println("Amount cannot be withdrawn as it is invalid/greater than the amount store in card");
        }
    }
    private void depositMoney(float depositAmount, BankAccount account){
        float amount = account.getAmount(); 
            amount += depositAmount;
            account.setAmount(amount);
    }
    private void print(Bank userBank){
    myObj.nextLine();
        System.out.println( "\n** ** ** ** ** ** ** ** ** **" );
        System.out.println(userBank.getBankLoc());
        System.out.println(userBank.getBankId());
        System.out.println( "** ** ** ** ** ** ** ** ** **" );
        System.out.println("Date/Time: " + getDateTime());
        System.out.println("Transaction Id: " + getTransId());
        System.out.println("User name: "+account.getUser().getName());
}
    public void printReceipt(Bank userBank, int option) {
        myObj.nextLine();
        if(option==1){
            print(userBank);
            System.out.println("Transaction Type: Check Balance");
            System.out.println("Transaction Amount: " + account.getAmount());
            System.out.println("Thank you for using ATM services :)\n");
        } else if (option == 2) {
            System.out.println("Enter the amount to withdraw: ");
            float amount = myObj.nextFloat();
            print(userBank);
            System.out.println("Transaction Type: Withdraw Money");
            System.out.println("Current Amount: " + account.getAmount());
            System.out.println("Requested Amount: " + amount);
            withdrawMoney(amount, account);
            System.out.println("Please take your money!!!\nThank you for using ATM services :)\n");
        } else if(option == 3) { 
            System.out.println("Insert the money to deposit: ");
            float amount = myObj.nextFloat();
            print(userBank);
            System.out.println("Transaction Type: Deposit Money");
            System.out.println("Current Amount: " + account.getAmount());
            System.out.println("Dposit Amount: " + amount);
            depositMoney(amount, account);
            System.out.println("Your money has been deposited!!!\nThank you for using ATM services :)\n");
        }  else if(option == 4){
            
            System.out.println("1-Link Member Bank");
            System.out.println("Enter the bank and branch to which funds will be transfer");
            String beneficiaryBank = myObj.nextLine();
            System.out.println("Enter the Beneficiary Account Number ");
            String beneficiaryAccount = myObj.next();
            System.out.println("Enter the amount of funds to transfer");
            float fundMoney = myObj.nextFloat();
            boolean isFundsTransferred = transferFunds(beneficiaryBank,beneficiaryAccount,fundMoney,userBank);
            if(isFundsTransferred){
                print(userBank);
                System.out.println("Transaction Type: Funds Transfer");
                System.out.println("Beneficiary Bank: " + beneficiaryBank);
                System.out.println("Beneficiary Account Number: " + beneficiaryAccount);             
                System.out.println("Your money has been transferred!!!\nThank you for using ATM services :)\n");
                    }
                }
        else {
            System.out.println("Invalid selection");
             }
    }
    private boolean transferFunds(String beneficiaryBank, String beneficiaryAccount, float fundMoney, Bank senderBank){
        boolean isTransferred = false;
        List <Bank> banksList = new ArrayList <Bank> ();
        float money;
        banksList = atm.getBanks();

        for(Bank bank : banksList){
            if(bank.getBankLoc().equals(beneficiaryBank)){
                if(senderBank.getBankLoc().equals(bank.getBankLoc())){
                    for(BankAccount account : bank.getAccountsList()){
                        if(account.getAccNum().equals(beneficiaryAccount)){
                        money = account.getAmount();
                        money += fundMoney;
                        account.setAmount(money);
                        isTransferred = true;
                        }
                    }
                }else{
                    System.out.println("Funds cannot be transfer to different bank");
                }
                
            }
        }
        return isTransferred;
    }
}
