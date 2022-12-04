package game.management;

import account.Account;
import account.AccountException;
import account.authentication.LoggedInAccount;
import display.GameDisplayer;
import jdbc.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.DataManager.executeQuery;

/**
 * Klasa służąca do zarządzania grą.
 */
public abstract class ManageGame {

    /**
     * Metoda pobierająca gry z bazy.
     * @return ResultSet z kontami.
     */
    public static ResultSet getGames() throws SQLException {
        if(Connect.getConnection() != null) {
            return GameDisplayer.getAllGames();
        } else {
            return null;
        }
    }

    /**
     * Metoda zwracająca informacje, czy gra jest gotowa do przeniesienia do następnej rundy.
     * @param game_id id gry, dla której sprawdzamy możliwość przeniesienia.
     * @return wartość typu boolean zawierająca informację o możliwości przeniesienia gry.
     */
    public static boolean isGameReady(String game_id) throws SQLException {
        if(Connect.getConnection() != null) {
            ResultSet games = executeQuery("SELECT ready FROM hotelprojekt.game_users WHERE game_id = " + game_id + " ORDER BY game_id;");
            boolean isReady = true;
            while (games.next()) {
                if(games.getString(1).equals("f")) {
                    isReady = false;
                }
            }
            return isReady;
        } else {
            return false;
        }
    }

    /**
     * Metoda przenosząca grę do następnej rundy.
     * @param game_id id gry do przeniesienia.
     * @param new_round_number numer nowej rundy.
     * @throws SQLException
     */
    public static void moveGameToNextRound(int game_id, int new_round_number) throws SQLException {
        if(Connect.getConnection() != null) {
            executeQuery("UPDATE hotelprojekt.game SET current_round = " + new_round_number + " WHERE game_id = " + game_id + ";");
            executeQuery("UPDATE hotelprojekt.game_users SET ready = false WHERE game_id = " + game_id + ";");
        }
    }
}
