package game;

import javafx.scene.image.Image;

import java.io.File;

/**
 * Klasa reprezentująca grę.
 */
public class Game {
    private int gameId;
    private int hotelId;
    private int currentRound;
    private boolean isGameOnGoing;
    private boolean isGameReadyForNextRound;
    private int numberOfPlayers;
    private Image hotelLogo;
    private File hotelLogoFile;
    private String hotelName;
    private String hotelMission;

    public Game(int gameId, int currentRound, boolean isGameOnGoing, boolean isGameReadyForNextRound, int numberOfPlayers) {
        this.gameId = gameId;
        this.currentRound = currentRound;
        this.isGameOnGoing = isGameOnGoing;
        this.isGameReadyForNextRound = isGameReadyForNextRound;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Game(String gameId, String hotelId, String currentRound, String isGameOnGoing, boolean isGameReadyForNextRound, String numberOfPlayers) {
        this.gameId = Integer.parseInt(gameId);
        this.hotelId = Integer.parseInt(hotelId);
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

    public void setHotelLogo(Image hotelLogo) {
        this.hotelLogo = hotelLogo;
    }

    public Image getHotelLogo() {
        return hotelLogo;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelMission() {
        return hotelMission;
    }

    public void setHotelMission(String hotelMission) {
        this.hotelMission = hotelMission;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public File getHotelLogoFile() {
        return hotelLogoFile;
    }

    public void setHotelLogoFile(File hotelLogoFile) {
        this.hotelLogoFile = hotelLogoFile;
    }
}
