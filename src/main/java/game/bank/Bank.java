package game.bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private int accountCost;
    private int cardCost;
    private int depositInterestRate;
    private int creditInterestRate;
    private int revolvingCreditInterestRate;
    private long accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit> ();

    public Bank(String name, int accountCost, int cardCost, int depositInterestRate, int creditInterestRate, int revolvingCreditInterestRate, long accountNumber) {
        this.name = name;
        this.accountCost = accountCost;
        this.cardCost = cardCost;
        this.depositInterestRate = depositInterestRate;
        this.creditInterestRate = creditInterestRate;
        this.revolvingCreditInterestRate = revolvingCreditInterestRate;
    }

    public Bank() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountCost() {
        return accountCost;
    }

    public void setAccountCost(int accountCost) {
        this.accountCost = accountCost;
    }

    public int getCardCost() {
        return cardCost;
    }

    public void setCardCost(int cardCost) {
        this.cardCost = cardCost;
    }

    public int getDepositInterestRate() {
        return depositInterestRate;
    }

    public void setDepositInterestRate(int depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    public int getCreditInterestRate() {
        return creditInterestRate;
    }

    public void setCreditInterestRate(int creditInterestRate) {
        this.creditInterestRate = creditInterestRate;
    }

    public int getRevolvingCreditInterestRate() {
        return revolvingCreditInterestRate;
    }

    public void setRevolvingCreditInterestRate(int revolvingCreditInterestRate) {
        this.revolvingCreditInterestRate = revolvingCreditInterestRate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void addDeposit(Deposit deposit) {
        deposits.add(deposit);
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }
}
