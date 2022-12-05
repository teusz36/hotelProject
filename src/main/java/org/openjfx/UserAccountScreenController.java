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

public class UserAccountScreenController {

    @FXML
    Label userAccountLogin;

    @FXML
    Label userAccountName;

    @FXML
    Label userAccountLastName;

    @FXML
    Label userAccountEmail;

    @FXML
    private Label editUserScreenError;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() {
        userAccountLogin.setText(LoggedInAccount.getLoggedInAccount().getUsername());
        userAccountName.setText(LoggedInAccount.getLoggedInAccount().getName());
        userAccountLastName.setText(LoggedInAccount.getLoggedInAccount().getLastName());
        userAccountEmail.setText(LoggedInAccount.getLoggedInAccount().getEmail());
    }

    /**
     * Metoda przełączająca na usermainscreen
     * @throws IOException
     */
    @FXML
    private void editUserAccount() throws IOException {
        if(LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
            App.setRoot("admineditaccountscreen");
        } else {
            App.setRoot("usereditaccountscreen");
        }
    }

    /**
     * Metoda przełączająca na paneladmingamesscreen
     * @throws IOException
     */
    @FXML
    private void switchToGames() throws IOException {
        if(LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
            App.setRoot("paneladmingamesscreen");
        }
    }

    /**
     * Metoda przełączająca na paneladmingamesscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccountEdit() throws IOException {
        App.setRoot("paneladminaccountsscreen");
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
     * Metoda przełączająca na usermainscreen
     * @throws IOException
     */
    @FXML
    private void switchToMyGames() throws IOException {
        App.setRoot("usermainscreen");
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
