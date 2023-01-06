package game.bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private int bankId;
    private int accountCost;
    private int cardCost;
    private int depositInterestRate;
    private int creditInterestRate;
    private int revolvingCreditInterestRate;

    public Bank(String name, int id, int accountCost, int cardCost, int depositInterestRate, int creditInterestRate, int revolvingCreditInterestRate) {
        this.name = name;
        this.bankId = id;
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

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
}
