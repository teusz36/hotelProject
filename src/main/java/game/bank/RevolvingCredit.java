package game.bank;

import game.management.CurrentlyPlayedGame;

public class RevolvingCredit extends Credit{

    int fullAmountOfCredit = 0;
    int monthlyInterest = 0;

    public RevolvingCredit(String bankName, int bankId, int startMonth, int fullAmountOfCredit, int monthlyInterest, int numberOfMonths) {
        super(bankName, bankId, startMonth, fullAmountOfCredit, monthlyInterest, numberOfMonths);
    }

    public RevolvingCredit(int fullAmountOfCredit, int monthlyInterest) {
        super();
        this.fullAmountOfCredit = fullAmountOfCredit;
        this.monthlyInterest = monthlyInterest;
    }

    /**
     * Metoda wykonywana przy braniu kredytu.
     * @param amount kwota kredytu.
     */
    public void getCredit(int amount) {
        this.fullAmountOfCredit += amount;
        CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + amount);
    }

    /**
     * Metoda spłacania kredytu.
     * @param amount wartość pieniężna, o którą kredyt jest spłacany.
     */
    public void payCredit(int amount) {
        if(this.fullAmountOfCredit >= amount) {
            this.fullAmountOfCredit -= amount;
            CurrentlyPlayedGame.setBalance(0);
        } else {
            CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - this.fullAmountOfCredit);
            this.fullAmountOfCredit = 0;
        }
    }

    /**
     * Metoda naliczania miesięcznych odsetek.
     */
    public void addInterest() {
        System.out.println("Odsetki: " + (this.fullAmountOfCredit * (0.01 * this.monthlyInterest)));
        this.fullAmountOfCredit += this.fullAmountOfCredit * (0.01 * this.monthlyInterest);
    }

    public int getFullAmountOfRevolvingCredit() {
        return this.fullAmountOfCredit;
    }

    public void setMonthlyResolvingInterest(int monthlyResolvingInterest) {
        this.monthlyInterest = monthlyResolvingInterest;
    }
}
