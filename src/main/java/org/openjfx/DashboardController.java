package org.openjfx;

import java.io.IOException;
import java.sql.SQLException;

import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import game.management.CurrentlyPlayedGame;
import game.management.ManageGame;
import game.room.Room;
import game.room.RoomsManagement;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML
    VBox dashboardTabOfferVBoxRoom1;
    @FXML
    Label dashboardTabOfferRoom1YearlyDemand;
    @FXML
    Label dashboardTabOfferRoom1PreferedPrice;
    @FXML
    Label dashboardTabOfferRoom1EmployeeTime;
    @FXML
    Button dashboardTabOfferButtonBuyRoom1;
    @FXML
    VBox dashboardTabOfferVBoxRoom2;
    @FXML
    Label dashboardTabOfferRoom2YearlyDemand;
    @FXML
    Label dashboardTabOfferRoom2PreferedPrice;
    @FXML
    Label dashboardTabOfferRoom2EmployeeTime;
    @FXML
    Button dashboardTabOfferButtonBuyRoom2;

    @FXML
    VBox dashboardTabOfferVBoxQualityChoseRoom1;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom1Price1;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom1Price2;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom1Price3;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom1Buy1;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom1Buy2;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom1Buy3;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom1Cancel;
    @FXML
    VBox dashboardTabOfferVBoxQualityChoseRoom2;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom2Price1;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom2Price2;
    @FXML
    Label dashboardTabOfferVBoxQualityChoseRoom2Price3;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom2Buy1;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom2Buy2;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom2Buy3;
    @FXML
    Button dashboardTabOfferVBoxQualityChoseRoom2Cancel;

    @FXML
    Label dashboardTabOfferTotalPrice;

    @FXML
    Label dashboardTabInfoRoundNumber;

    @FXML
    Label dashboardTabInfoGameId;

    @FXML
    Label dashboardTabInfoIsReady;

    @FXML
    HBox dashboardTabOfferHBoxSeasoningRoom1;
    @FXML
    HBox dashboardTabOfferHBoxSeasoningRoom2;

    int roomsTotalPrice = 0;

    @FXML
    private void initialize() {
        dashboardTabOfferRoom1YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[0].getYearlyDemand()));
        dashboardTabOfferRoom1PreferedPrice.setText(String.valueOf(RoomsManagement.rooms[0].getPreferedPrice()));
        dashboardTabOfferRoom1EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[0].getEmployeeTime()));
        dashboardTabOfferRoom2YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[1].getYearlyDemand()));
        dashboardTabOfferRoom2PreferedPrice.setText(String.valueOf(RoomsManagement.rooms[1].getPreferedPrice()));
        dashboardTabOfferRoom2EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[1].getEmployeeTime()));

        dashboardTabOfferVBoxQualityChoseRoom1Price1.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[0]));
        dashboardTabOfferVBoxQualityChoseRoom1Price2.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[1]));
        dashboardTabOfferVBoxQualityChoseRoom1Price3.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[2]));
        dashboardTabOfferVBoxQualityChoseRoom2Price1.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[0]));
        dashboardTabOfferVBoxQualityChoseRoom2Price2.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[1]));
        dashboardTabOfferVBoxQualityChoseRoom2Price3.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[2]));
        dashboardTabOfferTotalPrice.setText(String.valueOf(roomsTotalPrice));

        dashboardTabInfoRoundNumber.setText("runda " + CurrentlyPlayedGame.getCurrentGame().getCurrentRound());
        dashboardTabInfoGameId.setText(String.valueOf(CurrentlyPlayedGame.getCurrentGame().getGameId()));
        dashboardTabInfoIsReady.setText(String.valueOf(CurrentlyPlayedGame.getCurrentGame().isGameReadyForNextRound()));

        String[] buyRoomButtonsNames = new String[RoomsManagement.rooms.length];
        int buyRoomButtonsNamesIndex = 0;
        for (Room room: RoomsManagement.rooms) {
            if(room.isBought()) {
                buyRoomButtonsNames[buyRoomButtonsNamesIndex] = "ZMIEŃ JAKOŚĆ/SPRZEDAJ POKÓJ";
            } else {
                buyRoomButtonsNames[buyRoomButtonsNamesIndex] = "KUP POKÓJ";
            }
            buyRoomButtonsNamesIndex++;
        }
        dashboardTabOfferButtonBuyRoom1.setText(buyRoomButtonsNames[0]);
        dashboardTabOfferButtonBuyRoom2.setText(buyRoomButtonsNames[1]);

        generateSesonality();
    }

    @FXML
    private void buyRoomButtonClicked(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        int roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 1))) - 1;
        switch (buttonId) {
            case "dashboardTabOfferButtonBuyRoom1":
                dashboardTabOfferVBoxRoom1.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom1.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom1Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom1Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom1Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom1Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom1Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom1Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom2":
                dashboardTabOfferVBoxRoom2.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom2.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom2Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom2Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom2Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom2Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom2Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom2Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
        }
    }

    @FXML
    private void buyRoom(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        int roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 5))) - 1;
        int quality = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 1))) - 1;
        if(RoomsManagement.rooms[roomId].isBought() && RoomsManagement.rooms[roomId].getQualityBought() == quality) {
            roomsTotalPrice -= RoomsManagement.rooms[roomId].getFurnishingPrices()[RoomsManagement.rooms[roomId].getQualityBought()];
            RoomsManagement.rooms[roomId].setBought(false);
            switch (roomId) {
                case 0:
                    dashboardTabOfferButtonBuyRoom1.setText("KUP POKÓJ");
                    break;
                case 1:
                    dashboardTabOfferButtonBuyRoom2.setText("KUP POKÓJ");
                    break;
            }
        } else if(RoomsManagement.rooms[roomId].isBought()) {
            roomsTotalPrice -= RoomsManagement.rooms[roomId].getFurnishingPrices()[RoomsManagement.rooms[roomId].getQualityBought()];
            RoomsManagement.rooms[roomId].setQualityBought(quality);
            roomsTotalPrice += RoomsManagement.rooms[roomId].getFurnishingPrices()[quality];
        } else {
            RoomsManagement.rooms[roomId].setBought(true);
            RoomsManagement.rooms[roomId].setQualityBought(quality);
            roomsTotalPrice += RoomsManagement.rooms[roomId].getFurnishingPrices()[quality];
            switch (roomId) {
                case 0:
                    dashboardTabOfferButtonBuyRoom1.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ POKÓJ");
                    break;
                case 1:
                    dashboardTabOfferButtonBuyRoom2.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ POKÓJ");
                    break;
            }
        }
        dashboardTabOfferTotalPrice.setText(String.valueOf(roomsTotalPrice));
        switchToRoomInfo(roomId);
    }

    @FXML
    private void cancelPurchaseRoomButtonClicked(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        int roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 7)));
        switchToRoomInfo(roomId);
    }

    private void switchToRoomInfo(int roomID) {
        switch (roomID) {
            case 0:
                dashboardTabOfferVBoxQualityChoseRoom1.setVisible(false);
                dashboardTabOfferVBoxRoom1.setVisible(true);
                break;
            case 1:
                dashboardTabOfferVBoxQualityChoseRoom2.setVisible(false);
                dashboardTabOfferVBoxRoom2.setVisible(true);
                break;
        }
    }

    @FXML
    private void generateSesonality() {
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom1VBoxes = dashboardTabOfferHBoxSeasoningRoom1.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom1VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom1VBoxes) {
            double height = 15 * RoomsManagement.rooms[0].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom1VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom1VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom2VBoxes = dashboardTabOfferHBoxSeasoningRoom2.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom2VBoxes) {
            double height = 15 * RoomsManagement.rooms[1].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex++;
        }
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
     * Metoda wylogowująca użytkownika
     */
    @FXML
    private void logout() throws IOException {
        LoginAccount.logOutUser();
        App.setRoot("loginscreen");
    }
}