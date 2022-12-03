package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Klasa abstrakcyjna służąca do zarządzania danymi w bazie
 */
public abstract class DataManager {
    /**
     * Metoda służąca do wysyłania zapytania do bazy danych
     * @param query
     * @throws SQLException
     */
    public static ResultSet executeQuery(String query) throws SQLException {
        Statement statement = Connect.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
