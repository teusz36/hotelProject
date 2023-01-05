package game;

import game.bank.Credit;
import game.bank.Deposit;
import game.bank.RevolvingCredit;

import java.util.ArrayList;

public abstract class Player {
    private static ArrayList<Credit> credits = new ArrayList<Credit> ();
    private static ArrayList<Deposit> deposits = new ArrayList<Deposit> ();
    private static int activeCreditNumbers = 0;
    private static RevolvingCredit revolvingCredit = new RevolvingCredit(0, 0);

    public static ArrayList<Credit> getCredits() {
        return credits;
    }

    /**
     * Metoda sprawdzająca, czy gracz może wziąć kredyt i dodająca go.
     * @param credit kredyt do dodania.
     * @return wartość typu boolean informująca, czy gracz może wziąć kredyt.
     */
    public static boolean addCredit(Credit credit) {
        if(activeCreditNumbers < 3) {
            int suma = 0;
            for(Credit c: credits) {
                if(c.isActive()) suma += c.getFullAmountOfCredit();
            }
            if(suma < 50000) {
                credits.add(credit);
                activeCreditNumbers++;
                return true;
            }
        }
        return false;
    }

    public static void creditUnActive() {
        activeCreditNumbers--;
    }

    /**
     * Metoda sprawdzająca zdolność kredytową.
     * @return
     */
    public static boolean checkCreditWorthiness() {
        if(activeCreditNumbers < 3) {
            int suma = 0;
            for(Credit c: credits) {
                if(c.isActive()) suma += c.getFullAmountOfCredit();
            }
            if(suma < 50000) {
                return true;
            }
        }
        return false;
    }

    public static RevolvingCredit getRevolvingCredit() {
        return revolvingCredit;
    }

    public static ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public static void addDeposit(Deposit deposit) {
        deposits.add(deposit);
    }

    public static void setDeposits(ArrayList<Deposit> deposits) {
        Player.deposits = deposits;
    }


    public static void reset() {
        credits = new ArrayList<Credit> ();
        deposits = new ArrayList<Deposit> ();
        activeCreditNumbers = 0;
        revolvingCredit = new RevolvingCredit(0, 0);
    }
}
