package account.authentication;

import account.Account;

/**
 * Klasa przechowująca informacje o zalogowanym obecnie użytkowniku.
 */
public class LoggedInAccount {
    private static Account loggedInAccount;
    private static boolean isUserLoggedIn = false;

    /**
     * geter zwracający konto zalogowanego użytkownika.
     * @return obiekt klasy Account, który jest obecnie zalogowanym użytkownikiem.
     */
    public static Account getLoggedInAccount() {
        if(LoggedInAccount.isUserLoggedIn) {
            return LoggedInAccount.loggedInAccount;
        } else {
            return null;
        }
    }

    /**
     * Metoda do sprawdzania, czy jest obecnie zalogowany jakiś użytkownik.
     * @return true, jeśli jest zalogowany użytkownik; false, jeśli nie ma.
     */
    public static boolean isUserLoggedIn() {
        return LoggedInAccount.isUserLoggedIn;
    }

    /**
     * Metoda służąca do ustawiania informacji o tym, czy jest, czy nie ma zalogowanego użytkownika.
     * @param userLoggedIn true, jeśli chcemy ustawić informację o zalogowanym użytkowniku; false, jeśli chcemy ustalić informacje, że nie ma zalogowanego użytkownika.
     */
    public static void setUserLoggedIn(boolean userLoggedIn) {
        LoggedInAccount.isUserLoggedIn = userLoggedIn;
    }

    /**
     * Metoda ustawiająca konto zalogowanego użytkownika.
     * @param account konto zalogowanego użytkownika.
     */
    public static void setLoggedInAccount(Account account) {
        setUserLoggedIn(true);
        LoggedInAccount.loggedInAccount = account;
    }

}
