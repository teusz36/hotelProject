package account.authentication;

import account.Account;

import account.AccountException;
import jdbc.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do logowania i wylogowywania użytkownika
 */
public abstract class LoginAccount {
    private static ResultSet rsTable;
    private static String query;
    private static boolean loginSuccess;
    private static Account account;

    /**
     * Metoda logująca użytkownika. Sprawdza, czy wszystkie dane się zgadzają.
     * @param username login podany przez użytkownika próbującego się logować
     * @param password hasło użytkownika próbującego się logować
     * @throws SQLException
     */
    public static void logInUser(String username, String password) throws SQLException, AccountException {
        loginSuccess = false;
        if(Connect.getConnection() != null) {
            rsTable = executeQuery("SELECT * FROM hotelprojekt.users WHERE username = '" + username + "';");
            while (rsTable.next()) { //pętla przechodząca po wszystkich rekordach zwróconych przez zapytanie
                if (rsTable.getString(2).equals(username)) { //sprawdzenie, czy username w bazie zgadza się z podanym do logowania
                    if (rsTable.getString(6).equals(password)) { //sprawdzenie haseł
                        loginSuccess = true;
                        account = new Account(username, rsTable.getString(3), rsTable.getString(4), rsTable.getString(5), password, Integer.parseInt(rsTable.getString(7)), Integer.parseInt(rsTable.getString(1)));
                    } else {
                        throw new AccountException("Błędne hasło");
                    }
                }
            }
            if(loginSuccess) {
                LoggedInAccount.setLoggedInAccount(account);
                LoggedInAccount.setUserLoggedIn(true);
            } else {
                throw new AccountException("Błędny login");
            }
        } else {
            throw new AccountException("Brak połączenia");
        }
    }

    /**
     * Metoda wylogowująca użytkownika
     */
    public static void logOutUser() {
        LoggedInAccount.setUserLoggedIn(false);
    }
}
