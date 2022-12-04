package display;

import jdbc.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do pobierania gier z bazy.
 */
public abstract class GameDisplayer {
    /**
     * Metoda pobierająca gry z bazy
     * @return
     * @throws SQLException
     */
    public static ResultSet getAllGames() throws SQLException {
        if(Connect.getConnection() != null) {
            return executeQuery("SELECT g.game_id, g.start_date, g.end_date, g.isongoing, g.current_round, COUNT(*) FROM hotelprojekt.game g LEFT JOIN hotelprojekt.game_users gu ON g.game_id = gu.game_id GROUP BY g.game_id, g.current_round, g.start_date, g.end_date, g.isongoing ORDER BY game_id;");
        } else {
            return null;
        }
    }
}


