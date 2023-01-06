package game.bank;

public class Deposit {
    private int startMonth;
    private int numberOfMonths;
    private int initialRate;
    private int totalInterestValue;
    private boolean isActive = true;

    public Deposit(int startMonth, int numberOfMonths, int initialRate, int totalInterestValue) {
        this.startMonth = startMonth;
        this.numberOfMonths = numberOfMonths;
        this.initialRate = initialRate;
        this.totalInterestValue = totalInterestValue;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public int getInitialRate() {
        return initialRate;
    }

    public void setInitialRate(int initialRate) {
        this.initialRate = initialRate;
    }

    public int getTotalInterestValue() {
        return totalInterestValue;
    }

    public void setTotalInterestValue(int totalInterestValue) {
        this.totalInterestValue = totalInterestValue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int endDeposit() {
        this.isActive = false;
        float totalValue = totalInterestValue;
        for(int i = 0; i < numberOfMonths; i++) {
            totalValue += totalValue * ((initialRate / 12.0) / 100);
        }
        return Math.round(totalValue);
    }
}
