package openended;

import java.util.*;
public class Bank {
    private int id;
    private String location;
    private List < BankAccount > accountsList = new ArrayList < BankAccount > ();
    public Bank(int id, String location) {
        this.id = id;
        this.location = location;
    }
    public int getBankId() {
        return id;
    }

    public String getBankLoc() {
        return location;
    }

    public void setAccount(BankAccount account) {
        accountsList.add(account);
    }
    public List < BankAccount > getAccountsList() {
        return accountsList;
    }
}