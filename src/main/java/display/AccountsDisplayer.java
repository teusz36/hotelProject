package display;

import jdbc.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do pobierania kont z bazy.
 */
public abstract class AccountsDisplayer {
    /**
     * Metoda pobierająca konta użytkowników z bazy
     * @return
     * @throws SQLException
     */
    public static ResultSet getAllAccounts() throws SQLException {
        if(Connect.getConnection() != null) {
            return executeQuery("SELECT * FROM hotelproject.users WHERE account_type = 1;");
        } else {
            return null;
        }
    }
}


