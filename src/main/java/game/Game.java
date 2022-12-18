package game;

/**
 * Klasa reprezentująca grę.
 */
public class Game {
    private int gameId;
    private int currentRound;
    private boolean isGameOnGoing;
    private boolean isGameReadyForNextRound;
    private int numberOfPlayers;

    public Game(int gameId, int currentRound, boolean isGameOnGoing, boolean isGameReadyForNextRound, int numberOfPlayers) {
        this.gameId = gameId;
        this.currentRound = currentRound;
        this.isGameOnGoing = isGameOnGoing;
        this.isGameReadyForNextRound = isGameReadyForNextRound;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Game(String gameId, String currentRound, String isGameOnGoing, boolean isGameReadyForNextRound, String numberOfPlayers) {
        this.gameId = Integer.parseInt(gameId);
        this.currentRound = Integer.parseInt(currentRound);
        this.isGameOnGoing = isGameOnGoing.equals("t");
        this.isGameReadyForNextRound = isGameReadyForNextRound;
        this.numberOfPlayers = Integer.parseInt(numberOfPlayers);
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public boolean isGameOnGoing() {
        return isGameOnGoing;
    }

    public void setGameOnGoing(boolean gameOnGoing) {
        isGameOnGoing = gameOnGoing;
    }

    public boolean isGameReadyForNextRound() {
        return isGameReadyForNextRound;
    }

    public void setGameReadyForNextRound(boolean gameReadyForNextRound) {
        isGameReadyForNextRound = gameReadyForNextRound;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
