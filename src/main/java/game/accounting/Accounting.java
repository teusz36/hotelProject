package game.accounting;

import java.util.ArrayList;

public class Accounting {
    private String AccountingOfficeName;
    private int AccountingOfficeId;
    private int AccountingOfficeSingleCost;
    private int AccountingOfficeFullCost;
    private int AccountingOfficeLawCost;

    public Accounting(String name, int id, int singlecost, int fullcost, int lawcost) {
        this.AccountingOfficeName = name;
        this.AccountingOfficeId = id;
        this.AccountingOfficeSingleCost = singlecost;
        this.AccountingOfficeFullCost = fullcost;
        this.AccountingOfficeLawCost = lawcost;
    }

    public Accounting() {

    }
    public String getAccountingOfficeName(){
        return AccountingOfficeName;
    }

    public void setAccountingOfficeName(String name){
        this.AccountingOfficeName = name;
    }

    public int getAccountingOfficeSingleCost() {
        return AccountingOfficeSingleCost;
    }

    public void setAccountingOfficeSingleCost(int singleCost) {
        this.AccountingOfficeSingleCost = singleCost;
    }

    public int getAccountingOfficeFullCost() {
        return AccountingOfficeFullCost;
    }

    public void setAccountingOfficeFullCost(int fullCost) {
        this.AccountingOfficeFullCost = fullCost;
    }

    public int getAccountingOfficeLawCost() {
        return AccountingOfficeLawCost;
    }

    public void setAccountingOfficeLawCost(int lawCost) {
        this.AccountingOfficeLawCost = lawCost;
    }

    public int getAccountingOfficeId() {
        return AccountingOfficeId;
    }

    public void setAccountingOfficeId(int officeId) {
        this.AccountingOfficeId = officeId;
    }
}
