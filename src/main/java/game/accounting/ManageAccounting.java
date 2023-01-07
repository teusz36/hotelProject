package game.accounting;

import java.util.Random;

public abstract class ManageAccounting {
    private static Accounting currentlyChosenAccountingOffice;
    private static Accounting previouslyChosenAccountingOffice;
    private static Accounting accountingOption1 = new Accounting();
    private static Accounting accountingOption2 = new Accounting();
    private static Accounting accountingOption3 = new Accounting();
    public static String[] officesNames =  {"BIZNES ACCOUNTING", "TRUST ACCOUNTING", "FINANCIAL ACCOUNTING", "SPRING ACCOUNTING", "GRAND ACCOUNTING", "PREMIUM ACCOUNTING", "DOMINION ACCOUNTING", "NEW ACCOUNTING"};
    public static int[][] officesValues = {new int[] {1, 30, 10}, new int[] {2, 32, 11}, new int[] {1, 25, 17}, new int[] {3, 15, 20}, new int[] {4, 15, 15}, new int[] {2, 28, 24}, new int[] {1, 15, 48}, new int[] {2,40,10}};

    public static void generateAccountingOfficeOption() {
        Random random = new Random();
        if(currentlyChosenAccountingOffice == null && previouslyChosenAccountingOffice == null) {
            //brak wybranego Biura

            //wylosowanie wartości dla biur
            int accounting1Values = random.nextInt(officesValues.length), accounting2Values, accounting3Values;
            do { accounting2Values = random.nextInt(officesValues.length); } while (accounting2Values == accounting1Values);
            do { accounting3Values = random.nextInt(officesValues.length); } while (accounting3Values == accounting1Values || accounting3Values == accounting2Values);

            //ustawienie wartości dla propozycji biura 1
            accountingOption1.setAccountingOfficeName(officesNames[accounting1Values]);
            accountingOption1.setAccountingOfficeId(accounting1Values + 1);
            accountingOption1.setAccountingOfficeSingleCost(officesValues[accounting1Values][0]);
            accountingOption1.setAccountingOfficeFullCost(officesValues[accounting1Values][1]);
            accountingOption1.setAccountingOfficeLawCost(officesValues[accounting1Values][2]);


            //ustawienie wartości dla propozycji biura 2
            accountingOption2.setAccountingOfficeName(officesNames[accounting2Values]);
            accountingOption2.setAccountingOfficeId(accounting2Values + 1);
            accountingOption2.setAccountingOfficeSingleCost(officesValues[accounting2Values][0]);
            accountingOption2.setAccountingOfficeFullCost(officesValues[accounting2Values][1]);
            accountingOption2.setAccountingOfficeLawCost(officesValues[accounting2Values][2]);


            //ustawienie wartości dla propozycji biura 3
            accountingOption3.setAccountingOfficeName(officesNames[accounting3Values]);
            accountingOption3.setAccountingOfficeId(accounting3Values + 1);
            accountingOption3.setAccountingOfficeSingleCost(officesValues[accounting3Values][0]);
            accountingOption3.setAccountingOfficeFullCost(officesValues[accounting3Values][1]);
            accountingOption3.setAccountingOfficeLawCost(officesValues[accounting3Values][2]);

        } else if(currentlyChosenAccountingOffice == null) {
            //wylosowanie wartości dla biur
            int accounting1Values = previouslyChosenAccountingOffice.getAccountingOfficeId() - 1, accounting2Values, accounting3Values;
            do { accounting2Values = random.nextInt(officesValues.length); } while (accounting2Values == accounting1Values);
            do { accounting3Values = random.nextInt(officesValues.length); } while (accounting3Values == accounting1Values || accounting3Values == accounting2Values);

            //ustawienie wartości dla propozycji biura 1
            accountingOption1.setAccountingOfficeName(officesNames[accounting1Values]);
            accountingOption1.setAccountingOfficeId(accounting1Values + 1);
            accountingOption1.setAccountingOfficeSingleCost(officesValues[accounting1Values][0]);
            accountingOption1.setAccountingOfficeFullCost(officesValues[accounting1Values][1]);
            accountingOption1.setAccountingOfficeLawCost(officesValues[accounting1Values][2]);


            //ustawienie wartości dla propozycji biura 2
            accountingOption2.setAccountingOfficeName(officesNames[accounting2Values]);
            accountingOption2.setAccountingOfficeId(accounting2Values + 1);
            accountingOption2.setAccountingOfficeSingleCost(officesValues[accounting2Values][0]);
            accountingOption2.setAccountingOfficeFullCost(officesValues[accounting2Values][1]);
            accountingOption2.setAccountingOfficeLawCost(officesValues[accounting2Values][2]);


            //ustawienie wartości dla propozycji biura 3
            accountingOption3.setAccountingOfficeName(officesNames[accounting3Values]);
            accountingOption3.setAccountingOfficeId(accounting3Values + 1);
            accountingOption3.setAccountingOfficeSingleCost(officesValues[accounting3Values][0]);
            accountingOption3.setAccountingOfficeFullCost(officesValues[accounting3Values][1]);
            accountingOption3.setAccountingOfficeLawCost(officesValues[accounting3Values][2]);


        } else {
            //jest już wybrane biuro
            int accounting1Values = 0, i = 0, accounting3Values, accounting2Values;
            for(String name: officesNames) {
                if(name.equals(previouslyChosenAccountingOffice.getAccountingOfficeName())) {
                    accounting1Values = i;
                } else {
                    i++;
                }
            }
            do { accounting2Values = random.nextInt(officesValues.length); } while (accounting2Values == accounting1Values);
            do { accounting3Values = random.nextInt(officesValues.length); } while (accounting3Values == accounting1Values || accounting3Values == accounting2Values);

            System.out.println(accounting1Values + ", " + accounting2Values + ", " + accounting3Values);
            //ustawienie wartości dla propozycji biura 1
            accountingOption1.setAccountingOfficeName(previouslyChosenAccountingOffice.getAccountingOfficeName());
            accountingOption1.setAccountingOfficeId(previouslyChosenAccountingOffice.getAccountingOfficeId());
            accountingOption1.setAccountingOfficeSingleCost(previouslyChosenAccountingOffice.getAccountingOfficeSingleCost());
            accountingOption1.setAccountingOfficeFullCost(previouslyChosenAccountingOffice.getAccountingOfficeFullCost());
            accountingOption1.setAccountingOfficeLawCost(previouslyChosenAccountingOffice.getAccountingOfficeLawCost());


            //ustawienie wartości dla propozycji biura 2
            accountingOption2.setAccountingOfficeName(officesNames[accounting2Values]);
            accountingOption2.setAccountingOfficeId(accounting2Values + 1);
            accountingOption2.setAccountingOfficeSingleCost(officesValues[accounting2Values][0]);
            accountingOption2.setAccountingOfficeFullCost(officesValues[accounting2Values][1]);
            accountingOption2.setAccountingOfficeLawCost(officesValues[accounting2Values][2]);


            //ustawienie wartości dla propozycji biura 3
            accountingOption3.setAccountingOfficeName(officesNames[accounting3Values]);
            accountingOption3.setAccountingOfficeId(accounting3Values + 1);
            accountingOption3.setAccountingOfficeSingleCost(officesValues[accounting3Values][0]);
            accountingOption3.setAccountingOfficeFullCost(officesValues[accounting3Values][1]);
            accountingOption3.setAccountingOfficeLawCost(officesValues[accounting3Values][2]);

        }
    }
    public static Accounting getCurrentlyChosenAccountingOffice() {
        return currentlyChosenAccountingOffice;
    }

    public static void choseAccountingOffice(int accountingOfficeID) {
        switch (accountingOfficeID) {
            case 1:
                if(ManageAccounting.isAccountingOfficeChosen()) {
                } else {
                    ManageAccounting.currentlyChosenAccountingOffice = accountingOption1;
                }
                break;
            case 2:
                ManageAccounting.currentlyChosenAccountingOffice = accountingOption2;
                break;
            case 3:
                ManageAccounting.currentlyChosenAccountingOffice = accountingOption3;
                break;
        }
    }

    public static Accounting getAccountingOption1() {
        if(currentlyChosenAccountingOffice != null) {
            return currentlyChosenAccountingOffice;
        }
        return accountingOption1;
    }

    public static Accounting getAccountingOption2() {
            return accountingOption2;
        }

    public static Accounting getAccountingOption3() {
            return accountingOption3;
        }

    public static void resetAccounting() {
        currentlyChosenAccountingOffice = null;
        accountingOption1 = new Accounting();
        accountingOption2 = new Accounting();
        accountingOption3 = new Accounting();
    }
    public static void setChosenAccountingOffice(int accountingOfficeID) {
        currentlyChosenAccountingOffice = new Accounting();
        currentlyChosenAccountingOffice.setAccountingOfficeName(officesNames[accountingOfficeID - 1]);
        currentlyChosenAccountingOffice.setAccountingOfficeId(accountingOfficeID);
        currentlyChosenAccountingOffice.setAccountingOfficeSingleCost(officesValues[accountingOfficeID - 1][0]);
        currentlyChosenAccountingOffice.setAccountingOfficeFullCost(officesValues[accountingOfficeID - 1][1]);
        currentlyChosenAccountingOffice.setAccountingOfficeLawCost(officesValues[accountingOfficeID - 1][2]);
        previouslyChosenAccountingOffice = new Accounting(currentlyChosenAccountingOffice.getAccountingOfficeName(), currentlyChosenAccountingOffice.getAccountingOfficeId(), currentlyChosenAccountingOffice.getAccountingOfficeSingleCost(), currentlyChosenAccountingOffice.getAccountingOfficeFullCost(), currentlyChosenAccountingOffice.getAccountingOfficeLawCost());
        }

    public static boolean isAccountingOfficeChosen() {
        return ManageAccounting.currentlyChosenAccountingOffice != null;
    }

}
