package org.openjfx;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import game.management.CurrentlyPlayedGame;
import game.management.ManageGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.w3c.dom.Text;

public class DashboardController {

    @FXML
    Label dashboardTabInfoRoundNumber;

    @FXML
    Label dashboardTabInfoGameId;

    @FXML
    Label dashboardTabInfoIsReady;
    @FXML
    ImageView dashboardTabInfoLogo;
    @FXML
    Label dashboardTabInfoLogoLabel;
    @FXML
    TextArea dashboardTabInfoCompanyName;
    @FXML
    TextArea dashboardTabInfoCompanyMission;



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
     * Metoda która pozwala na wybór pliku i wybranie go jako logo
     */
    @FXML
    private void fileSelection(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Logo for your Company");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
        File selectedFileInput = selectedFile;

        if(selectedFile != null) {
            dashboardTabInfoLogoLabel.setText("Zostało Wybrane Logo:");
            Image image = new Image(selectedFile.toURI().toString(), 240, 240, true, true,true);
            dashboardTabInfoLogo.setImage(image);
        } else {
            dashboardTabInfoLogoLabel.setText("Wybierz Logo Firmy");
        }
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