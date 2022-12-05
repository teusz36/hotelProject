package org.openjfx;

import account.authentication.LoginAccount;
import javafx.fxml.FXML;

import java.io.IOException;

public class PanelAdminScreenController {

    public static int editUserId;

    public static int getEditUserId() {
        return editUserId;
    }

    public static void setEditUserId(int editUserId) {
        PanelAdminScreenController.editUserId = editUserId;
    }

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

    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("adminaccountscreen");
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
