package game.bank;

import game.Player;

import java.util.Random;

public abstract class ManageBanks {
    private static Bank currentlyChosenBank;
    private static Bank previouslyChosenBank;
    private static Bank bankOption1 = new Bank();
    private static Bank bankOption2 = new Bank();
    private static Bank bankOption3 = new Bank();
    public static String[] bankNames =  {"BIZNES BANK", "TRUST BANK", "FINANCIAL GROUP", "SPRING BANK", "GRAND BANK", "PREMIUM BANK", "DOMINION BANK", "NEW BANK"};
    public static int[][] bankValues = {new int[] {5, 5, 3, 7, 6}, new int[] {15, 0, 5, 5, 5}, new int[] {10, 2, 3, 8, 9}, new int[] {13, 8, 7, 8, 4}, new int[] {8, 6, 4, 9, 10}, new int[] {5, 8, 6, 9, 8}, new int[] {12, 4, 7, 7, 8}, new int[] {11, 6, 6, 5, 5}};

    /**
     * Metoda generująca propozycje banków.
     */
    public static void generateBankOptions() {
        Random random = new Random();
        if(currentlyChosenBank == null && previouslyChosenBank == null) {
            //brak wybranego banku

            //wylosowanie wartości dla banków
            int bank1Values = random.nextInt(bankValues.length), bank2Values, bank3Values;
            do { bank2Values = random.nextInt(bankValues.length); } while (bank2Values == bank1Values);
            do { bank3Values = random.nextInt(bankValues.length); } while (bank3Values == bank1Values || bank3Values == bank2Values);

            //ustawienie wartości dla propozycji banku 1
            bankOption1.setName(bankNames[bank1Values]);
            bankOption1.setBankId(bank1Values + 1);
            bankOption1.setAccountCost(bankValues[bank1Values][0]);
            bankOption1.setCardCost(bankValues[bank1Values][1]);
            bankOption1.setCreditInterestRate(bankValues[bank1Values][2]);
            bankOption1.setDepositInterestRate(bankValues[bank1Values][3]);
            bankOption1.setRevolvingCreditInterestRate(bankValues[bank1Values][4]);

            //ustawienie wartości dla propozycji banku 2
            bankOption2.setName(bankNames[bank2Values]);
            bankOption2.setBankId(bank2Values + 1);
            bankOption2.setAccountCost(bankValues[bank2Values][0]);
            bankOption2.setCardCost(bankValues[bank2Values][1]);
            bankOption2.setCreditInterestRate(bankValues[bank2Values][2]);
            bankOption2.setDepositInterestRate(bankValues[bank2Values][3]);
            bankOption2.setRevolvingCreditInterestRate(bankValues[bank2Values][4]);

            //ustawienie wartości dla propozycji banku 3
            bankOption3.setName(bankNames[bank3Values]);
            bankOption3.setBankId(bank3Values + 1);
            bankOption3.setAccountCost(bankValues[bank3Values][0]);
            bankOption3.setCardCost(bankValues[bank3Values][1]);
            bankOption3.setCreditInterestRate(bankValues[bank3Values][2]);
            bankOption3.setDepositInterestRate(bankValues[bank3Values][3]);
            bankOption3.setRevolvingCreditInterestRate(bankValues[bank3Values][4]);
        } else if(currentlyChosenBank == null) {
            //wylosowanie wartości dla banków
            int bank1Values = previouslyChosenBank.getBankId() - 1, bank2Values, bank3Values;
            do { bank2Values = random.nextInt(bankValues.length); } while (bank2Values == bank1Values);
            do { bank3Values = random.nextInt(bankValues.length); } while (bank3Values == bank1Values || bank3Values == bank2Values);

            //ustawienie wartości dla propozycji banku 1
            bankOption1.setName(bankNames[bank1Values]);
            bankOption1.setBankId(bank1Values + 1);
            bankOption1.setAccountCost(bankValues[bank1Values][0]);
            bankOption1.setCardCost(bankValues[bank1Values][1]);
            bankOption1.setCreditInterestRate(bankValues[bank1Values][2]);
            bankOption1.setDepositInterestRate(bankValues[bank1Values][3]);
            bankOption1.setRevolvingCreditInterestRate(bankValues[bank1Values][4]);

            //ustawienie wartości dla propozycji banku 2
            bankOption2.setName(bankNames[bank2Values]);
            bankOption2.setBankId(bank2Values + 1);
            bankOption2.setAccountCost(bankValues[bank2Values][0]);
            bankOption2.setCardCost(bankValues[bank2Values][1]);
            bankOption2.setCreditInterestRate(bankValues[bank2Values][2]);
            bankOption2.setDepositInterestRate(bankValues[bank2Values][3]);
            bankOption2.setRevolvingCreditInterestRate(bankValues[bank2Values][4]);

            //ustawienie wartości dla propozycji banku 3
            bankOption3.setName(bankNames[bank3Values]);
            bankOption3.setBankId(bank3Values + 1);
            bankOption3.setAccountCost(bankValues[bank3Values][0]);
            bankOption3.setCardCost(bankValues[bank3Values][1]);
            bankOption3.setCreditInterestRate(bankValues[bank3Values][2]);
            bankOption3.setDepositInterestRate(bankValues[bank3Values][3]);
            bankOption3.setRevolvingCreditInterestRate(bankValues[bank3Values][4]);

        } else {
            //jest już wybrany bank
            int bank1Values = 0, i = 0, bank3Values, bank2Values;
            for(String name: bankNames) {
                if(name.equals(previouslyChosenBank.getName())) {
                    bank1Values = i;
                } else {
                    i++;
                }
            }
            do { bank2Values = random.nextInt(bankValues.length); } while (bank2Values == bank1Values);
            do { bank3Values = random.nextInt(bankValues.length); } while (bank3Values == bank1Values || bank3Values == bank2Values);

                //ustawienie wartości dla propozycji banku 1
                bankOption1.setName(previouslyChosenBank.getName());
                bankOption1.setBankId(previouslyChosenBank.getBankId());
                bankOption1.setAccountCost(previouslyChosenBank.getAccountCost());
                bankOption1.setCardCost(previouslyChosenBank.getCardCost());
                bankOption1.setCreditInterestRate(previouslyChosenBank.getCreditInterestRate());
                bankOption1.setDepositInterestRate(previouslyChosenBank.getDepositInterestRate());
                bankOption1.setRevolvingCreditInterestRate(previouslyChosenBank.getRevolvingCreditInterestRate());

                //ustawienie wartości dla propozycji banku 2
                bankOption2.setName(bankNames[bank2Values]);
                bankOption2.setBankId(bank2Values + 1);
                bankOption2.setAccountCost(bankValues[bank2Values][0]);
                bankOption2.setCardCost(bankValues[bank2Values][1]);
                bankOption2.setCreditInterestRate(bankValues[bank2Values][2]);
                bankOption2.setDepositInterestRate(bankValues[bank2Values][3]);
                bankOption2.setRevolvingCreditInterestRate(bankValues[bank2Values][4]);

                //ustawienie wartości dla propozycji banku 3
                bankOption3.setName(bankNames[bank3Values]);
                bankOption3.setBankId(bank3Values + 1);
                bankOption3.setAccountCost(bankValues[bank3Values][0]);
                bankOption3.setCardCost(bankValues[bank3Values][1]);
                bankOption3.setCreditInterestRate(bankValues[bank3Values][2]);
                bankOption3.setDepositInterestRate(bankValues[bank3Values][3]);
                bankOption3.setRevolvingCreditInterestRate(bankValues[bank3Values][4]);
        }
    }

    public static Bank getCurrentlyChosenBank() {
        return currentlyChosenBank;
    }

    public static void choseBank(int bankID) {
        switch (bankID) {
            case 1:
                if(ManageBanks.isBankChosen()) {
                } else {
                    ManageBanks.currentlyChosenBank = bankOption1;
                }
                break;
            case 2:
                ManageBanks.currentlyChosenBank = bankOption2;
                break;
            case 3:
                ManageBanks.currentlyChosenBank = bankOption3;
                break;
        }
        Player.getRevolvingCredit().setMonthlyResolvingInterest(ManageBanks.currentlyChosenBank.getRevolvingCreditInterestRate());
    }

    public static Bank getBankOption1() {
        if(currentlyChosenBank != null) {
            return currentlyChosenBank;
        }
        return bankOption1;
    }

    public static Bank getBankOption2() {
        return bankOption2;
    }

    public static Bank getBankOption3() {
        return bankOption3;
    }

    public static void resetBank() {
        currentlyChosenBank = new Bank();
        bankOption1 = new Bank();
        bankOption2 = new Bank();
        bankOption3 = new Bank();
    }

    public static void resetBankOptions() {
        previouslyChosenBank = new Bank(currentlyChosenBank.getName(), currentlyChosenBank.getBankId(), currentlyChosenBank.getAccountCost(), currentlyChosenBank.getCardCost(), currentlyChosenBank.getDepositInterestRate(), currentlyChosenBank.getCreditInterestRate(), currentlyChosenBank.getRevolvingCreditInterestRate());
        bankOption1 = new Bank(currentlyChosenBank.getName(), currentlyChosenBank.getBankId(), currentlyChosenBank.getAccountCost(), currentlyChosenBank.getCardCost(), currentlyChosenBank.getDepositInterestRate(), currentlyChosenBank.getCreditInterestRate(), currentlyChosenBank.getRevolvingCreditInterestRate());
        currentlyChosenBank = null;
        bankOption2 = new Bank();
        bankOption3 = new Bank();
    }

    public static boolean isBankChosen() {
        return ManageBanks.currentlyChosenBank != null;
    }

    public static void setChosenBank(int bankId) {
        currentlyChosenBank = new Bank();
        currentlyChosenBank.setName(bankNames[bankId - 1]);
        currentlyChosenBank.setBankId(bankId);
        currentlyChosenBank.setAccountCost(bankValues[bankId - 1][0]);
        currentlyChosenBank.setCardCost(bankValues[bankId - 1][1]);
        currentlyChosenBank.setCreditInterestRate(bankValues[bankId - 1][2]);
        currentlyChosenBank.setDepositInterestRate(bankValues[bankId - 1][3]);
        currentlyChosenBank.setRevolvingCreditInterestRate(bankValues[bankId - 1][4]);
        previouslyChosenBank = new Bank(currentlyChosenBank.getName(), currentlyChosenBank.getBankId(), currentlyChosenBank.getAccountCost(), currentlyChosenBank.getCardCost(), currentlyChosenBank.getDepositInterestRate(), currentlyChosenBank.getCreditInterestRate(), currentlyChosenBank.getRevolvingCreditInterestRate());
    }
}
