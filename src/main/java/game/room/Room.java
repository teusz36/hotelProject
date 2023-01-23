package game.room;

public class Room {
    private String name;
    private int yearlyDemand;
    private int preferredPrice;
    private double employeeTime;
    private int furnishingPrices[];
    private boolean isBought = false;
    private int qualityBought = 0;
    private double seasonality[];
    private int startRound;
    private int officeFurnishingPrices[];
    private int resourcesPrices[];
    private boolean isActive = false;
    private int price = 0;
    private int discount = 0;

    public Room(String name, int yearlyDemand, int preferredPrice, double employeeTime, int[] furnishingPrices, int[] officeFurnishingPrices, int[] resourcesPrices, double[] seasonality, int startRound) {
        this.name = name;
        this.yearlyDemand = yearlyDemand;
        this.preferredPrice = preferredPrice;
        this.employeeTime = employeeTime;
        this.furnishingPrices = furnishingPrices;
        this.officeFurnishingPrices = officeFurnishingPrices;
        this.resourcesPrices = resourcesPrices;
        this.seasonality = seasonality;
        this.startRound = startRound;
    }

    public int getYearlyDemand() {
        return yearlyDemand;
    }

    public void setYearlyDemand(int yearlyDemand) {
        this.yearlyDemand = yearlyDemand;
    }

    public int getPreferredPrice() {
        return preferredPrice;
    }

    public void setPreferredPrice(int preferedPrice) {
        this.preferredPrice = preferedPrice;
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

    public int getStartRound() {
        return startRound;
    }

    public void setStartRound(int startRound) {
        this.startRound = startRound;
    }

    public int[] getOfficeFurnishingPrices() {
        return officeFurnishingPrices;
    }

    public void setOfficeFurnishingPrices(int[] officeFurnishingPrices) {
        this.officeFurnishingPrices = officeFurnishingPrices;
    }

    public int[] getResourcesPrices() {
        return resourcesPrices;
    }

    public void setResourcesPrices(int[] resourcesPrices) {
        this.resourcesPrices = resourcesPrices;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
