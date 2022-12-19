package game.room;

public class Room {
    private String name;
    private int yearlyDemand;
    private int preferedPrice;
    private double employeeTime;
    private int furnishingPrices[];
    private boolean isBought = false;
    private int qualityBought = 0;
    private double seasonality[];

    public Room(String name, int yearlyDemand, int preferedPrice, double employeeTime, int[] furnishingPrices, double[] seasonality) {
        this.yearlyDemand = yearlyDemand;
        this.preferedPrice = preferedPrice;
        this.employeeTime = employeeTime;
        this.furnishingPrices = furnishingPrices;
        this.seasonality = seasonality;
    }

    public int getYearlyDemand() {
        return yearlyDemand;
    }

    public void setYearlyDemand(int yearlyDemand) {
        this.yearlyDemand = yearlyDemand;
    }

    public int getPreferedPrice() {
        return preferedPrice;
    }

    public void setPreferedPrice(int preferedPrice) {
        this.preferedPrice = preferedPrice;
    }

    public double getEmployeeTime() {
        return  employeeTime;
    }

    public void setEmployeeTime(float employeeTime) {
        this.employeeTime = employeeTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeTime(double employeeTime) {
        this.employeeTime = employeeTime;
    }

    public int[] getFurnishingPrices() {
        return furnishingPrices;
    }

    public void setFurnishingPrices(int[] furnishingPrices) {
        this.furnishingPrices = furnishingPrices;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public int getQualityBought() {
        return qualityBought;
    }

    public void setQualityBought(int qualityBought) {
        this.qualityBought = qualityBought;
    }

    public double[] getSeasonality() {
        return seasonality;
    }

    public void setSeasonality(double[] seasonality) {
        this.seasonality = seasonality;
    }
}
