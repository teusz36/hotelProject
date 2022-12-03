package account.management;

import account.Account;

import account.AccountException;
import jdbc.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do rejestracji użytkownika
 */
public abstract class RegisterAccount {
    private static ResultSet rsTable;
    private static boolean isRegisterPossible;

    /**
     * Metoda rejestrująca użytkownika w bazie na podstawie obiektu typu Account
     * @param account obiekt klasy Account do rejestracji
     * @throws SQLException
     */
    public static void registerUser(Account account) throws SQLException, AccountException {
        isRegisterPossible = true;

        if(Connect.getConnection() != null) {
            System.out.println("połączono z bazą!");
                rsTable = executeQuery("SELECT * FROM hotelprojekt.users;");
                while (rsTable.next()) { //pętla przechodząca po wszystkich rekordach z tablicy hotelprojekt.users
                    if(account.getUsername().equals(rsTable.getString(2))) { //warunek sprawdzający, czy login nie występuje w bazie
                        isRegisterPossible = false;
                    }

                    System.out.println(rsTable.getString(1) + " " + rsTable.getString(2) + " " + rsTable.getString(3) + " " + rsTable.getString(4) + " " + rsTable.getString(5) + " " + rsTable.getString(6));
                }

                if(isRegisterPossible) {
                    executeQuery("INSERT INTO hotelprojekt.users (username, first_name, last_name, email, password, account_type) VALUES ('"  + account.getUsername() + "', '" + account.getName() + "', '" + account.getLastName() + "', '" + account.getEmail() + "', '" + account.getPassword() + "', " + account.getAccountType() + ")");
                    System.out.println("INSERT INTO hotelprojekt.users (username, first_name, last_name, email, password, account_type) VALUES ('"  + account.getUsername() + "', '" + account.getName() + "', '" + account.getLastName() + "', '" + account.getEmail() + "', '" + account.getPassword() + "', " + account.getAccountType() + ")");
                } else {
                    //throw new AccountException("Użytkownik o podanym loginie znajduje się już w bazie");
                }


        }
    }

    /**
     * Metoda rejestrująca użytkownika w bazie na podstawie podanych danych
     * @param username login użytkownika
     * @param firstName imie użytkownika
     * @param lastName nazwisko użytkownika
     * @param email email użytkownika
     * @param password hasło użytkownika
     * @param accountType typ konta użytkownika
     * @throws SQLException
     */
    public static void registerUser(String username, String firstName, String lastName, String email, String password, int accountType) throws SQLException, AccountException {
        if(!username.equals("")) {
            if(!firstName.equals("")) {
                if(!lastName.equals("")) {
                    if(!email.equals("")) {
                        if(!password.equals("")) {
                            RegisterAccount.registerUser(new Account(username, firstName, lastName, email, password, accountType));
                        } else {
                            throw new AccountException("Podaj hasło");
                        }
                    } else {
                        throw new AccountException("Podaj email");
                    }
                } else {
                    throw new AccountException("Podaj nazwisko");
                }
            } else {
                throw new AccountException("Podaj imię");
            }
        } else {
            throw new AccountException("Podaj login");
        }
    }
}
