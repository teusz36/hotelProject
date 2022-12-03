package org.openjfx;

import java.io.IOException;
import java.sql.SQLException;


import account.Account;
import account.AccountException;
import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class LoginScreenController {

    @FXML
    private TextArea loginScreenLogin;

    @FXML
    private PasswordField loginScreenPassword;

    @FXML
    private Label loginScreenError;

    /**
     * Metoda wywoływana po naciśnięciu przycisku logowania. Wykonuje ona próbę logowania z danymi pobranymi z pól tekstowych. Wyświetla komunikat, jeśli logowanie się nie powiodło.
     */
    @FXML
    private void loginAttempt() {
        try {
            LoginAccount.logInUser(loginScreenLogin.getText(), loginScreenPassword.getText());
            if(LoggedInAccount.getLoggedInAccount().getAccountType() == Account.GAME_ADMIN) {
                App.setRoot("paneladminscreen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (AccountException e) {
            loginScreenError.setText(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
