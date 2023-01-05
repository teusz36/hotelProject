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

    public static ResultSet getUserGames(String user_id) throws SQLException {
        if(Connect.getConnection() != null) {
            return executeQuery("SELECT g.game_id, g.start_date, g.end_date, g.isongoing, g.current_round, COUNT(*) FROM hotelprojekt.game g LEFT JOIN hotelprojekt.game_users gu ON g.game_id = gu.game_id WHERE gu.user_id = " + user_id + " GROUP BY g.game_id, g.current_round, g.start_date, g.end_date, g.isongoing ORDER BY game_id;");
        } else {
            return null;
        }
    }

    /**
     * Metoda pobierająca informacje o grze o podanym ID.
     * @param game_id ID gry.
     * @return ResultSet z danymi o grze.
     * @throws SQLException
     */
    public static ResultSet getGameByID(String game_id, String user_id) throws SQLException {
        if(Connect.getConnection() != null) {
            return executeQuery("SELECT g.game_id, g.start_date, g.end_date, g.isongoing, g.current_round, COUNT(*), gu.hotel_id FROM hotelprojekt.game g LEFT JOIN hotelprojekt.game_users gu ON g.game_id = gu.game_id WHERE gu.game_id = " + game_id + " AND gu.user_id = " + user_id + " GROUP BY g.game_id, g.current_round, g.start_date, g.end_date, g.isongoing, gu.hotel_id ORDER BY game_id;");
        } else {
            return null;
        }
    }
}


