package org.openjfx;

import java.io.IOException;
import java.sql.SQLException;

import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import game.management.CurrentlyPlayedGame;
import game.management.ManageGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    Label dashboardTabInfoRoundNumber;

    @FXML
    Label dashboardTabInfoGameId;

    @FXML
    Label dashboardTabInfoIsReady;

    @FXML
    private void initialize() {
        dashboardTabInfoRoundNumber.setText("runda " + CurrentlyPlayedGame.getCurrentGame().getCurrentRound());
        dashboardTabInfoGameId.setText(String.valueOf(CurrentlyPlayedGame.getCurrentGame().getGameId()));
        dashboardTabInfoIsReady.setText(String.valueOf(CurrentlyPlayedGame.getCurrentGame().isGameReadyForNextRound()));
    }

    @FXML
    private void markAsReady() throws SQLException {
        ManageGame.markGameAsReady(CurrentlyPlayedGame.getCurrentGame().getGameId(), ManageAccount.getUserId(LoggedInAccount.getLoggedInAccount().getUsername()));
    }

    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("useraccountscreen");
    }

    /**
     * Metoda wylogowująca użytkownika
     */
    @FXML
    private void logout() throws IOException {
        LoginAccount.logOutUser();
        App.setRoot("loginscreen");
    }
}