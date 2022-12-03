package account.management;

import account.Account;
import account.AccountException;
import account.authentication.LoggedInAccount;
import jdbc.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do zarządzania kontem.
 */
public abstract class ManageAccount {

    /**
     * Metoda usuwająca użytkownika z bazy na podstawie obiektu typu Account.
     * @param account obiekt typu Account przechowujący informacje o użytkowniku do usunięcia.
     */
    public static void deleteAccount(Account account) throws AccountException {
        if(LoggedInAccount.isUserLoggedIn()) {
            if (LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN || account == LoggedInAccount.getLoggedInAccount()) {
                if (Connect.getConnection() != null) {
                    try {
                        executeQuery("DELETE FROM hotelprojekt.users WHERE username = '" + account.getUsername() + "';");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (LoggedInAccount.getLoggedInAccount().equals(account)) {
                        LoggedInAccount.setUserLoggedIn(false);
                    }
                }
            } else {
                throw new AccountException("Brak uprawnień do usunięcia konta");
            }
        }
    }

    public static void deleteAccount(String username) throws AccountException{
        if(LoggedInAccount.isUserLoggedIn()) {
            if (LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
                if (Connect.getConnection() != null) {
                    try {
                        executeQuery("DELETE FROM hotelprojekt.users WHERE username = '" + username + "';");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new AccountException("brak uprawnień do usunięcia konta");
            }
        }
    }

    /**
     * Metoda aktualizująca dane obecnie zalogowanego użytkownika.
     * @param username nowy login
     * @param firstname nowe imie
     * @param lastname nowe nazwisko
     * @param email nowy email
     * @param password nowe hasło
     */
    public static void updateAccountData(String username, String firstname, String lastname, String email, String password) throws SQLException, AccountException {
        if(LoggedInAccount.isUserLoggedIn()) {
            if (Connect.getConnection() != null) {
                boolean isUsernameReserved = false;
                ResultSet rs = executeQuery("SELECT username FROM toik.users;");
                while (rs.next()) {
                    if(rs.getString(1).equals(username)) {
                        isUsernameReserved = true;
                    }
                }
                if(!isUsernameReserved) {
                    try {
                        executeQuery("UPDATE toik.users SET username = '" + username + "', first_name = '" + firstname + "', last_name = '" + lastname + "', email = '" + email + "', password = '" + password + "' WHERE username = '" + LoggedInAccount.getLoggedInAccount().getUsername() + "';");
                        LoggedInAccount.setLoggedInAccount(new Account(username, firstname, lastname, email, password, LoggedInAccount.getLoggedInAccount().getAccountType()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new AccountException("Login zajęty");
                }
            }
        }
    }

    /**
     * Metoda aktualizująca dane podanego użytkownika.
     * @param oldUsername stary login
     * @param username nowy login
     * @param firstname nowe imie
     * @param lastname nowe nazwisko
     * @param email nowy email
     * @param password nowe hasło
     */
    public static void updateAccountsData(String oldUsername, String username, String firstname, String lastname, String email, String password) throws SQLException, AccountException {
        if(LoggedInAccount.isUserLoggedIn()) {
            if (Connect.getConnection() != null) {
                boolean isUsernameReserved = false;
                ResultSet rs = executeQuery("SELECT username FROM toik.users;");
                while (rs.next()) {
                    if(rs.getString(1).equals(username)) {
                        isUsernameReserved = true;
                    }
                }
                if(!isUsernameReserved) {
                    try {
                        executeQuery("UPDATE toik.users SET username = '" + username + "', first_name = '" + firstname + "', last_name = '" + lastname + "', email = '" + email + "', password = '" + password + "' WHERE username = '" + oldUsername + "';");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new AccountException("Podany użytkownik już istnieje");
                }
            }
        }
    }

    /**
     * Metoda pobierająca informacje o danym użytkowniku na podstawie id.
     * @param userId id użytkownika
     * @return Tablica z danymi.
     */
    public static String[] getUserInfo(int userId) throws SQLException {
        if(Connect.getConnection() != null) {
            String[] info = new String[6];
            ResultSet rs =  executeQuery("SELECT * FROM toik.users WHERE user_id = " + userId + ";");
            while (rs.next()) {
                info[0] = rs.getString(2);
                info[1] = rs.getString(3);
                info[2] = rs.getString(4);
                info[3] = rs.getString(5);
                info[4] = rs.getString(6);
                info[5] = rs.getString(1);
                return info;
            }
        }
        return null;
    }

    /**
     * Metoda pobierająca informacje o danym użytkowniku na podstawie loginu.
     * @param username login użytkownika.
     * @return Tablica z danymi.
     */
    public static String[] getUserInfo(String username) throws SQLException {
        if(Connect.getConnection() != null) {
            String[] info = new String[6];
            ResultSet rs =  executeQuery("SELECT * FROM toik.users WHERE username = '" + username + "';");
            while (rs.next()) {
                info[0] = rs.getString(2);
                info[1] = rs.getString(3);
                info[2] = rs.getString(4);
                info[3] = rs.getString(5);
                info[4] = rs.getString(6);
                info[5] = rs.getString(1);
                return info;
            }
        }
        return null;
    }
}