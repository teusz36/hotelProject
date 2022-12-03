package org.openjfx;

import javafx.fxml.FXML;

import java.io.IOException;

public class PanelAdminAccountsScreenController {

    /**
     * Metoda przełączająca na accountscreen
     * @throws IOException
     */
    @FXML
    private void switchToGames() throws IOException {
        App.setRoot("paneladminscreen");
    }


}
