package game.bank;

import game.Player;

import java.util.Random;

public abstract class ManageBanks {
    private static Bank currentlyChosenBank;
    private static Bank previouslyChosenBank;
    private static Bank bankOption1 = new Bank();
    private static Bank bankOption2 = new Bank();
    private static Bank bankOption3 = new Bank();
    private static String[] bankNames =  {"BIZNES BANK", "TRUST BANK", "FINANCIAL GROUP", "SPRING BANK", "GRAND BANK", "PREMIUM BANK", "DOMINION BANK"};
    private static int[][] bankValues = {new int[] {5, 5, 3, 7, 6}, new int[] {15, 0, 5, 5, 5}, new int[] {10, 2, 3, 8, 9}, new int[] {13, 8, 7, 8, 4}, new int[] {8, 6, 4, 9, 10}, new int[] {5, 8, 6, 9, 8}, new int[] {12, 4, 7, 7, 8}, new int[] {11, 6, 6, 5, 5}};

    /**
     * Metoda generująca propozycje banków.
     */
    public static void generateBankOptions() {
        Random random = new Random();
        if(currentlyChosenBank == null && previouslyChosenBank == null) {
            //brak wybranego banku

            //wylosowanie wartości dla banków
            int bankNameIndex = random.nextInt(bankNames.length - 2);
            int bank1Values = random.nextInt(bankValues.length);
            int bank2Values = random.nextInt(bankValues.length);
            int bank3Values = random.nextInt(bankValues.length);

            //ustawienie wartości dla propozycji banku 1
            bankOption1.setName(bankNames[bankNameIndex]);
            bankOption1.setAccountCost(bankValues[bank1Values][0]);
            bankOption1.setCardCost(bankValues[bank1Values][1]);
            bankOption1.setCreditInterestRate(bankValues[bank1Values][2]);
            bankOption1.setDepositInterestRate(bankValues[bank1Values][3]);
            bankOption1.setRevolvingCreditInterestRate(bankValues[bank1Values][4]);

            //ustawienie wartości dla propozycji banku 2
            bankOption2.setName(bankNames[bankNameIndex + 1]);
            bankOption2.setAccountCost(bankValues[bank2Values][0]);
            bankOption2.setCardCost(bankValues[bank2Values][1]);
            bankOption2.setCreditInterestRate(bankValues[bank2Values][2]);
            bankOption2.setDepositInterestRate(bankValues[bank2Values][3]);
            bankOption2.setRevolvingCreditInterestRate(bankValues[bank2Values][4]);

            //ustawienie wartości dla propozycji banku 3
            bankOption3.setName(bankNames[bankNameIndex + 2]);
            bankOption3.setAccountCost(bankValues[bank3Values][0]);
            bankOption3.setCardCost(bankValues[bank3Values][1]);
            bankOption3.setCreditInterestRate(bankValues[bank3Values][2]);
            bankOption3.setDepositInterestRate(bankValues[bank3Values][3]);
            bankOption3.setRevolvingCreditInterestRate(bankValues[bank3Values][4]);;
        } else {
            //jest już wybrany bank
                int bank2Values = random.nextInt(bankValues.length);
                int bank3Values = random.nextInt(bankValues.length);

                //ustawienie wartości dla propozycji banku 1
                bankOption1.setName(previouslyChosenBank.getName());
                bankOption1.setAccountCost(previouslyChosenBank.getAccountCost());
                bankOption1.setCardCost(previouslyChosenBank.getCardCost());
                bankOption1.setCreditInterestRate(previouslyChosenBank.getCreditInterestRate());
                bankOption1.setDepositInterestRate(previouslyChosenBank.getDepositInterestRate());
                bankOption1.setRevolvingCreditInterestRate(previouslyChosenBank.getRevolvingCreditInterestRate());
                bankOption1.setDeposits(previouslyChosenBank.getDeposits());

                //wybranie nazwy banku 2 innej niż obecnie wybranego banku
                int bankNameIndex;
                do {
                    bankNameIndex = random.nextInt(bankNames.length - 1);
                } while (bankNames[bankNameIndex].equals(previouslyChosenBank.getName()));

                //ustawienie wartości dla propozycji banku 2
                bankOption2.setName(bankNames[bankNameIndex]);
                bankOption2.setAccountCost(bankValues[bank2Values][0]);
                bankOption2.setCardCost(bankValues[bank2Values][1]);
                bankOption2.setCreditInterestRate(bankValues[bank2Values][2]);
                bankOption2.setDepositInterestRate(bankValues[bank2Values][3]);
                bankOption2.setRevolvingCreditInterestRate(bankValues[bank2Values][4]);

                //wybranie nazwy banku 3 innej niż obecnie wybranego oraz propozycji banku 2
                do {
                    bankNameIndex = random.nextInt(bankNames.length - 1);
                } while (bankNames[bankNameIndex].equals(previouslyChosenBank.getName()) || bankNames[bankNameIndex].equals(bankOption2.getName()));

                //ustawienie wartości dla propozycji banku 3
                bankOption3.setName(bankNames[bankNameIndex]);
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
        ManageBanks.currentlyChosenBank.setAccountNumber(new Random().nextInt(1000000000) + 100000000);
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
        previouslyChosenBank = new Bank(currentlyChosenBank.getName(), currentlyChosenBank.getAccountCost(), currentlyChosenBank.getCardCost(), currentlyChosenBank.getDepositInterestRate(), currentlyChosenBank.getCreditInterestRate(), currentlyChosenBank.getRevolvingCreditInterestRate(), currentlyChosenBank.getAccountNumber());
        previouslyChosenBank.setDeposits(currentlyChosenBank.getDeposits());
        bankOption1 = new Bank(currentlyChosenBank.getName(), currentlyChosenBank.getAccountCost(), currentlyChosenBank.getCardCost(), currentlyChosenBank.getDepositInterestRate(), currentlyChosenBank.getCreditInterestRate(), currentlyChosenBank.getRevolvingCreditInterestRate(), currentlyChosenBank.getAccountNumber());
        currentlyChosenBank = null;
        bankOption2 = new Bank();
        bankOption3 = new Bank();
    }

    public static boolean isBankChosen() {
        return ManageBanks.currentlyChosenBank != null;
    }
}
