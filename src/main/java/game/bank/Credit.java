package game.bank;

import game.Player;

public class Credit {
    private String bankName;
    private int startMonth;
    private int fullAmountOfCredit;
    private int monthlyPayment;
    private int monthlyInterest;
    private int numberOfMonths;
    private int restAmountOfCredit;
    private boolean isActive = true;

    public Credit(String bankName, int startMonth, int fullAmountOfCredit,  int monthlyInterest, int numberOfMonths) {
        this.bankName = bankName;
        this.startMonth = startMonth;
        this.fullAmountOfCredit = fullAmountOfCredit;
        this.monthlyPayment = (int) (fullAmountOfCredit/numberOfMonths * (1 + (0.01 * monthlyInterest)));
        this.monthlyInterest = this.monthlyPayment - fullAmountOfCredit/numberOfMonths;
        this.numberOfMonths = numberOfMonths;
        this.restAmountOfCredit = this.monthlyPayment * numberOfMonths;
    }

    public Credit() {}

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getFullAmountOfCredit() {
        return fullAmountOfCredit;
    }

    public void setFullAmountOfCredit(int fullAmountOfCredit) {
        this.fullAmountOfCredit = fullAmountOfCredit;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(int monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public int getRestAmountOfCredit() {
        return restAmountOfCredit;
    }

    public void setRestAmountOfCredit(int restAmountOfCredit) {
        this.restAmountOfCredit = restAmountOfCredit;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        if(!active) Player.creditUnActive();
        isActive = active;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public void endCredit() {
        this.isActive = false;
    }
}
