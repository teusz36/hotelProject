package org.openjfx;

import javafx.fxml.FXML;

import java.io.IOException;

public class PanelAdminScreenController {

    /**
     * Metoda przełączająca na accountscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccountEdit() throws IOException {
        App.setRoot("paneladminaccountsscreen");
    }


}
