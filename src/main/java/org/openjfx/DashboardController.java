package org.openjfx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import game.Player;
import game.bank.Credit;
import game.bank.Deposit;
import game.bank.ManageBanks;
import game.management.CurrentlyPlayedGame;
import game.management.ManageGame;
import game.resources.ManageResources;
import game.room.Room;
import game.room.RoomsManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jdbc.Connect;

import static jdbc.DataManager.executeQuery;

public class DashboardController {

    @FXML Tab dashboardTab;
    @FXML Tab infoTab;
    @FXML Tab offerTab;
    @FXML Tab resourcesTab;
    @FXML Tab officesTab;
    @FXML Tab bankTab;
    @FXML Tab accountingTab;
    @FXML Tab saleTab;
    @FXML Tab resultsTab;
    @FXML Tab readyTab;

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

    @FXML Label dashboardTabOfferBalance;
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

    @FXML Label dashboardTabBankSelectBank1Label;
    @FXML Label dashboardTabBankSelectBank2Label;
    @FXML Label dashboardTabBankSelectBank3Label;

    @FXML Label dashboardTabBankSelectBank1value1;
    @FXML Label dashboardTabBankSelectBank1value2;
    @FXML Label dashboardTabBankSelectBank1value3;
    @FXML Label dashboardTabBankSelectBank1value4;
    @FXML Label dashboardTabBankSelectBank1value5;

    @FXML Label dashboardTabBankSelectBank2value1;
    @FXML Label dashboardTabBankSelectBank2value2;
    @FXML Label dashboardTabBankSelectBank2value3;
    @FXML Label dashboardTabBankSelectBank2value4;
    @FXML Label dashboardTabBankSelectBank2value5;

    @FXML Label dashboardTabBankSelectBank3value1;
    @FXML Label dashboardTabBankSelectBank3value2;
    @FXML Label dashboardTabBankSelectBank3value3;
    @FXML Label dashboardTabBankSelectBank3value4;
    @FXML Label dashboardTabBankSelectBank3value5;

    @FXML Label dashboardTabBankName;
    @FXML Label dashboardTabBankBalance;
    @FXML HBox dashboardTabBankHBoxSelect;
    @FXML VBox dashboardTabBankVBoxInfo;
    @FXML Label dashboardTabBankDepositInterestRate;
    @FXML Label dashboardTabBankCreditInterestRate;
    @FXML Label dashboardTabBankRevolvingCreditInterestRate;
    @FXML TableView dashboardTabBankTableViewDeposit;

    @FXML VBox dashboardTabBankDepositPopUpScreen;
    @FXML Label dashboardTabBankDepositPopUpX;
    @FXML Label dashboardTabBankDepositPopUpBalance;
    @FXML Label dashboardTabBankDepositPopUpInitialRate;
    @FXML Slider dashboardTabBankDepositPopUpDepositTimeSlider;
    @FXML Label dashboardTabBankDepositPopUpDepositTimeMax;
    @FXML TextField dashboardTabBankDepositPopUpDepositValue;
    @FXML Button dashboardTabBankDepositPopUpCancel;
    @FXML Button dashboardTabBankDepositPopUpCreate;
    @FXML TableView dashboardTabBankTableViewCredit;
    @FXML VBox dashboardTabBankCreditPopUpScreen;
    @FXML Label dashboardTabBankCreditPopUpX;
    @FXML Slider dashboardTabBankCreditPopUpCreditTimeSlider;
    @FXML Label dashboardTabBankCreditPopUpCreditTimeMax;
    @FXML Label dashboardTabBankCreditPopUpInitialRate;
    @FXML TextField dashboardTabBankCreditPopUpCreditValue;
    @FXML Button dashboardTabBankCreditPopUpCancel;
    @FXML Button dashboardTabBankCreditPopUpCreate;
    @FXML Button dashboardTabBankGetCreditButton;
    @FXML Label dashboardTabBankRevolvingCreditAmount;

    @FXML Label dashboardTabResourcesBalance;
    @FXML HBox dashboardTabResourcesHBoxTitle1;
    @FXML HBox dashboardTabResourcesHBoxTitle2;
    @FXML HBox dashboardTabResourcesHBoxTitle3;
    @FXML Label dashboardTabResourcesVBoxRoom1Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom2Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom3Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom4Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom5Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom6Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom7Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom8Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom9Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom10Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom11Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom12Quality1StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom1Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom2Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom3Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom4Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom5Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom6Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom7Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom8Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom9Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom10Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom11Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom12Quality2StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom1Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom2Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom3Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom4Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom5Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom6Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom7Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom8Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom9Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom10Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom11Quality3StorageAmount;
    @FXML Label dashboardTabResourcesVBoxRoom12Quality3StorageAmount;
    @FXML Pane dashboardTabResourcesPaneRoom1;
    @FXML Pane dashboardTabResourcesPaneRoom2;
    @FXML Pane dashboardTabResourcesPaneRoom3;
    @FXML Pane dashboardTabResourcesPaneRoom4;
    @FXML Pane dashboardTabResourcesPaneRoom5;
    @FXML Pane dashboardTabResourcesPaneRoom6;
    @FXML Pane dashboardTabResourcesPaneRoom7;
    @FXML Pane dashboardTabResourcesPaneRoom8;
    @FXML Pane dashboardTabResourcesPaneRoom9;
    @FXML Pane dashboardTabResourcesPaneRoom10;
    @FXML Pane dashboardTabResourcesPaneRoom11;
    @FXML Pane dashboardTabResourcesPaneRoom12;
    @FXML Label dashboardTabResourcesVBoxRoom1Price1;
    @FXML Label dashboardTabResourcesVBoxRoom2Price1;
    @FXML Label dashboardTabResourcesVBoxRoom3Price1;
    @FXML Label dashboardTabResourcesVBoxRoom4Price1;
    @FXML Label dashboardTabResourcesVBoxRoom5Price1;
    @FXML Label dashboardTabResourcesVBoxRoom6Price1;
    @FXML Label dashboardTabResourcesVBoxRoom7Price1;
    @FXML Label dashboardTabResourcesVBoxRoom8Price1;
    @FXML Label dashboardTabResourcesVBoxRoom9Price1;
    @FXML Label dashboardTabResourcesVBoxRoom10Price1;
    @FXML Label dashboardTabResourcesVBoxRoom11Price1;
    @FXML Label dashboardTabResourcesVBoxRoom12Price1;
    @FXML Label dashboardTabResourcesVBoxRoom1Price2;
    @FXML Label dashboardTabResourcesVBoxRoom2Price2;
    @FXML Label dashboardTabResourcesVBoxRoom3Price2;
    @FXML Label dashboardTabResourcesVBoxRoom4Price2;
    @FXML Label dashboardTabResourcesVBoxRoom5Price2;
    @FXML Label dashboardTabResourcesVBoxRoom6Price2;
    @FXML Label dashboardTabResourcesVBoxRoom7Price2;
    @FXML Label dashboardTabResourcesVBoxRoom8Price2;
    @FXML Label dashboardTabResourcesVBoxRoom9Price2;
    @FXML Label dashboardTabResourcesVBoxRoom10Price2;
    @FXML Label dashboardTabResourcesVBoxRoom11Price2;
    @FXML Label dashboardTabResourcesVBoxRoom12Price2;
    @FXML Label dashboardTabResourcesVBoxRoom1Price3;
    @FXML Label dashboardTabResourcesVBoxRoom2Price3;
    @FXML Label dashboardTabResourcesVBoxRoom3Price3;
    @FXML Label dashboardTabResourcesVBoxRoom4Price3;
    @FXML Label dashboardTabResourcesVBoxRoom5Price3;
    @FXML Label dashboardTabResourcesVBoxRoom6Price3;
    @FXML Label dashboardTabResourcesVBoxRoom7Price3;
    @FXML Label dashboardTabResourcesVBoxRoom8Price3;
    @FXML Label dashboardTabResourcesVBoxRoom9Price3;
    @FXML Label dashboardTabResourcesVBoxRoom10Price3;
    @FXML Label dashboardTabResourcesVBoxRoom11Price3;
    @FXML Label dashboardTabResourcesVBoxRoom12Price3;
    @FXML TextField dashboardTabResourcesRoom1PriceTextField;
    @FXML TextField dashboardTabResourcesRoom2PriceTextField;
    @FXML TextField dashboardTabResourcesRoom3PriceTextField;
    @FXML TextField dashboardTabResourcesRoom4PriceTextField;
    @FXML TextField dashboardTabResourcesRoom5PriceTextField;
    @FXML TextField dashboardTabResourcesRoom6PriceTextField;
    @FXML TextField dashboardTabResourcesRoom7PriceTextField;
    @FXML TextField dashboardTabResourcesRoom8PriceTextField;
    @FXML TextField dashboardTabResourcesRoom9PriceTextField;
    @FXML TextField dashboardTabResourcesRoom10PriceTextField;
    @FXML TextField dashboardTabResourcesRoom11PriceTextField;
    @FXML TextField dashboardTabResourcesRoom12PriceTextField;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom1QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom2QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom3QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom4QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom5QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom6QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom7QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom8QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom9QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom10QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom11QualityChoiceBox;
    @FXML ChoiceBox<String> dashboardTabResourcesRoom12QualityChoiceBox;
    @FXML Label dashboardTabResourcesSetPrice1;
    @FXML Label dashboardTabResourcesSetPrice2;
    @FXML Label dashboardTabResourcesSetPrice3;
    @FXML Label dashboardTabResourcesSetPrice4;
    @FXML Label dashboardTabResourcesSetPrice5;
    @FXML Label dashboardTabResourcesSetPrice6;
    @FXML Label dashboardTabResourcesSetPrice7;
    @FXML Label dashboardTabResourcesSetPrice8;
    @FXML Label dashboardTabResourcesSetPrice9;
    @FXML Label dashboardTabResourcesSetPrice10;
    @FXML Label dashboardTabResourcesSetPrice11;
    @FXML Label dashboardTabResourcesSetPrice12;
    @FXML HBox dashboardTabResourcesHBoxSet1;
    @FXML HBox dashboardTabResourcesHBoxSet2;
    @FXML HBox dashboardTabResourcesHBoxSet3;
    @FXML HBox dashboardTabResourcesHBoxSet4;

    @FXML Label dashboardTabDashboardBalance;
    @FXML ImageView dashboardTabDashboardImage;
    @FXML Label dashboardTabDashboardName;
    @FXML Label dashboardTabDashboardRank;
    @FXML Label dashboardTabDashboardRoundNumber;

    @FXML Pane saleTabRoom1Pane;
    @FXML Pane saleTabRoom2Pane;
    @FXML Pane saleTabRoom3Pane;
    @FXML Pane saleTabRoom4Pane;
    @FXML Pane saleTabRoom5Pane;
    @FXML Pane saleTabRoom6Pane;
    @FXML Pane saleTabRoom7Pane;
    @FXML Pane saleTabRoom8Pane;
    @FXML Pane saleTabRoom9Pane;
    @FXML Pane saleTabRoom10Pane;
    @FXML Pane saleTabRoom11Pane;
    @FXML Pane saleTabRoom12Pane;
    @FXML Label saleTabRoom1Name;
    @FXML Label saleTabRoom2Name;
    @FXML Label saleTabRoom3Name;
    @FXML Label saleTabRoom4Name;
    @FXML Label saleTabRoom5Name;
    @FXML Label saleTabRoom6Name;
    @FXML Label saleTabRoom7Name;
    @FXML Label saleTabRoom8Name;
    @FXML Label saleTabRoom9Name;
    @FXML Label saleTabRoom10Name;
    @FXML Label saleTabRoom11Name;
    @FXML Label saleTabRoom12Name;
    @FXML Label saleTabRoom1PreferredPriceLabel;
    @FXML Label saleTabRoom2PreferredPriceLabel;
    @FXML Label saleTabRoom3PreferredPriceLabel;
    @FXML Label saleTabRoom4PreferredPriceLabel;
    @FXML Label saleTabRoom5PreferredPriceLabel;
    @FXML Label saleTabRoom6PreferredPriceLabel;
    @FXML Label saleTabRoom7PreferredPriceLabel;
    @FXML Label saleTabRoom8PreferredPriceLabel;
    @FXML Label saleTabRoom9PreferredPriceLabel;
    @FXML Label saleTabRoom10PreferredPriceLabel;
    @FXML Label saleTabRoom11PreferredPriceLabel;
    @FXML Label saleTabRoom12PreferredPriceLabel;
    @FXML Label saleTabRoom1PreferredPrice;
    @FXML Label saleTabRoom2PreferredPrice;
    @FXML Label saleTabRoom3PreferredPrice;
    @FXML Label saleTabRoom4PreferredPrice;
    @FXML Label saleTabRoom5PreferredPrice;
    @FXML Label saleTabRoom6PreferredPrice;
    @FXML Label saleTabRoom7PreferredPrice;
    @FXML Label saleTabRoom8PreferredPrice;
    @FXML Label saleTabRoom9PreferredPrice;
    @FXML Label saleTabRoom10PreferredPrice;
    @FXML Label saleTabRoom11PreferredPrice;
    @FXML Label saleTabRoom12PreferredPrice;
    @FXML TextField saleTabRoom1Price;
    @FXML TextField saleTabRoom2Price;
    @FXML TextField saleTabRoom3Price;
    @FXML TextField saleTabRoom4Price;
    @FXML TextField saleTabRoom5Price;
    @FXML TextField saleTabRoom6Price;
    @FXML TextField saleTabRoom7Price;
    @FXML TextField saleTabRoom8Price;
    @FXML TextField saleTabRoom9Price;
    @FXML TextField saleTabRoom10Price;
    @FXML TextField saleTabRoom11Price;
    @FXML TextField saleTabRoom12Price;
    @FXML TextField saleTabRoom1Discount;
    @FXML TextField saleTabRoom2Discount;
    @FXML TextField saleTabRoom3Discount;
    @FXML TextField saleTabRoom4Discount;
    @FXML TextField saleTabRoom5Discount;
    @FXML TextField saleTabRoom6Discount;
    @FXML TextField saleTabRoom7Discount;
    @FXML TextField saleTabRoom8Discount;
    @FXML TextField saleTabRoom9Discount;
    @FXML TextField saleTabRoom10Discount;
    @FXML TextField saleTabRoom11Discount;
    @FXML TextField saleTabRoom12Discount;
    @FXML Button saleTabButtonRoom1;
    @FXML Button saleTabButtonRoom2;
    @FXML Button saleTabButtonRoom3;
    @FXML Button saleTabButtonRoom4;
    @FXML Button saleTabButtonRoom5;
    @FXML Button saleTabButtonRoom6;
    @FXML Button saleTabButtonRoom7;
    @FXML Button saleTabButtonRoom8;
    @FXML Button saleTabButtonRoom9;
    @FXML Button saleTabButtonRoom10;
    @FXML Button saleTabButtonRoom11;
    @FXML Button saleTabButtonRoom12;

    @FXML TableView dashboardTabReadyTableViewErrors;

    int lastBankGenerateRoundNumber = 1;

    @FXML
    private void initialize() {
        try {
            Player.reset();
            System.out.println("1");
            ManageResources.reset();
            System.out.println("1.1");
            initializeDataFromDatabase();
            System.out.println("2");
            ManageBanks.generateBankOptions();
            System.out.println("3");
            checkDepositsAfterNewRound();
            System.out.println("4");
            dashboardTabBankGenerateDataInBankOptions();
            System.out.println("5");
            initializeRoomsInfo();
            System.out.println("6");
            revolvingCreditCheck();
            System.out.println("7");
            setUpChoiceBoxes();
            System.out.println("8");
            fillResourcesFromStorage();
            System.out.println("9");
            resourcesPanesVisibility();
            System.out.println("10");
            generateDashboardContent();
            System.out.println("11");
            setUpTooltips();
            System.out.println("12");
            generateSalePanes();
            System.out.println("13");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void initializeDataFromDatabase() {
        try {
            dashboardTabInfoCompanyName.setText(CurrentlyPlayedGame.getCurrentGame().getHotelName());
            dashboardTabInfoCompanyMission.setText(CurrentlyPlayedGame.getCurrentGame().getHotelMission());
            ResultSet hotelRS = executeQuery("SELECT chosen_bank_id, balance, revolving_credit_amount, logo FROM hotelprojekt.hotel WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId());
            while (hotelRS.next()) {
                int bankId = Integer.parseInt(hotelRS.getString(1));
                int balance = Integer.parseInt(hotelRS.getString(2));
                int rca = Integer.parseInt(hotelRS.getString(3));
                byte[] logoByte = hotelRS.getBytes(4);
                FileOutputStream fos = new FileOutputStream(new File("logo.png"));
                fos.write(logoByte);
                fos.close();
                File logo = new File("logo.png");
                Image image = new Image(logo.toURI().toString(), 240, 240, true, true,true);
                dashboardTabInfoLogo.setImage(image);
                CurrentlyPlayedGame.getCurrentGame().setHotelLogo(image);
                CurrentlyPlayedGame.getCurrentGame().setHotelLogoFile(logo);
                ManageBanks.setChosenBank(bankId);
                CurrentlyPlayedGame.setBalance(balance);
                Player.getRevolvingCredit().getCredit(rca);
            }
            ResultSet creditsRS = executeQuery("SELECT * FROM hotelprojekt.credit WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId());
            while (creditsRS.next()) {
                int bank_id = Integer.parseInt(creditsRS.getString(3));
                int start = Integer.parseInt(creditsRS.getString(4));
                int full = Integer.parseInt(creditsRS.getString(5));
                int monthsno = Integer.parseInt(creditsRS.getString(6));
                Player.addCredit(new Credit(ManageBanks.bankNames[bank_id - 1], bank_id, start, full,  ManageBanks.bankValues[bank_id - 1][2], monthsno));
            }
            ResultSet depositsRS = executeQuery("SELECT * FROM hotelprojekt.deposit WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId());
            while (depositsRS.next()) {
                int start = Integer.parseInt(depositsRS.getString(3));
                int monthsno = Integer.parseInt(depositsRS.getString(4));
                int initial = Integer.parseInt(depositsRS.getString(5));
                int tiv = Integer.parseInt(depositsRS.getString(6));
                Player.addDeposit(new Deposit(start, monthsno, initial, tiv));
            }
            ResultSet roomsRS = executeQuery("SELECT * FROM hotelprojekt.room WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId());
            while (roomsRS.next()) {
                int number = roomsRS.getInt(3);
                RoomsManagement.rooms[number - 1].setBought(roomsRS.getBoolean(4));
                RoomsManagement.rooms[number - 1].setActive(roomsRS.getBoolean(5));
                RoomsManagement.rooms[number - 1].setQualityBought(roomsRS.getInt(6));
                ManageResources.addResourcesToStorage(number, 1, roomsRS.getInt(7));
                ManageResources.addResourcesToStorage(number, 2, roomsRS.getInt(8));
                ManageResources.addResourcesToStorage(number, 3, roomsRS.getInt(9));
                RoomsManagement.rooms[number - 1].setPrice(roomsRS.getInt(10));
            }

            Player.getRevolvingCredit().setMonthlyResolvingInterest(ManageBanks.getCurrentlyChosenBank().getRevolvingCreditInterestRate());
        } catch (Exception e) {
            System.out.println(e);
        }
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
            dashboardTabOfferBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));

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
            dashboardTabOfferBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));



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

            dashboardTabResourcesVBoxRoom1Price1.setText(String.valueOf(RoomsManagement.rooms[0].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom2Price1.setText(String.valueOf(RoomsManagement.rooms[1].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom3Price1.setText(String.valueOf(RoomsManagement.rooms[2].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom4Price1.setText(String.valueOf(RoomsManagement.rooms[3].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom5Price1.setText(String.valueOf(RoomsManagement.rooms[4].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom6Price1.setText(String.valueOf(RoomsManagement.rooms[5].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom7Price1.setText(String.valueOf(RoomsManagement.rooms[6].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom8Price1.setText(String.valueOf(RoomsManagement.rooms[7].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom9Price1.setText(String.valueOf(RoomsManagement.rooms[8].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom10Price1.setText(String.valueOf(RoomsManagement.rooms[9].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom11Price1.setText(String.valueOf(RoomsManagement.rooms[10].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom12Price1.setText(String.valueOf(RoomsManagement.rooms[11].getResourcesPrices()[0]));
            dashboardTabResourcesVBoxRoom1Price2.setText(String.valueOf(RoomsManagement.rooms[0].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom2Price2.setText(String.valueOf(RoomsManagement.rooms[1].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom3Price2.setText(String.valueOf(RoomsManagement.rooms[2].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom4Price2.setText(String.valueOf(RoomsManagement.rooms[3].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom5Price2.setText(String.valueOf(RoomsManagement.rooms[4].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom6Price2.setText(String.valueOf(RoomsManagement.rooms[5].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom7Price2.setText(String.valueOf(RoomsManagement.rooms[6].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom8Price2.setText(String.valueOf(RoomsManagement.rooms[7].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom9Price2.setText(String.valueOf(RoomsManagement.rooms[8].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom10Price2.setText(String.valueOf(RoomsManagement.rooms[9].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom11Price2.setText(String.valueOf(RoomsManagement.rooms[10].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom12Price2.setText(String.valueOf(RoomsManagement.rooms[11].getResourcesPrices()[1]));
            dashboardTabResourcesVBoxRoom1Price3.setText(String.valueOf(RoomsManagement.rooms[0].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom2Price3.setText(String.valueOf(RoomsManagement.rooms[1].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom3Price3.setText(String.valueOf(RoomsManagement.rooms[2].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom4Price3.setText(String.valueOf(RoomsManagement.rooms[3].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom5Price3.setText(String.valueOf(RoomsManagement.rooms[4].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom6Price3.setText(String.valueOf(RoomsManagement.rooms[5].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom7Price3.setText(String.valueOf(RoomsManagement.rooms[6].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom8Price3.setText(String.valueOf(RoomsManagement.rooms[7].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom9Price3.setText(String.valueOf(RoomsManagement.rooms[8].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom10Price3.setText(String.valueOf(RoomsManagement.rooms[9].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom11Price3.setText(String.valueOf(RoomsManagement.rooms[10].getResourcesPrices()[2]));
            dashboardTabResourcesVBoxRoom12Price3.setText(String.valueOf(RoomsManagement.rooms[11].getResourcesPrices()[2]));
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metoda wykonywana po kliknięciu zakładki odświeżająca informacje.
     */
    @FXML
    private void tabRefresh() {
        try {
            dashboardTabOfferBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
            dashboardTabBankBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
            dashboardTabResourcesBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
            resourcesPanesVisibility();
            generateDashboardContent();
            initializeRoomsInfo();
            checkErrors();
            generateSalePanes();
        } catch (Exception e) {}

    }

    /**
     * Metoda generująca informacje do dashboardu.
     */
    @FXML
    private void generateDashboardContent() {
        dashboardTabDashboardBalance.setText(CurrentlyPlayedGame.getBalance() + " PLN");
        if(CurrentlyPlayedGame.getCurrentGame().getHotelLogo() != null) {
            dashboardTabDashboardImage.setImage(CurrentlyPlayedGame.getCurrentGame().getHotelLogo());
        }
        if(CurrentlyPlayedGame.getCurrentGame().getHotelName() != null) {
            dashboardTabDashboardName.setText(CurrentlyPlayedGame.getCurrentGame().getHotelName());
        }
        if(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() > 1) {
            dashboardTabDashboardRank.setText("1"); //TODO rank number
            dashboardTabDashboardRank.setStyle("-fx-font-size: 62;");
        }
        dashboardTabDashboardRoundNumber.setText(String.valueOf(CurrentlyPlayedGame.getCurrentGame().getCurrentRound()));
    }

    /**
     * Metoda sprawdzająca, czy gracz musi zrobić jeszcze coś, zanim zgłosi grę do przeniesienia.
     */
    @FXML
    private void checkErrors() {
        ArrayList<String> allErrors = new ArrayList<>();
        if(CurrentlyPlayedGame.getCurrentGame().getHotelName() == null || CurrentlyPlayedGame.getCurrentGame().getHotelName().equals("")) {
            allErrors.add("Nie wybrano nazwy firmy");
        }
        if(CurrentlyPlayedGame.getCurrentGame().getHotelMission() == null || CurrentlyPlayedGame.getCurrentGame().getHotelMission().equals("")) {
            allErrors.add("Nie wybrano misji firmy");
        }
        if(CurrentlyPlayedGame.getCurrentGame().getHotelLogo() == null) {
            allErrors.add("Nie wybrano logo firmy");
        }
        if(!ManageBanks.isBankChosen()) {
            allErrors.add("Nie wybrano banku");
        }
        if(allErrors.size() > 0) {
            viewAllErrorsTable(allErrors);
        } else {
            dashboardTabReadyTableViewErrors.getItems().clear();
            dashboardTabReadyTableViewErrors.getColumns().clear();
        }
    }

    @FXML
    public void viewAllErrorsTable(ArrayList<String> allErrors) {
        try {
            int numberOfColumns;
            String[] columnKeys = {"ErrorKey"};
            String[] columnNames = {"Error"};
            dashboardTabReadyTableViewErrors.getItems().clear();
            dashboardTabReadyTableViewErrors.getColumns().clear();
            numberOfColumns = columnNames.length;

            for(int j = 0; j < numberOfColumns; j++) {
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                dashboardTabReadyTableViewErrors.getColumns().add(col);
            }
            dashboardTabReadyTableViewErrors.getItems().setAll(generateDataInMapAllErrors(allErrors, columnKeys));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z lokatami.
     * @return ObservableList z lokatami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMapAllErrors(ArrayList<String> allErrors, String[] columnKeys) throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for(int i = 0; i < allErrors.size(); i++) {
           Map<String, String> dataRow = new HashMap<>();
           dataRow.put(columnKeys[0], String.valueOf(allErrors.get(i)));
           allData.add(dataRow);

        }
        return allData;
    }

    @FXML
    private void fillResourcesFromStorage() {
        dashboardTabResourcesVBoxRoom1Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom1()[0]));
        dashboardTabResourcesVBoxRoom1Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom1()[1]));
        dashboardTabResourcesVBoxRoom1Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom1()[2]));
        dashboardTabResourcesVBoxRoom2Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom2()[0]));
        dashboardTabResourcesVBoxRoom2Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom2()[1]));
        dashboardTabResourcesVBoxRoom2Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom2()[2]));
        dashboardTabResourcesVBoxRoom3Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom3()[0]));
        dashboardTabResourcesVBoxRoom3Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom3()[1]));
        dashboardTabResourcesVBoxRoom3Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom3()[2]));
        dashboardTabResourcesVBoxRoom4Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom4()[0]));
        dashboardTabResourcesVBoxRoom4Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom4()[1]));
        dashboardTabResourcesVBoxRoom4Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom4()[2]));
        dashboardTabResourcesVBoxRoom5Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom5()[0]));
        dashboardTabResourcesVBoxRoom5Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom5()[1]));
        dashboardTabResourcesVBoxRoom5Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom5()[2]));
        dashboardTabResourcesVBoxRoom6Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom6()[0]));
        dashboardTabResourcesVBoxRoom6Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom6()[1]));
        dashboardTabResourcesVBoxRoom6Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom6()[2]));
        dashboardTabResourcesVBoxRoom7Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom7()[0]));
        dashboardTabResourcesVBoxRoom7Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom7()[1]));
        dashboardTabResourcesVBoxRoom7Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom7()[2]));
        dashboardTabResourcesVBoxRoom8Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom8()[0]));
        dashboardTabResourcesVBoxRoom8Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom8()[1]));
        dashboardTabResourcesVBoxRoom8Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom8()[2]));
        dashboardTabResourcesVBoxRoom9Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom9()[0]));
        dashboardTabResourcesVBoxRoom9Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom9()[1]));
        dashboardTabResourcesVBoxRoom9Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom9()[2]));
        dashboardTabResourcesVBoxRoom10Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom10()[0]));
        dashboardTabResourcesVBoxRoom10Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom10()[1]));
        dashboardTabResourcesVBoxRoom10Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom10()[2]));
        dashboardTabResourcesVBoxRoom11Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom11()[0]));
        dashboardTabResourcesVBoxRoom11Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom11()[1]));
        dashboardTabResourcesVBoxRoom11Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom11()[2]));
        dashboardTabResourcesVBoxRoom12Quality1StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom12()[0]));
        dashboardTabResourcesVBoxRoom12Quality2StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom12()[1]));
        dashboardTabResourcesVBoxRoom12Quality3StorageAmount.setText(String.valueOf(ManageResources.getResourcesRoom12()[2]));
    }

    @FXML
    private void setUpChoiceBoxes() {
        dashboardTabResourcesRoom1QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom2QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom3QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom4QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom5QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom6QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom7QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom8QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom9QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom10QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom11QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom12QualityChoiceBox.setItems(FXCollections.observableArrayList("★", "★★", "★★★"));
        dashboardTabResourcesRoom1QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom2QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom3QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom4QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom5QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom6QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom7QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom8QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom9QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom10QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom11QualityChoiceBox.setValue("★");
        dashboardTabResourcesRoom12QualityChoiceBox.setValue("★");
    }

    @FXML
    private void setUpTooltips() {
        dashboardTabResourcesSetPrice1.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice2.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice3.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice4.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice5.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice6.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice7.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice8.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice9.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice10.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice11.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTabResourcesSetPrice12.setTooltip(new Tooltip("Zestaw to wszystkie zasoby potrzebne dla 1 klienta."));
        dashboardTab.setTooltip(new Tooltip("Karta przechowująca najważniejsze informacje o twoim biznesie"));
        infoTab.setTooltip(new Tooltip("Karta zawierająca informacje o firmie takie jak nazwa, logo i misja"));
        offerTab.setTooltip(new Tooltip("Karta zawierające dostępne do kupienia pokoje"));
        resourcesTab.setTooltip(new Tooltip("Karta zawierająca zasoby potrzebne do sprzedaży pokoi"));
        officesTab.setTooltip(new Tooltip("Karta zawierająca stanowiska do zakupu oraz umożliwiająca zatrudnianie pracowników"));
        bankTab.setTooltip(new Tooltip("Karta zawierająca bank, lokaty i kredyty"));
        accountingTab.setTooltip(new Tooltip("Karta zawierająca biuro rachunkowe"));
        saleTab.setTooltip(new Tooltip("Karta zawierająca kupione pokoje. Tutaj gracz udostępnia pokoje klientom po ustalonej cenie"));
        resultsTab.setTooltip(new Tooltip("Karta zawierająca wyniki działalności hotelu"));
        readyTab.setTooltip(new Tooltip("Karta zawierająca listę błędów oraz przycisk zatwierdzający gotowość przejścia do następnej rundy"));
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
        String roomId1 = String.valueOf(buttonId.charAt(buttonId.length() - 6));
        int roomId;
        if(roomId1.equals("m")) {
            roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 5))) - 1;
        } else {
            roomId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 6) + "" + buttonId.charAt(buttonId.length() - 5))) - 1;
        }
        int quality = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 1))) - 1;
        if(RoomsManagement.rooms[roomId].isBought() && RoomsManagement.rooms[roomId].getQualityBought() == quality) {
            int roomPrice = RoomsManagement.rooms[roomId].getFurnishingPrices()[RoomsManagement.rooms[roomId].getQualityBought()];
            CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + roomPrice);
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
            int roomPriceOld = RoomsManagement.rooms[roomId].getFurnishingPrices()[RoomsManagement.rooms[roomId].getQualityBought()];
            int roomPriceNew = RoomsManagement.rooms[roomId].getFurnishingPrices()[quality];
            if(roomPriceNew <= roomPriceOld) {
                RoomsManagement.rooms[roomId].setQualityBought(quality);
                CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + (roomPriceOld - roomPriceNew));
            } else if(CurrentlyPlayedGame.getBalance() + roomPriceOld >= roomPriceNew) {
                RoomsManagement.rooms[roomId].setQualityBought(quality);
                CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + roomPriceOld - roomPriceNew);
            }
        } else {
            int roomPrice = RoomsManagement.rooms[roomId].getFurnishingPrices()[quality];
            if(CurrentlyPlayedGame.getBalance() >= roomPrice) {
                RoomsManagement.rooms[roomId].setBought(true);
                RoomsManagement.rooms[roomId].setQualityBought(quality);
                CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - roomPrice);
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
        }
        dashboardTabOfferBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
        switchToRoomInfo(roomId);
        generateSalePanes();
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
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[0].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom1VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom1VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom2VBoxes = dashboardTabOfferHBoxSeasoningRoom2.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom2VBoxes) {
            double height = 15 * RoomsManagement.rooms[1].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[1].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom2VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom3VBoxes = dashboardTabOfferHBoxSeasoningRoom3.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom3VBoxes) {
            double height = 15 * RoomsManagement.rooms[2].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[2].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom3VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom4VBoxes = dashboardTabOfferHBoxSeasoningRoom4.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom4VBoxes) {
            double height = 15 * RoomsManagement.rooms[3].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[3].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom4VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom5VBoxes = dashboardTabOfferHBoxSeasoningRoom5.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom5VBoxes) {
            double height = 15 * RoomsManagement.rooms[4].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[4].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom5VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom6VBoxes = dashboardTabOfferHBoxSeasoningRoom6.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom6VBoxes) {
            double height = 15 * RoomsManagement.rooms[5].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[5].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom6VBoxesIndex++;
        }

        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom7VBoxes = dashboardTabOfferHBoxSeasoningRoom7.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom7VBoxes) {
            double height = 15 * RoomsManagement.rooms[6].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[6].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom7VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom8VBoxes = dashboardTabOfferHBoxSeasoningRoom8.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom8VBoxes) {
            double height = 15 * RoomsManagement.rooms[7].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[7].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom8VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom9VBoxes = dashboardTabOfferHBoxSeasoningRoom9.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom9VBoxes) {
            double height = 15 * RoomsManagement.rooms[8].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[8].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom9VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom10VBoxes = dashboardTabOfferHBoxSeasoningRoom10.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom10VBoxes) {
            double height = 15 * RoomsManagement.rooms[9].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[9].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom10VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom11VBoxes = dashboardTabOfferHBoxSeasoningRoom11.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom11VBoxes) {
            double height = 15 * RoomsManagement.rooms[10].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[10].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom11VBoxesIndex++;
        }
        ObservableList<Node> dashboardTabOfferHBoxSeasoningRoom12VBoxes = dashboardTabOfferHBoxSeasoningRoom12.getChildren();
        int dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex = 0;
        for(Node node: dashboardTabOfferHBoxSeasoningRoom12VBoxes) {
            double height = 15 * RoomsManagement.rooms[11].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex];
            node.setStyle("-fx-background-color: #7d0422; -fx-min-height: " + height + "; -fx-pref-height: " + height + ";");
            Label l = (Label) node;
            l.setTooltip(new Tooltip(String.valueOf(RoomsManagement.rooms[11].getSeasonality()[dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex])));
            dashboardTabOfferHBoxSeasoningRoom12VBoxesIndex++;
        }
    }

    @FXML
    private void buyResources(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        String roomIdString = buttonId.substring(buttonId.length() - 5);
        String qualityStars = "", amount = "";
        int roomId, quality;
        if(roomIdString.charAt(0) == 'm') {
            roomId = Integer.parseInt(String.valueOf(roomIdString.charAt(1)));
        } else {
            roomId = Integer.parseInt(roomIdString.charAt(0) + "" +  roomIdString.charAt(1));
        }
        switch (roomId) {
            case 1:
                amount = dashboardTabResourcesRoom1PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom1QualityChoiceBox.getValue();
                dashboardTabResourcesRoom1PriceTextField.setText("");
                dashboardTabResourcesRoom1QualityChoiceBox.setValue("★");
                break;
            case 2:
                amount = dashboardTabResourcesRoom2PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom2QualityChoiceBox.getValue();
                dashboardTabResourcesRoom2PriceTextField.setText("");
                dashboardTabResourcesRoom2QualityChoiceBox.setValue("★");
                break;
            case 3:
                amount = dashboardTabResourcesRoom3PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom3QualityChoiceBox.getValue();
                dashboardTabResourcesRoom3PriceTextField.setText("");
                dashboardTabResourcesRoom3QualityChoiceBox.setValue("★");
                break;
            case 4:
                amount = dashboardTabResourcesRoom4PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom4QualityChoiceBox.getValue();
                dashboardTabResourcesRoom4PriceTextField.setText("");
                dashboardTabResourcesRoom4QualityChoiceBox.setValue("★");
                break;
            case 5:
                amount = dashboardTabResourcesRoom5PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom5QualityChoiceBox.getValue();
                dashboardTabResourcesRoom5PriceTextField.setText("");
                dashboardTabResourcesRoom5QualityChoiceBox.setValue("★");
                break;
            case 6:
                amount = dashboardTabResourcesRoom6PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom6QualityChoiceBox.getValue();
                dashboardTabResourcesRoom6PriceTextField.setText("");
                dashboardTabResourcesRoom6QualityChoiceBox.setValue("★");
                break;
            case 7:
                amount = dashboardTabResourcesRoom7PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom7QualityChoiceBox.getValue();
                dashboardTabResourcesRoom7PriceTextField.setText("");
                dashboardTabResourcesRoom7QualityChoiceBox.setValue("★");
                break;
            case 8:
                amount = dashboardTabResourcesRoom8PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom8QualityChoiceBox.getValue();
                dashboardTabResourcesRoom8PriceTextField.setText("");
                dashboardTabResourcesRoom8QualityChoiceBox.setValue("★");
                break;
            case 9:
                amount = dashboardTabResourcesRoom9PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom9QualityChoiceBox.getValue();
                dashboardTabResourcesRoom9PriceTextField.setText("");
                dashboardTabResourcesRoom9QualityChoiceBox.setValue("★");
                break;
            case 10:
                amount = dashboardTabResourcesRoom10PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom10QualityChoiceBox.getValue();
                dashboardTabResourcesRoom10PriceTextField.setText("");
                dashboardTabResourcesRoom10QualityChoiceBox.setValue("★");
                break;
            case 11:
                amount = dashboardTabResourcesRoom11PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom11QualityChoiceBox.getValue();
                dashboardTabResourcesRoom11PriceTextField.setText("");
                dashboardTabResourcesRoom11QualityChoiceBox.setValue("★");
                break;
            case 12:
                amount = dashboardTabResourcesRoom12PriceTextField.getText();
                qualityStars = dashboardTabResourcesRoom12QualityChoiceBox.getValue();
                dashboardTabResourcesRoom12PriceTextField.setText("");
                dashboardTabResourcesRoom12QualityChoiceBox.setValue("★");
                break;
        }
        if(qualityStars.equals("★★★")) {
            quality = 3;
        } else if(qualityStars.equals("★★")) {
            quality = 2;
        } else {
            quality = 1;
        }

        int totalPrice = RoomsManagement.rooms[roomId - 1].getResourcesPrices()[quality - 1] * Integer.parseInt(amount);
        if(CurrentlyPlayedGame.getBalance() >= totalPrice) {
            ManageResources.addResourcesToStorage(roomId, quality, Integer.parseInt(amount));
            CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - totalPrice);
            dashboardTabResourcesBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
            fillResourcesFromStorage();
        }
    }

    /**
     * Metoda ustawiająca widoczność okien do zakupu zasobów.
     */
    @FXML
    private void resourcesPanesVisibility() {
        dashboardTabResourcesPaneRoom1.setVisible(RoomsManagement.rooms[0].isBought());
        dashboardTabResourcesPaneRoom2.setVisible(RoomsManagement.rooms[1].isBought());
        dashboardTabResourcesPaneRoom3.setVisible(RoomsManagement.rooms[2].isBought());
        dashboardTabResourcesPaneRoom4.setVisible(RoomsManagement.rooms[3].isBought());
        dashboardTabResourcesPaneRoom5.setVisible(RoomsManagement.rooms[4].isBought());
        dashboardTabResourcesPaneRoom6.setVisible(RoomsManagement.rooms[5].isBought());
        dashboardTabResourcesPaneRoom7.setVisible(RoomsManagement.rooms[6].isBought());
        dashboardTabResourcesPaneRoom8.setVisible(RoomsManagement.rooms[7].isBought());
        dashboardTabResourcesPaneRoom9.setVisible(RoomsManagement.rooms[8].isBought());
        dashboardTabResourcesPaneRoom10.setVisible(RoomsManagement.rooms[9].isBought());
        dashboardTabResourcesPaneRoom11.setVisible(RoomsManagement.rooms[10].isBought());
        dashboardTabResourcesPaneRoom12.setVisible(RoomsManagement.rooms[11].isBought());
        dashboardTabResourcesHBoxTitle1.setVisible(RoomsManagement.rooms[0].isBought() || RoomsManagement.rooms[1].isBought() || RoomsManagement.rooms[2].isBought() || RoomsManagement.rooms[3].isBought() || RoomsManagement.rooms[4].isBought() || RoomsManagement.rooms[5].isBought());
        dashboardTabResourcesHBoxTitle2.setVisible(RoomsManagement.rooms[6].isBought() || RoomsManagement.rooms[7].isBought() || RoomsManagement.rooms[8].isBought());
        dashboardTabResourcesHBoxTitle3.setVisible(RoomsManagement.rooms[9].isBought() || RoomsManagement.rooms[10].isBought() || RoomsManagement.rooms[11].isBought());
        if(RoomsManagement.rooms[0].isBought() || RoomsManagement.rooms[1].isBought() || RoomsManagement.rooms[2].isBought()) {
            dashboardTabResourcesHBoxSet1.setMinHeight(330.0);
        } else {
            dashboardTabResourcesHBoxSet1.setMinHeight(0.0);
        }
        if(RoomsManagement.rooms[3].isBought() || RoomsManagement.rooms[4].isBought() || RoomsManagement.rooms[5].isBought()) {
            dashboardTabResourcesHBoxSet2.setMinHeight(330.0);
        } else {
            dashboardTabResourcesHBoxSet2.setMinHeight(0.0);
        }
        if(RoomsManagement.rooms[6].isBought() || RoomsManagement.rooms[7].isBought() || RoomsManagement.rooms[8].isBought()) {
            dashboardTabResourcesHBoxSet3.setMinHeight(330.0);
        } else {
            dashboardTabResourcesHBoxSet3.setMinHeight(0.0);
        }
        if(RoomsManagement.rooms[9].isBought() || RoomsManagement.rooms[10].isBought() || RoomsManagement.rooms[11].isBought()) {
            dashboardTabResourcesHBoxSet4.setMinHeight(330.0);
        } else {
            dashboardTabResourcesHBoxSet4.setMinHeight(0.0);
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
            CurrentlyPlayedGame.getCurrentGame().setHotelLogo(image);
            CurrentlyPlayedGame.getCurrentGame().setHotelLogoFile(selectedFile);
        } else {
            dashboardTabInfoLogoLabel.setText("Wybierz Logo Firmy");
        }
    }

    @FXML
    private void saveNameAndMission() {
        if(dashboardTabInfoCompanyName.getText() != null)  {
            CurrentlyPlayedGame.getCurrentGame().setHotelName(dashboardTabInfoCompanyName.getText());
        }
        if(dashboardTabInfoCompanyMission.getText() != null) {
            CurrentlyPlayedGame.getCurrentGame().setHotelMission((dashboardTabInfoCompanyMission.getText()));
        }
    }

    @FXML
    private void dashboardTabBankGenerateDataInBankOptions() {
        if(ManageBanks.isBankChosen()) {
            dashboardTabBankHBoxSelect.setVisible(false);
            dashboardTabBankVBoxInfo.setVisible(true);
            dashboardTabBankDepositPopUpScreen.setVisible(false);

            dashboardTabBankName.setText(ManageBanks.getCurrentlyChosenBank().getName());
            dashboardTabBankBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
            dashboardTabBankDepositInterestRate.setText(String.valueOf(ManageBanks.getCurrentlyChosenBank().getDepositInterestRate()) + "%");
            dashboardTabBankCreditInterestRate.setText(String.valueOf(ManageBanks.getCurrentlyChosenBank().getCreditInterestRate()) + "%");
            dashboardTabBankRevolvingCreditInterestRate.setText(String.valueOf(ManageBanks.getCurrentlyChosenBank().getRevolvingCreditInterestRate()) + "%");
            viewDepositsTable();
            viewCreditsTable();
        } else {
            ManageBanks.generateBankOptions();

            dashboardTabBankHBoxSelect.setVisible(true);
            dashboardTabBankVBoxInfo.setVisible(false);
            dashboardTabBankDepositPopUpScreen.setVisible(false);

            dashboardTabBankSelectBank1Label.setText(ManageBanks.getBankOption1().getName());
            dashboardTabBankSelectBank2Label.setText(ManageBanks.getBankOption2().getName());
            dashboardTabBankSelectBank3Label.setText(ManageBanks.getBankOption3().getName());

            dashboardTabBankSelectBank1value1.setText(String.valueOf(ManageBanks.getBankOption1().getAccountCost()));
            dashboardTabBankSelectBank1value2.setText(String.valueOf(ManageBanks.getBankOption1().getCardCost()));
            dashboardTabBankSelectBank1value3.setText(String.valueOf(ManageBanks.getBankOption1().getDepositInterestRate()));
            dashboardTabBankSelectBank1value4.setText(String.valueOf(ManageBanks.getBankOption1().getCreditInterestRate()));
            dashboardTabBankSelectBank1value5.setText(String.valueOf(ManageBanks.getBankOption1().getRevolvingCreditInterestRate()));

            dashboardTabBankSelectBank2value1.setText(String.valueOf(ManageBanks.getBankOption2().getAccountCost()));
            dashboardTabBankSelectBank2value2.setText(String.valueOf(ManageBanks.getBankOption2().getCardCost()));
            dashboardTabBankSelectBank2value3.setText(String.valueOf(ManageBanks.getBankOption2().getDepositInterestRate()));
            dashboardTabBankSelectBank2value4.setText(String.valueOf(ManageBanks.getBankOption2().getCreditInterestRate()));
            dashboardTabBankSelectBank2value5.setText(String.valueOf(ManageBanks.getBankOption2().getRevolvingCreditInterestRate()));

            dashboardTabBankSelectBank3value1.setText(String.valueOf(ManageBanks.getBankOption3().getAccountCost()));
            dashboardTabBankSelectBank3value2.setText(String.valueOf(ManageBanks.getBankOption3().getCardCost()));
            dashboardTabBankSelectBank3value3.setText(String.valueOf(ManageBanks.getBankOption3().getDepositInterestRate()));
            dashboardTabBankSelectBank3value4.setText(String.valueOf(ManageBanks.getBankOption3().getCreditInterestRate()));
            dashboardTabBankSelectBank3value5.setText(String.valueOf(ManageBanks.getBankOption3().getRevolvingCreditInterestRate()));
        }
    }

    @FXML
    public void viewDepositsTable() {
        try {
            int numberOfColumns;
            String[] columnKeys = {"Miesiąc_założeniaKey", "Okres_lokatyKey", "Oprocentowanie_w_skali_rokuKey", "Kwota_LokatyKey"};
            String[] columnNames = {"Miesiąc założenia", "Okres lokaty", "Oprocentowanie w skali roku", "Kwota Lokaty"};
            String[] depositsId = new String[100];
            ArrayList<Deposit> allDeposits;
            int numberOfDeposits = 0;
            String depositIdString = "";
            if(Player.getDeposits().size() > 0) {
                depositIdString = depositsId[0];
                for(int i = 1; i < numberOfDeposits; i++) {
                    depositIdString = depositIdString + ", " + depositsId[i];
                }
            }
            allDeposits = Player.getDeposits();
            dashboardTabBankTableViewDeposit.getItems().clear();
            dashboardTabBankTableViewDeposit.getColumns().clear();
            numberOfColumns = columnNames.length;

            for(int j = 0; j < numberOfColumns; j++) {
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                dashboardTabBankTableViewDeposit.getColumns().add(col);
            }
            dashboardTabBankTableViewDeposit.getItems().setAll(generateDataInMapAllDeposits(allDeposits, columnKeys));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z lokatami.
     * @return ObservableList z lokatami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMapAllDeposits(ArrayList<Deposit> allDeposits, String[] columnKeys) throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for(int i = 0; i < allDeposits.size(); i++) {
            if(allDeposits.get(i).isActive()) {
                Map<String, String> dataRow = new HashMap<>();
                dataRow.put(columnKeys[0], String.valueOf(allDeposits.get(i).getStartMonth()));
                dataRow.put(columnKeys[1], String.valueOf(allDeposits.get(i).getNumberOfMonths()));
                dataRow.put(columnKeys[2], String.valueOf(allDeposits.get(i).getInitialRate()));
                dataRow.put(columnKeys[3], String.valueOf(allDeposits.get(i).getTotalInterestValue()));
                allData.add(dataRow);
            }
        }
        return allData;
    }

    @FXML
    private void dashboardTabBankSelectBank(Event event) {
        String buttonId = ((Control)event.getSource()).getId();
        int bankId = Integer.parseInt(String.valueOf(buttonId.charAt(buttonId.length() - 1)));
        ManageBanks.choseBank(bankId);
        dashboardTabBankVBoxInfo.setVisible(true);
        dashboardTabBankHBoxSelect.setVisible(false);
        dashboardTabBankGenerateDataInBankOptions();
    }

    @FXML
    private void createDepositShowPopUp() {
        dashboardTabBankDepositPopUpScreen.setVisible(true);
        dashboardTabBankDepositPopUpBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
        dashboardTabBankDepositPopUpInitialRate.setText(String.valueOf(ManageBanks.getCurrentlyChosenBank().getDepositInterestRate()));
        dashboardTabBankDepositPopUpDepositTimeSlider.setMax(12 - CurrentlyPlayedGame.getCurrentGame().getCurrentRound());
        dashboardTabBankDepositPopUpDepositTimeMax.setText(String.valueOf(12 - CurrentlyPlayedGame.getCurrentGame().getCurrentRound()));
    }

    @FXML
    private void getCreditShowPopUp() {
        dashboardTabBankCreditPopUpScreen.setVisible(true);
        dashboardTabBankCreditPopUpCreditTimeSlider.setMax(11 - CurrentlyPlayedGame.getCurrentGame().getCurrentRound());
        dashboardTabBankCreditPopUpCreditTimeMax.setText(String.valueOf(11 - CurrentlyPlayedGame.getCurrentGame().getCurrentRound()));
        dashboardTabBankCreditPopUpInitialRate.setText(String.valueOf(ManageBanks.getCurrentlyChosenBank().getCreditInterestRate()));
    }

    @FXML
    private void createDepositHidePopUp() {
        dashboardTabBankDepositPopUpScreen.setVisible(false);
    }

    @FXML
    private void getCreditHidePopUp() {
        dashboardTabBankCreditPopUpScreen.setVisible(false);
    }

    @FXML
    private void createDepositButtonClicked() {
        int depositTime = (int) dashboardTabBankDepositPopUpDepositTimeSlider.getValue();
        int depositValue = Integer.parseInt(dashboardTabBankDepositPopUpDepositValue.getText());
        if(CurrentlyPlayedGame.getBalance() >= depositValue) {
            createDepositHidePopUp();
            Player.addDeposit(new Deposit(CurrentlyPlayedGame.getCurrentGame().getCurrentRound(), depositTime, ManageBanks.getCurrentlyChosenBank().getDepositInterestRate(), depositValue));
            CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - depositValue);
            viewDepositsTable();
            dashboardTabBankBalance.setText(String.valueOf(CurrentlyPlayedGame.getBalance()));
        }
    }

    @FXML
    private void changeBank() {

            ManageBanks.resetBankOptions();
            ManageBanks.generateBankOptions();
            lastBankGenerateRoundNumber = CurrentlyPlayedGame.getCurrentGame().getCurrentRound();
            dashboardTabBankHBoxSelect.setVisible(true);
            dashboardTabBankVBoxInfo.setVisible(false);
            dashboardTabBankDepositPopUpScreen.setVisible(false);
            dashboardTabBankGenerateDataInBankOptions();

    }

    @FXML
    public void viewCreditsTable() {
        try {
            int numberOfColumns;
            String[] columnKeys = {"Nazwa_bankuKey", "Miesiąc_zaciągnięciaKey", "KwotaKey", "Długość_spłaty_kredytuKey", "Miesięczna_rataKey", "Odsetki_miesięczneKey", "Pozostała_kwota_do_spłatyKey"};
            String[] columnNames = {"Nazwa banku", "Miesiąc zaciągnięcia", "Kwota", "Długość spłaty kredytu", "Miesięczna rata", "Odsetki miesięczne", "Pozostała kwota do spłaty"};
            String[] creditsId = new String[100];
            ArrayList<Credit> allCredits;
            int numberOfCredits = 0;
            String creditIdString = "";
            if(Player.getCredits().size() > 0) {
                creditIdString = creditsId[0];
                for(int i = 1; i < numberOfCredits; i++) {
                    creditIdString = creditIdString + ", " + creditsId[i];
                }
            }
            allCredits = Player.getCredits();
            dashboardTabBankTableViewCredit.getItems().clear();
            dashboardTabBankTableViewCredit.getColumns().clear();
            numberOfColumns = columnNames.length;

            for(int j = 0; j < numberOfColumns; j++) {
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                dashboardTabBankTableViewCredit.getColumns().add(col);
            }
            dashboardTabBankTableViewCredit.getItems().setAll(generateDataInMapAllCredits(allCredits, columnKeys));
            checkPlayersCreditWorthiness();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z kredytami.
     * @return ObservableList z kredytami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMapAllCredits(ArrayList<Credit> allCredits, String[] columnKeys) throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for(int i = 0; i < allCredits.size(); i++) {
            if(allCredits.get(i).isActive()) {
                Map<String, String> dataRow = new HashMap<>();
                dataRow.put(columnKeys[0], String.valueOf(allCredits.get(i).getBankName()));
                dataRow.put(columnKeys[1], String.valueOf(allCredits.get(i).getStartMonth()));
                dataRow.put(columnKeys[2], String.valueOf(allCredits.get(i).getFullAmountOfCredit()));
                dataRow.put(columnKeys[3], String.valueOf(allCredits.get(i).getNumberOfMonths()));
                dataRow.put(columnKeys[4], String.valueOf(allCredits.get(i).getMonthlyPayment()));
                dataRow.put(columnKeys[5], String.valueOf(allCredits.get(i).getMonthlyInterest()));
                dataRow.put(columnKeys[6], String.valueOf(allCredits.get(i).getRestAmountOfCredit()));
                allData.add(dataRow);
            }
        }
        return allData;
    }

    @FXML
    private void getCreditButtonClicked() {
        if(Player.addCredit(new Credit(ManageBanks.getCurrentlyChosenBank().getName(), ManageBanks.getCurrentlyChosenBank().getBankId(), CurrentlyPlayedGame.getCurrentGame().getCurrentRound(), Integer.parseInt(dashboardTabBankCreditPopUpCreditValue.getText()), ManageBanks.getCurrentlyChosenBank().getCreditInterestRate(), (int) dashboardTabBankCreditPopUpCreditTimeSlider.getValue()))) {
            getCreditHidePopUp();
            CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + Integer.parseInt(dashboardTabBankCreditPopUpCreditValue.getText()));
            dashboardTabBankGenerateDataInBankOptions();
        }

    }

    @FXML
    private void checkPlayersCreditWorthiness() {
        if(Player.checkCreditWorthiness()) {
            dashboardTabBankGetCreditButton.setText("WEŹ KREDYT");
        } else {
            dashboardTabBankGetCreditButton.setText("Nie możesz wziąć kolejnego kredytu");
        }
    }

    @FXML
    private void revolvingCreditCheck() {
        if(Player.getRevolvingCredit() != null) {
            if (Player.getRevolvingCredit().getFullAmountOfRevolvingCredit() > 0) {
                dashboardTabBankRevolvingCreditAmount.setText("Wysokość niespłaconego kredytu odnawialnego: " + Player.getRevolvingCredit().getFullAmountOfRevolvingCredit());
            } else {
                dashboardTabBankRevolvingCreditAmount.setText("Nie masz zaciągniętego kredytu odnawialnego.");
            }
        } else {
            dashboardTabBankRevolvingCreditAmount.setText("Nie masz zaciągniętego kredytu odnawialnego.");
        }
    }

    @FXML
    private void generateSalePanes() {
        Pane[] panes = new Pane[] {saleTabRoom1Pane, saleTabRoom2Pane, saleTabRoom3Pane, saleTabRoom4Pane, saleTabRoom5Pane, saleTabRoom6Pane, saleTabRoom7Pane, saleTabRoom8Pane, saleTabRoom9Pane, saleTabRoom10Pane, saleTabRoom11Pane, saleTabRoom12Pane};
        Label[] names = new Label[] {saleTabRoom1Name, saleTabRoom2Name, saleTabRoom3Name, saleTabRoom4Name, saleTabRoom5Name, saleTabRoom6Name, saleTabRoom7Name, saleTabRoom8Name, saleTabRoom9Name, saleTabRoom10Name, saleTabRoom11Name, saleTabRoom12Name};
        Label[] preferredPrice = new Label[] {saleTabRoom1PreferredPrice, saleTabRoom2PreferredPrice, saleTabRoom3PreferredPrice, saleTabRoom4PreferredPrice, saleTabRoom5PreferredPrice, saleTabRoom6PreferredPrice, saleTabRoom7PreferredPrice, saleTabRoom8PreferredPrice, saleTabRoom9PreferredPrice, saleTabRoom10PreferredPrice, saleTabRoom11PreferredPrice, saleTabRoom12PreferredPrice};
        Button[] buttons = new Button[] {saleTabButtonRoom1, saleTabButtonRoom2, saleTabButtonRoom3, saleTabButtonRoom4, saleTabButtonRoom5, saleTabButtonRoom6, saleTabButtonRoom7, saleTabButtonRoom8, saleTabButtonRoom9, saleTabButtonRoom10, saleTabButtonRoom11, saleTabButtonRoom12};
        TextField[] prices = new TextField[] {saleTabRoom1Price, saleTabRoom2Price, saleTabRoom3Price, saleTabRoom4Price, saleTabRoom5Price, saleTabRoom6Price, saleTabRoom7Price, saleTabRoom8Price, saleTabRoom9Price, saleTabRoom10Price, saleTabRoom11Price, saleTabRoom12Price};
        TextField[] discounts = new TextField[] {saleTabRoom1Discount, saleTabRoom2Discount, saleTabRoom3Discount, saleTabRoom4Discount, saleTabRoom5Discount, saleTabRoom6Discount, saleTabRoom7Discount, saleTabRoom8Discount, saleTabRoom9Discount, saleTabRoom10Discount, saleTabRoom11Discount, saleTabRoom12Discount};

        int roomNumber = 0;
        int activeRooms = 0;
        for(Room room: RoomsManagement.rooms) {
            if(room.isBought()){
                panes[activeRooms].setVisible(true);
                names[activeRooms].setText(room.getName());
                preferredPrice[activeRooms].setText(String.valueOf(room.getPreferredPrice()));
                if(room.isActive()) {
                    buttons[activeRooms].setText("Uruchomiono");
                    if(!discounts[activeRooms].getText().equals("")) {
                        prices[activeRooms].setText(String.valueOf(room.getPrice() + Integer.parseInt(discounts[activeRooms].getText())));
                    } else {
                        prices[activeRooms].setText(String.valueOf(room.getPrice()));
                    }
                    prices[activeRooms].setDisable(true);
                    discounts[activeRooms].setDisable(true);
                } else {
                    buttons[activeRooms].setText("Uruchom");
                    prices[activeRooms].setDisable(false);
                    discounts[activeRooms].setDisable(false);
                }
                activeRooms++;
            } else {
                panes[roomNumber].setVisible(false);
            }
            roomNumber++;
        }
    }

    @FXML
    private void activateRoom(Event event) {
        TextField[] prices = new TextField[] {saleTabRoom1Price, saleTabRoom2Price, saleTabRoom3Price, saleTabRoom4Price, saleTabRoom5Price, saleTabRoom6Price, saleTabRoom7Price, saleTabRoom8Price, saleTabRoom9Price, saleTabRoom10Price, saleTabRoom11Price, saleTabRoom12Price};
        TextField[] discounts = new TextField[] {saleTabRoom1Discount, saleTabRoom2Discount, saleTabRoom3Discount, saleTabRoom4Discount, saleTabRoom5Discount, saleTabRoom6Discount, saleTabRoom7Discount, saleTabRoom8Discount, saleTabRoom9Discount, saleTabRoom10Discount, saleTabRoom11Discount, saleTabRoom12Discount};
        String buttonId = ((Control)event.getSource()).getId();
        String roomIdString = String.valueOf(buttonId.charAt(buttonId.length() - 2) + "" + buttonId.charAt(buttonId.length() - 1));
        int roomId = 0;
        if(roomIdString.charAt(0) == 'm') {
            roomId = Integer.parseInt(String.valueOf(roomIdString.charAt(1)));
        } else {
            roomId = Integer.parseInt(roomIdString);
        }
        if(!RoomsManagement.rooms[roomId - 1].isActive()) {
            int roomPrice = -1;
            if (!prices[roomId - 1].getText().equals("") && Integer.parseInt(prices[roomId - 1].getText()) > 0 && discounts[roomId - 1].getText().equals("")) {
                roomPrice = Integer.parseInt(prices[roomId - 1].getText());
            } else if (!prices[roomId - 1].getText().equals("") && Integer.parseInt(prices[roomId - 1].getText()) > 0 && !discounts[roomId - 1].getText().equals("")) {
                roomPrice = Integer.parseInt(prices[roomId - 1].getText()) - Integer.parseInt(discounts[roomId - 1].getText());
            }
            if (roomPrice > 0) {
                RoomsManagement.rooms[roomId - 1].setActive(true);
                RoomsManagement.rooms[roomId - 1].setPrice(roomPrice);
                generateSalePanes();
            }
        } else {
            RoomsManagement.rooms[roomId - 1].setActive(false);
            prices[roomId - 1].setText("");
            discounts[roomId - 1].setText("");
            generateSalePanes();
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

    @FXML
    private void markGameAsReady() {
        try {
            executeQuery("UPDATE hotelprojekt.hotel SET hotel_name = '" + CurrentlyPlayedGame.getCurrentGame().getHotelName() + "' WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";");
            executeQuery("UPDATE hotelprojekt.hotel SET hotel_mission = '" + CurrentlyPlayedGame.getCurrentGame().getHotelMission() + "' WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";");
            executeQuery("UPDATE hotelprojekt.hotel SET chosen_bank_id = " + ManageBanks.getCurrentlyChosenBank().getBankId() + " WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";");
            executeQuery("UPDATE hotelprojekt.hotel SET balance = " + CurrentlyPlayedGame.getBalance() + " WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";");
            for(Credit credit: Player.getCredits()) {
                executeQuery("INSERT INTO hotelprojekt.credit (credit_id, hotel_id, bank_id, start_month, full_amount, number_of_months) VALUES (DEFAULT, " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ", " + ManageBanks.getCurrentlyChosenBank().getBankId() + ", " + credit.getStartMonth() +", " + credit.getFullAmountOfCredit() + ", " + credit.getNumberOfMonths() + ");");
            }
            for(Deposit deposit: Player.getDeposits()) {
                executeQuery("INSERT INTO hotelprojekt.deposit (deposit_id, hotel_id, start_month, number_of_months, initial_rate, total_interest_value) VALUES (DEFAULT, " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ", " + deposit.getStartMonth() + ", " + deposit.getNumberOfMonths() + ", " + deposit.getInitialRate() + ", " + deposit.getTotalInterestValue() + ");");
            }
            executeQuery("UPDATE hotelprojekt.hotel SET revolving_credit_amount = '" + Player.getRevolvingCredit().getFullAmountOfRevolvingCredit() + "' WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";");
            int roomNumber = 1;
            for(Room room: RoomsManagement.rooms) {
                if(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() == 1) {
                    executeQuery("INSERT INTO hotelprojekt.room (room_id, hotel_id, room_number, is_bought, is_active, quality_bought, resources_1, resources_2, resources_3, price) VALUES (DEFAULT, " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ", " + roomNumber + ", " + room.isBought() + ", " + room.isActive() + ", " + room.getQualityBought() + ", " + ManageResources.getResources(roomNumber)[0] + ", " + ManageResources.getResources(roomNumber)[1] + ", " + ManageResources.getResources(roomNumber)[2] + ", " + room.getPrice() + ")");
                    roomNumber++;
                } else {
                    executeQuery("UPDATE hotelprojekt.room SET is_bought = " + room.isBought() + ", is_active = " + room.isActive() + ", quality_bought = " + room.getQualityBought() + ", resources_1 = " + ManageResources.getResources(roomNumber)[0] + ", resources_2 = " + ManageResources.getResources(roomNumber)[1] + ", resources_3 = " + ManageResources.getResources(roomNumber)[2] + ", price = " + room.getPrice() +  " WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + " AND room_number = " + roomNumber + ";");
                    roomNumber++;
                }
            }
            String query = "UPDATE hotelprojekt.hotel SET logo = ? WHERE hotel_id = " + CurrentlyPlayedGame.getCurrentGame().getHotelId() + ";";
            PreparedStatement pst = Connect.getConnection().prepareStatement(query);
            try (FileInputStream fin = new FileInputStream(CurrentlyPlayedGame.getCurrentGame().getHotelLogoFile())) {

                pst.setBinaryStream(1, fin, (int) CurrentlyPlayedGame.getCurrentGame().getHotelLogoFile().length());
                pst.executeUpdate();
            } catch (IOException ex) {
                System.out.println(ex);
            }

            ManageGame.markGameAsReady(CurrentlyPlayedGame.getCurrentGame().getGameId(), LoggedInAccount.getLoggedInAccount().getAccountId());
            //TODO wyłączenie gry do czasu przejścia do następnej rundy
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO usunąć
    @FXML
    private void up() {
        CurrentlyPlayedGame.getCurrentGame().setCurrentRound(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() + 1);
        checkDepositsAfterNewRound();
        creditNewRound();

        System.out.println("balance: " + CurrentlyPlayedGame.getBalance());
        if(CurrentlyPlayedGame.getBalance() < 0) {
            //wzięcie lub zwiększenie kredytu
            System.out.println("Odnawialny: " + (CurrentlyPlayedGame.getBalance() * -1));
            Player.getRevolvingCredit().getCredit((CurrentlyPlayedGame.getBalance() * -1));
        } else if(Player.getRevolvingCredit().getFullAmountOfRevolvingCredit() > 0) {
            //spłacenie kredytu
            System.out.println("Spłacam: " + CurrentlyPlayedGame.getBalance()  + " z: " + Player.getRevolvingCredit().getFullAmountOfRevolvingCredit());
            Player.getRevolvingCredit().payCredit(CurrentlyPlayedGame.getBalance());
        }

        Player.getRevolvingCredit().addInterest();
        revolvingCreditCheck();
        dashboardTabBankGenerateDataInBankOptions();
    }

    @FXML
    private void switchToGames() {
        try {
            App.setRoot("usermainscreen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void moneyUp() {
        CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + 10000);
        dashboardTabBankGenerateDataInBankOptions();
    }

    /**
     * Metoda aktualizująca lokaty po przejściu do nowej rundy.
     */
    private void checkDepositsAfterNewRound() {
        for(Deposit deposit: Player.getDeposits()) {
            if(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() == (deposit.getStartMonth() + deposit.getNumberOfMonths())) {
                CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() + deposit.endDeposit());
            } else if(CurrentlyPlayedGame.getCurrentGame().getCurrentRound() > (deposit.getStartMonth() + deposit.getNumberOfMonths())) {
                deposit.setActive(false);
            }
        }
    }

    private void creditNewRound() {
        for(Credit credit: Player.getCredits()) {
            if(credit.isActive()) {
                if (CurrentlyPlayedGame.getCurrentGame().getCurrentRound() == credit.getNumberOfMonths() + credit.getStartMonth()) {
                    CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - credit.getRestAmountOfCredit());
                    credit.setActive(false);
                    credit.setRestAmountOfCredit(0);
                } else {
                    CurrentlyPlayedGame.setBalance(CurrentlyPlayedGame.getBalance() - credit.getMonthlyPayment());
                    credit.setRestAmountOfCredit(credit.getRestAmountOfCredit() - credit.getMonthlyPayment());
                }
            }
        }
        viewCreditsTable();
        dashboardTabBankGenerateDataInBankOptions();
    }
}