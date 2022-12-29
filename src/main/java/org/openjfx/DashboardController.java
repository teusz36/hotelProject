package org.openjfx;

import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML VBox dashboardTabOfferVBoxRoom1;
    @FXML Label dashboardTabOfferRoom1YearlyDemand;
    @FXML Label dashboardTabOfferRoom1PreferredPrice;
    @FXML Label dashboardTabOfferRoom1EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom1;
    @FXML VBox dashboardTabOfferVBoxRoom2;
    @FXML Label dashboardTabOfferRoom2YearlyDemand;
    @FXML Label dashboardTabOfferRoom2PreferredPrice;
    @FXML Label dashboardTabOfferRoom2EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom2;
    @FXML VBox dashboardTabOfferVBoxRoom3;
    @FXML Label dashboardTabOfferRoom3YearlyDemand;
    @FXML Label dashboardTabOfferRoom3PreferredPrice;
    @FXML Label dashboardTabOfferRoom3EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom3;
    @FXML VBox dashboardTabOfferVBoxRoom4;
    @FXML Label dashboardTabOfferRoom4YearlyDemand;
    @FXML Label dashboardTabOfferRoom4PreferredPrice;
    @FXML Label dashboardTabOfferRoom4EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom4;
    @FXML VBox dashboardTabOfferVBoxRoom5;
    @FXML Label dashboardTabOfferRoom5YearlyDemand;
    @FXML Label dashboardTabOfferRoom5PreferredPrice;
    @FXML Label dashboardTabOfferRoom5EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom5;
    @FXML VBox dashboardTabOfferVBoxRoom6;
    @FXML Label dashboardTabOfferRoom6YearlyDemand;
    @FXML Label dashboardTabOfferRoom6PreferredPrice;
    @FXML Label dashboardTabOfferRoom6EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom6;
    @FXML VBox dashboardTabOfferVBoxRoom7;
    @FXML Label dashboardTabOfferRoom7YearlyDemand;
    @FXML Label dashboardTabOfferRoom7PreferredPrice;
    @FXML Label dashboardTabOfferRoom7EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom7;
    @FXML VBox dashboardTabOfferVBoxRoom8;
    @FXML Label dashboardTabOfferRoom8YearlyDemand;
    @FXML Label dashboardTabOfferRoom8PreferredPrice;
    @FXML Label dashboardTabOfferRoom8EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom8;
    @FXML VBox dashboardTabOfferVBoxRoom9;
    @FXML Label dashboardTabOfferRoom9YearlyDemand;
    @FXML Label dashboardTabOfferRoom9PreferredPrice;
    @FXML Label dashboardTabOfferRoom9EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom9;
    @FXML VBox dashboardTabOfferVBoxRoom10;
    @FXML Label dashboardTabOfferRoom10YearlyDemand;
    @FXML Label dashboardTabOfferRoom10PreferredPrice;
    @FXML Label dashboardTabOfferRoom10EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom10;
    @FXML VBox dashboardTabOfferVBoxRoom11;
    @FXML Label dashboardTabOfferRoom11YearlyDemand;
    @FXML Label dashboardTabOfferRoom11PreferredPrice;
    @FXML Label dashboardTabOfferRoom11EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom11;
    @FXML VBox dashboardTabOfferVBoxRoom12;
    @FXML Label dashboardTabOfferRoom12YearlyDemand;
    @FXML Label dashboardTabOfferRoom12PreferredPrice;
    @FXML Label dashboardTabOfferRoom12EmployeeTime;
    @FXML Button dashboardTabOfferButtonBuyRoom12;

    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom1Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom1Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom1Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom1Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom1Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom1Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom1Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom2Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom2Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom2Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom2Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom2Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom2Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom2Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom3;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom3Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom3Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom3Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom3Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom3Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom3Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom3Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom4;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom4Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom4Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom4Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom4Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom4Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom4Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom4Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom5;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom5Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom5Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom5Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom5Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom5Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom5Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom5Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom6;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom6Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom6Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom6Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom6Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom6Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom6Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom6Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom7;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom7Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom7Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom7Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom7Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom7Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom7Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom7Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom8;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom8Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom8Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom8Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom8Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom8Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom8Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom8Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom9;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom9Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom9Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom9Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom9Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom9Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom9Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom9Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom10;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom10Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom10Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom10Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom10Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom10Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom10Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom10Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom11;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom11Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom11Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom11Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom11Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom11Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom11Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom11Cancel;
    @FXML VBox dashboardTabOfferVBoxQualityChoseRoom12;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom12Price1;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom12Price2;
    @FXML Label dashboardTabOfferVBoxQualityChoseRoom12Price3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom12Buy1;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom12Buy2;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom12Buy3;
    @FXML Button dashboardTabOfferVBoxQualityChoseRoom12Cancel;

    @FXML Label dashboardTabOfferTotalPrice;
    @FXML Label dashboardTabInfoRoundNumber;
    @FXML Label dashboardTabInfoGameId;
    @FXML Label dashboardTabInfoIsReady;
    @FXML ImageView dashboardTabInfoLogo;
    @FXML Label dashboardTabInfoLogoLabel;
    @FXML TextArea dashboardTabInfoCompanyName;
    @FXML TextArea dashboardTabInfoCompanyMission;

    @FXML HBox dashboardTabOfferHBoxSeasoningRoom1;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom2;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom3;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom4;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom5;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom6;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom7;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom8;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom9;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom10;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom11;
    @FXML HBox dashboardTabOfferHBoxSeasoningRoom12;

    @FXML Pane dashboardTabOfferPaneRoom1;
    @FXML Pane dashboardTabOfferPaneRoom2;
    @FXML Pane dashboardTabOfferPaneRoom3;
    @FXML Pane dashboardTabOfferPaneRoom4;
    @FXML Pane dashboardTabOfferPaneRoom5;
    @FXML Pane dashboardTabOfferPaneRoom6;
    @FXML Pane dashboardTabOfferPaneRoom7;
    @FXML Pane dashboardTabOfferPaneRoom8;
    @FXML Pane dashboardTabOfferPaneRoom9;
    @FXML Pane dashboardTabOfferPaneRoom10;
    @FXML Pane dashboardTabOfferPaneRoom11;
    @FXML Pane dashboardTabOfferPaneRoom12;

    @FXML HBox dashboardTabOfferHBoxTitle2;
    @FXML HBox dashboardTabOfferHBoxTitle3;

    int roomsTotalPrice = 0;

    @FXML
    private void initialize() {
        initializeRoomsInfo();
    }

    /**
     * Metoda generująca informacje o pokojach.
     */
    @FXML
    private void initializeRoomsInfo() {
        try {
            dashboardTabOfferRoom1YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[0].getYearlyDemand()));
            dashboardTabOfferRoom1PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[0].getPreferredPrice()));
            dashboardTabOfferRoom1EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[0].getEmployeeTime()));
            dashboardTabOfferRoom2YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[1].getYearlyDemand()));
            dashboardTabOfferRoom2PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[1].getPreferredPrice()));
            dashboardTabOfferRoom2EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[1].getEmployeeTime()));
            dashboardTabOfferRoom3YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[2].getYearlyDemand()));
            dashboardTabOfferRoom3PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[2].getPreferredPrice()));
            dashboardTabOfferRoom3EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[2].getEmployeeTime()));
            dashboardTabOfferRoom4YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[3].getYearlyDemand()));
            dashboardTabOfferRoom4PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[3].getPreferredPrice()));
            dashboardTabOfferRoom4EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[3].getEmployeeTime()));
            dashboardTabOfferRoom5YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[4].getYearlyDemand()));
            dashboardTabOfferRoom5PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[4].getPreferredPrice()));
            dashboardTabOfferRoom5EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[4].getEmployeeTime()));
            dashboardTabOfferRoom6YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[5].getYearlyDemand()));
            dashboardTabOfferRoom6PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[5].getPreferredPrice()));
            dashboardTabOfferRoom6EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[5].getEmployeeTime()));
            dashboardTabOfferRoom7YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[6].getYearlyDemand()));
            dashboardTabOfferRoom7PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[6].getPreferredPrice()));
            dashboardTabOfferRoom7EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[6].getEmployeeTime()));
            dashboardTabOfferRoom8YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[7].getYearlyDemand()));
            dashboardTabOfferRoom8PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[7].getPreferredPrice()));
            dashboardTabOfferRoom8EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[7].getEmployeeTime()));
            dashboardTabOfferRoom9YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[8].getYearlyDemand()));
            dashboardTabOfferRoom9PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[8].getPreferredPrice()));
            dashboardTabOfferRoom9EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[8].getEmployeeTime()));
            dashboardTabOfferRoom10YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[9].getYearlyDemand()));
            dashboardTabOfferRoom10PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[9].getPreferredPrice()));
            dashboardTabOfferRoom10EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[9].getEmployeeTime()));
            dashboardTabOfferRoom11YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[10].getYearlyDemand()));
            dashboardTabOfferRoom11PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[10].getPreferredPrice()));
            dashboardTabOfferRoom11EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[10].getEmployeeTime()));
            dashboardTabOfferRoom12YearlyDemand.setText(String.valueOf(RoomsManagement.rooms[11].getYearlyDemand()));
            dashboardTabOfferRoom12PreferredPrice.setText(String.valueOf(RoomsManagement.rooms[11].getPreferredPrice()));
            dashboardTabOfferRoom12EmployeeTime.setText(String.valueOf(RoomsManagement.rooms[11].getEmployeeTime()));

            dashboardTabOfferVBoxQualityChoseRoom1Price1.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[0].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom1Price2.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[0].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom1Price3.setText(String.valueOf(RoomsManagement.rooms[0].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[0].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom2Price1.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[1].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom2Price2.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[1].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom2Price3.setText(String.valueOf(RoomsManagement.rooms[1].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[1].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom3Price1.setText(String.valueOf(RoomsManagement.rooms[2].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[2].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom3Price2.setText(String.valueOf(RoomsManagement.rooms[2].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[2].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom3Price3.setText(String.valueOf(RoomsManagement.rooms[2].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[2].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom4Price1.setText(String.valueOf(RoomsManagement.rooms[3].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[3].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom4Price2.setText(String.valueOf(RoomsManagement.rooms[3].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[3].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom4Price3.setText(String.valueOf(RoomsManagement.rooms[3].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[3].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom5Price1.setText(String.valueOf(RoomsManagement.rooms[4].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[4].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom5Price2.setText(String.valueOf(RoomsManagement.rooms[4].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[4].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom5Price3.setText(String.valueOf(RoomsManagement.rooms[4].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[4].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom6Price1.setText(String.valueOf(RoomsManagement.rooms[5].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[5].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom6Price2.setText(String.valueOf(RoomsManagement.rooms[5].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[5].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom6Price3.setText(String.valueOf(RoomsManagement.rooms[5].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[5].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferTotalPrice.setText(String.valueOf(roomsTotalPrice));

            dashboardTabOfferVBoxQualityChoseRoom7Price1.setText(String.valueOf(RoomsManagement.rooms[6].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[6].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom7Price2.setText(String.valueOf(RoomsManagement.rooms[6].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[6].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom7Price3.setText(String.valueOf(RoomsManagement.rooms[6].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[6].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom8Price1.setText(String.valueOf(RoomsManagement.rooms[7].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[7].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom8Price2.setText(String.valueOf(RoomsManagement.rooms[7].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[7].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom8Price3.setText(String.valueOf(RoomsManagement.rooms[7].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[7].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom9Price1.setText(String.valueOf(RoomsManagement.rooms[8].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[8].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom9Price2.setText(String.valueOf(RoomsManagement.rooms[8].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[8].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom9Price3.setText(String.valueOf(RoomsManagement.rooms[8].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[8].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom10Price1.setText(String.valueOf(RoomsManagement.rooms[9].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[9].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom10Price2.setText(String.valueOf(RoomsManagement.rooms[9].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[9].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom10Price3.setText(String.valueOf(RoomsManagement.rooms[9].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[9].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom11Price1.setText(String.valueOf(RoomsManagement.rooms[10].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[10].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom11Price2.setText(String.valueOf(RoomsManagement.rooms[10].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[10].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom11Price3.setText(String.valueOf(RoomsManagement.rooms[10].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[10].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom12Price1.setText(String.valueOf(RoomsManagement.rooms[11].getFurnishingPrices()[0]) + "  (" + String.valueOf(RoomsManagement.rooms[11].getOfficeFurnishingPrices()[0]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom12Price2.setText(String.valueOf(RoomsManagement.rooms[11].getFurnishingPrices()[1]) + "  (" + String.valueOf(RoomsManagement.rooms[11].getOfficeFurnishingPrices()[1]) + ")");
            dashboardTabOfferVBoxQualityChoseRoom12Price3.setText(String.valueOf(RoomsManagement.rooms[11].getFurnishingPrices()[2]) + "  (" + String.valueOf(RoomsManagement.rooms[11].getOfficeFurnishingPrices()[2]) + ")");
            dashboardTabOfferTotalPrice.setText(String.valueOf(roomsTotalPrice));



            String[] buyRoomButtonsNames = new String[RoomsManagement.rooms.length];
            int buyRoomButtonsNamesIndex = 0;
            for (Room room : RoomsManagement.rooms) {
                if (room.isBought()) {
                    buyRoomButtonsNames[buyRoomButtonsNamesIndex] = "ZMIEŃ JAKOŚĆ/SPRZEDAJ";
                } else {
                    buyRoomButtonsNames[buyRoomButtonsNamesIndex] = "KUP POKÓJ";
                }
                buyRoomButtonsNamesIndex++;
            }
            dashboardTabOfferButtonBuyRoom1.setText(buyRoomButtonsNames[0]);
            dashboardTabOfferButtonBuyRoom2.setText(buyRoomButtonsNames[1]);
            dashboardTabOfferButtonBuyRoom3.setText(buyRoomButtonsNames[2]);
            dashboardTabOfferButtonBuyRoom4.setText(buyRoomButtonsNames[3]);
            dashboardTabOfferButtonBuyRoom5.setText(buyRoomButtonsNames[4]);
            dashboardTabOfferButtonBuyRoom6.setText(buyRoomButtonsNames[5]);
            dashboardTabOfferButtonBuyRoom7.setText(buyRoomButtonsNames[6]);
            dashboardTabOfferButtonBuyRoom8.setText(buyRoomButtonsNames[7]);
            dashboardTabOfferButtonBuyRoom9.setText(buyRoomButtonsNames[8]);
            dashboardTabOfferButtonBuyRoom10.setText(buyRoomButtonsNames[9]);
            dashboardTabOfferButtonBuyRoom11.setText(buyRoomButtonsNames[10]);
            dashboardTabOfferButtonBuyRoom12.setText(buyRoomButtonsNames[11]);

            generateSeasonality();


            dashboardTabOfferPaneRoom1.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[0].getStartRound());
            dashboardTabOfferPaneRoom2.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[1].getStartRound());
            dashboardTabOfferPaneRoom3.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[2].getStartRound());
            dashboardTabOfferPaneRoom4.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[3].getStartRound());
            dashboardTabOfferPaneRoom5.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[4].getStartRound());
            dashboardTabOfferPaneRoom6.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[5].getStartRound());
            dashboardTabOfferPaneRoom7.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[6].getStartRound());
            dashboardTabOfferPaneRoom8.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[7].getStartRound());
            dashboardTabOfferPaneRoom9.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[8].getStartRound());
            dashboardTabOfferPaneRoom10.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[9].getStartRound());
            dashboardTabOfferPaneRoom11.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[10].getStartRound());
            dashboardTabOfferPaneRoom12.setVisible(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= RoomsManagement.rooms[11].getStartRound());

            if(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() >= 4) {
                dashboardTabOfferHBoxTitle2.setVisible(true);
                dashboardTabOfferHBoxTitle3.setVisible(true);
            } else {
                dashboardTabOfferHBoxTitle2.setVisible(false);
                dashboardTabOfferHBoxTitle3.setVisible(false);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metoda wykonywana po naciśnięciu przycisku przejścia do listy cen wybranego pokoju. Zmienia ona wyświetlany panel z panelu ogólnych informacji o pokoju na panel z cenami za pokój zależnymi od jakości.
     * @param event
     */
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
            case "dashboardTabOfferButtonBuyRoom3":
                dashboardTabOfferVBoxRoom3.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom3.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom3Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom3Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom3Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom3Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom3Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom3Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom4":
                dashboardTabOfferVBoxRoom4.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom4.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom4Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom4Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom4Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom4Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom4Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom4Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom5":
                dashboardTabOfferVBoxRoom5.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom5.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom5Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom5Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom5Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom5Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom5Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom5Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom6":
                dashboardTabOfferVBoxRoom6.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom6.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom6Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom6Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom6Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom6Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom6Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom6Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom7":
                dashboardTabOfferVBoxRoom7.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom7.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom7Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom7Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom7Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom7Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom7Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom7Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom8":
                dashboardTabOfferVBoxRoom8.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom8.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom8Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom8Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom8Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom8Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom8Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom8Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom9":
                dashboardTabOfferVBoxRoom9.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom9.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom9Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom9Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom9Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom9Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom9Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom9Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom10":
                roomId = 9;
                dashboardTabOfferVBoxRoom10.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom10.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom10Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom10Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom10Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom10Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom10Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom10Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom11":
                roomId = 10;
                dashboardTabOfferVBoxRoom11.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom11.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom11Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom11Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom11Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom11Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom11Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom11Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
            case "dashboardTabOfferButtonBuyRoom12":
                roomId = 11;
                dashboardTabOfferVBoxRoom12.setVisible(false);
                dashboardTabOfferVBoxQualityChoseRoom12.setVisible(true);
                dashboardTabOfferVBoxQualityChoseRoom12Buy1.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom12Buy2.setText("KUP");
                dashboardTabOfferVBoxQualityChoseRoom12Buy3.setText("KUP");
                if(RoomsManagement.rooms[roomId].isBought()) {
                    switch (RoomsManagement.rooms[roomId].getQualityBought()) {
                        case 0:
                            dashboardTabOfferVBoxQualityChoseRoom12Buy1.setText("SPRZEDAJ");
                            break;
                        case 1:
                            dashboardTabOfferVBoxQualityChoseRoom12Buy2.setText("SPRZEDAJ");
                            break;
                        case 2:
                            dashboardTabOfferVBoxQualityChoseRoom12Buy3.setText("SPRZEDAJ");
                            break;
                    }
                }
                break;
        }
    }

    /**
     * Metoda wykonywana po naciśnięciu jednego z trzech przycisków zakupu pokoju. Sprawdza, czy pokój został już zakupiony i aktualizuje jakość, lub sprzedaje pokój zależnie od naciśniętego przycisku.
     * @param event
     */
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
                case 2:
                    dashboardTabOfferButtonBuyRoom3.setText("KUP POKÓJ");
                    break;
                case 3:
                    dashboardTabOfferButtonBuyRoom4.setText("KUP POKÓJ");
                    break;
                case 4:
                    dashboardTabOfferButtonBuyRoom5.setText("KUP POKÓJ");
                    break;
                case 5:
                    dashboardTabOfferButtonBuyRoom6.setText("KUP POKÓJ");
                    break;
                case 6:
                    dashboardTabOfferButtonBuyRoom7.setText("KUP POKÓJ");
                    break;
                case 7:
                    dashboardTabOfferButtonBuyRoom8.setText("KUP POKÓJ");
                    break;
                case 8:
                    dashboardTabOfferButtonBuyRoom9.setText("KUP POKÓJ");
                    break;
                case 9:
                    dashboardTabOfferButtonBuyRoom10.setText("KUP POKÓJ");
                    break;
                case 10:
                    dashboardTabOfferButtonBuyRoom11.setText("KUP POKÓJ");
                    break;
                case 11:
                    dashboardTabOfferButtonBuyRoom12.setText("KUP POKÓJ");
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
                    dashboardTabOfferButtonBuyRoom1.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 1:
                    dashboardTabOfferButtonBuyRoom2.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 2:
                    dashboardTabOfferButtonBuyRoom3.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 3:
                    dashboardTabOfferButtonBuyRoom4.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 4:
                    dashboardTabOfferButtonBuyRoom5.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 5:
                    dashboardTabOfferButtonBuyRoom6.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 6:
                    dashboardTabOfferButtonBuyRoom7.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 7:
                    dashboardTabOfferButtonBuyRoom8.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 8:
                    dashboardTabOfferButtonBuyRoom9.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 9:
                    dashboardTabOfferButtonBuyRoom10.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 10:
                    dashboardTabOfferButtonBuyRoom11.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
                case 11:
                    dashboardTabOfferButtonBuyRoom12.setText("ZMIEŃ JAKOŚĆ/SPRZEDAJ");
                    break;
            }
        }
        dashboardTabOfferTotalPrice.setText(String.valueOf(roomsTotalPrice));
        switchToRoomInfo(roomId);
    }

    /**
     * Metoda wykonywana po naciśnięciu przycisku anulowania zakupu pokoju. Zmienia ona wyświetlany panel z cenami za pokój zależnymi od jakości na panel z ogólnymi informacjami o pokoju.
     * @param event
     */
    @FXML
    private void cancelPurchaseRoomButtonClicked(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        int roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 7)));
        if(buttonId.equals("dashboardTabOfferVBoxQualityChoseRoom10Cancel")) {
            roomId = 10;
        } else if(buttonId.equals("dashboardTabOfferVBoxQualityChoseRoom11Cancel")) {
            roomId = 11;
        } else if(buttonId.equals("dashboardTabOfferVBoxQualityChoseRoom12Cancel")) {
            roomId = 12;
        }
        switchToRoomInfo(roomId - 1);
    }

    /**
     * Metoda przełączająca panel oferty na panel z informacjami ogólnymi o niej.
     * @param roomID
     */
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
            case 2:
                dashboardTabOfferVBoxQualityChoseRoom3.setVisible(false);
                dashboardTabOfferVBoxRoom3.setVisible(true);
                break;
            case 3:
                dashboardTabOfferVBoxQualityChoseRoom4.setVisible(false);
                dashboardTabOfferVBoxRoom4.setVisible(true);
                break;
            case 4:
                dashboardTabOfferVBoxQualityChoseRoom5.setVisible(false);
                dashboardTabOfferVBoxRoom5.setVisible(true);
                break;
            case 5:
                dashboardTabOfferVBoxQualityChoseRoom6.setVisible(false);
                dashboardTabOfferVBoxRoom6.setVisible(true);
                break;
            case 6:
                dashboardTabOfferVBoxQualityChoseRoom7.setVisible(false);
                dashboardTabOfferVBoxRoom7.setVisible(true);
                break;
            case 7:
                dashboardTabOfferVBoxQualityChoseRoom8.setVisible(false);
                dashboardTabOfferVBoxRoom8.setVisible(true);
                break;
            case 8:
                dashboardTabOfferVBoxQualityChoseRoom9.setVisible(false);
                dashboardTabOfferVBoxRoom9.setVisible(true);
                break;
            case 9:
                dashboardTabOfferVBoxQualityChoseRoom10.setVisible(false);
                dashboardTabOfferVBoxRoom10.setVisible(true);
                break;
            case 10:
                dashboardTabOfferVBoxQualityChoseRoom11.setVisible(false);
                dashboardTabOfferVBoxRoom11.setVisible(true);
                break;
            case 11:
                dashboardTabOfferVBoxQualityChoseRoom12.setVisible(false);
                dashboardTabOfferVBoxRoom12.setVisible(true);
                break;
        }
    }

    /**
     * Metoda generująca wykresy sezonowości w zakładce oferta.
     */
    @FXML
    private void generateSeasonality() {
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
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom3VBoxes = dashboardTabOfferHBoxSeasoningRoom3.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom3VBoxes) {
            double height = 15 * RoomsManagement.rooms[2].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom4VBoxes = dashboardTabOfferHBoxSeasoningRoom4.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom4VBoxes) {
            double height = 15 * RoomsManagement.rooms[3].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom5VBoxes = dashboardTabOfferHBoxSeasoningRoom5.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom5VBoxes) {
            double height = 15 * RoomsManagement.rooms[4].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom6VBoxes = dashboardTabOfferHBoxSeasoningRoom6.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom6VBoxes) {
            double height = 15 * RoomsManagement.rooms[5].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex++;
        }

        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom7VBoxes = dashboardTabOfferHBoxSeasoningRoom7.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom7VBoxes) {
            double height = 15 * RoomsManagement.rooms[6].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom8VBoxes = dashboardTabOfferHBoxSeasoningRoom8.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom8VBoxes) {
            double height = 15 * RoomsManagement.rooms[7].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom9VBoxes = dashboardTabOfferHBoxSeasoningRoom9.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom9VBoxes) {
            double height = 15 * RoomsManagement.rooms[8].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom10VBoxes = dashboardTabOfferHBoxSeasoningRoom10.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom10VBoxes) {
            double height = 15 * RoomsManagement.rooms[9].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom11VBoxes = dashboardTabOfferHBoxSeasoningRoom11.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom11VBoxes) {
            double height = 15 * RoomsManagement.rooms[10].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom12VBoxes = dashboardTabOfferHBoxSeasoningRoom12.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom12VBoxes) {
            double height = 15 * RoomsManagement.rooms[11].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex++;
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
     * Metoda, która pozwala na wybór pliku i wybranie go jako logo.
     */
    @FXML
    private void fileSelection(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Logo for your Company");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
        File selectedFileInput = selectedFile;

        if(selectedFile != null) {
            dashboardTabInfoLogoLabel.setText("Zostało Wybrane Logo:");
            Image image = new Image(selectedFile.toURI().toString(), 240, 240, true, true,true);
            dashboardTabInfoLogo.setImage(image);
        } else {
            dashboardTabInfoLogoLabel.setText("Wybierz Logo Firmy");
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