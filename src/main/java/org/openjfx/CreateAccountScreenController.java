package org.openjfx;

import account.Account;
import account.AccountException;
import account.authentication.LoginAccount;
import account.management.RegisterAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;

public class CreateAccountScreenController {

    @FXML
    private TextArea addUserScreenLogin;

    @FXML
    private PasswordField addUserScreenPassword;

    @FXML
    private TextArea addUserScreenName;

    @FXML
    private TextArea addUserScreenLastName;

    @FXML
    private TextArea addUserScreenEmail;

    @FXML
    private Label addUserError;

    @FXML
    private void addUser() throws SQLException, IOException {
        try {
            RegisterAccount.registerUser(addUserScreenLogin.getText(), addUserScreenName.getText(), addUserScreenLastName.getText(), addUserScreenEmail.getText(), addUserScreenPassword.getText(), Account.PLAYER);
            App.setRoot("paneladminaccountsscreen");
        } catch (AccountException e) {
            addUserError.setText(e.getMessage());
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
     * Metoda wylogowująca użytkownika
     */
    @FXML
    private void logout() throws IOException {
        LoginAccount.logOutUser();
        App.setRoot("loginscreen");
    }
}
