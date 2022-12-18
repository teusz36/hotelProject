package org.openjfx;

import account.Account;
import account.AccountException;
import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;

public class UserEditAccountScreenController {

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
        editUserScreenLogin.setText(LoggedInAccount.getLoggedInAccount().getUsername());
        editUserScreenName.setText(LoggedInAccount.getLoggedInAccount().getName());
        editUserScreenLastName.setText(LoggedInAccount.getLoggedInAccount().getLastName());
        editUserScreenEmail.setText(LoggedInAccount.getLoggedInAccount().getEmail());
        editUserScreenPassword.setText(LoggedInAccount.getLoggedInAccount().getPassword());
    }

    @FXML
    private void editUser() throws SQLException, IOException {
        try {
            ManageAccount.updateAccountsData(ManageAccount.getUserInfo(LoggedInAccount.getLoggedInAccount().getUsername())[0], editUserScreenLogin.getText(), editUserScreenName.getText(), editUserScreenLastName.getText(), editUserScreenEmail.getText(), editUserScreenPassword.getText());
            if(LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
                App.setRoot("adminaccountscreen");
            } else {
                App.setRoot("useraccountscreen");
            }
        } catch (AccountException e) {
            editUserScreenError.setText(e.getMessage());
        }
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
     * Metoda przełączająca na paneladminaccountsscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccountEdit() throws IOException {
        App.setRoot("paneladminaccountsscreen");
    }

    /**
     * Metoda przełączająca na usermainscreen
     * @throws IOException
     */
    @FXML
    private void switchToMyGames() throws IOException {
        App.setRoot("usermainscreen");
    }

    /**
     * Metoda przełączająca na createaccountscreen
     * @throws IOException
     */
    @FXML
    private void switchToAddAccount() throws IOException {
        App.setRoot("createaccountscreen");
    }

    @FXML
    private void switchToAccount() throws IOException {
        if(LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
            App.setRoot("adminaccountscreen");
        } else {
            App.setRoot("useraccountscreen");
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
