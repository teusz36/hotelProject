package org.openjfx;

import account.authentication.LoginAccount;
import javafx.fxml.FXML;

import java.io.IOException;

public class PanelAdminScreenController {

    public static int getEditUserId() {
        return editUserId;
    }

    public static void setEditUserId(int editUserId) {
        PanelAdminScreenController.editUserId = editUserId;
    }

    public static int editUserId;

    /**
     * Metoda przełączająca na paneladminaccountsscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccountEdit() throws IOException {
        App.setRoot("paneladminaccountsscreen");
    }

    /**
     * Metoda przełączająca na paneladmingamesscreen
     * @throws IOException
     */
    @FXML
    private void switchToGames() throws IOException {
        App.setRoot("paneladmingamesscreen");
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
