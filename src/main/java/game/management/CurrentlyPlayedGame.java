package game.management;

import game.Game;

/**
 * Klasa przechowująca informacje o obecnie uruchomionej grze.
 */
public class CurrentlyPlayedGame {
    private static Game currentGame;
    private static boolean isGameActive;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CurrentlyPlayedGame.currentGame = currentGame;
        CurrentlyPlayedGame.isGameActive = true;
    }

    public static void turnGameOff() {
        CurrentlyPlayedGame.currentGame = null;
        CurrentlyPlayedGame.isGameActive = false;
    }
}
