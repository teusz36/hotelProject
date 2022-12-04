package org.openjfx;

import account.AccountException;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;

public class EditAccountScreenController {

    @FXML
    private TextArea editUserScreenLogin;

    @FXML
    private PasswordField editUserScreenPassword;

    @FXML
    private TextArea editUserScreenName;

    @FXML
    private TextArea editUserScreenLastName;

    @FXML
    private TextArea editUserScreenEmail;

    @FXML
    private Label editUserScreenError;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() throws SQLException {
        editUserScreenLogin.setText(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[0]);
        editUserScreenName.setText(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[1]);
        editUserScreenLastName.setText(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[2]);
        editUserScreenEmail.setText(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[3]);
        editUserScreenPassword.setText(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[4]);
    }

    @FXML
    private void editTicketCollector() throws SQLException, IOException {
        try {
            ManageAccount.updateAccountsData(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[0], editUserScreenLogin.getText(), editUserScreenName.getText(), editUserScreenLastName.getText(), editUserScreenEmail.getText(), editUserScreenPassword.getText());
            App.setRoot("paneladminaccountsscreen");
        } catch (AccountException e) {
            editUserScreenError.setText(e.getMessage());
        }
    }

    @FXML
    private void deleteTicketCollector() throws SQLException, AccountException, IOException {
        ManageAccount.deleteAccount(ManageAccount.getUserInfo(PanelAdminScreenController.getEditUserId())[0]);
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
     * Metoda przełączająca na createaccountscreen
     * @throws IOException
     */
    @FXML
    private void switchToAddAccount() throws IOException {
        App.setRoot("createaccountscreen");
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
