package openended;

public class BankAccount {
    private User ownedBy;
    private String accNum;
    private int pin;
    private float amount;

    public BankAccount(User ownedBy, String accNum, int pin, float amount) {
        this.ownedBy = ownedBy;
        this.accNum = accNum;
        this.pin = pin;
        this.amount=amount;
    }
    public User getUser() {
        return ownedBy;
    }
    public String getAccNum() {
        return accNum;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public int getPin() {
        return pin;
    }
     public void setAmount(float amount) {
        this.amount = amount;
    }
    public float getAmount() {
        return amount;
    }

}