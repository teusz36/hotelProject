package org.openjfx;

import account.Account;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import game.management.ManageGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static jdbc.DataManager.executeQuery;

public class PanelAdminAddGameScreenController {

    private ResultSet allUsers;
    private ResultSet selectedUsers;

    {
        try {
            selectedUsers = executeQuery("SELECT * FROM hotelprojekt.users WHERE account_type = 1 and ACCOUNT_TYPE != 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int numberOfColumns;
    public static String[] columnKeys = new String[100];
    private final String[] columnNames = {"Login", "Imie", "Nazwisko", "Email"};
    private String[] selectedUsersId = new String[100];
    private int numberOfSelectedUsers = 0;

    @FXML
    private TableView allUsersTable;

    @FXML
    private TableView selectedUsersTable;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() throws SQLException {
        viewAllUsersTable();
    }

    /**
     * Metoda wyświetlająca tablicę ze wszystkimi użytkownikami.
     */
    public void viewAllUsersTable() {
        try {
            String selectedUsersIdString = "";
            if(numberOfSelectedUsers > 0) {
                selectedUsersIdString = selectedUsersId[0];
                for(int i = 1; i < numberOfSelectedUsers; i++) {
                    selectedUsersIdString = selectedUsersIdString + ", " + selectedUsersId[i];
                }
            }
            System.out.println(selectedUsersIdString);
            allUsers = ManageAccount.getAccountsExcept(selectedUsersIdString);
            allUsersTable.getItems().clear();
            allUsersTable.getColumns().clear();
            numberOfColumns = allUsers.getMetaData().getColumnCount();

            for(int j = 1; j < numberOfColumns - 2; j++) {
                columnKeys[j] = allUsers.getMetaData().getColumnName(j) + "Key";
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j - 1]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                allUsersTable.getColumns().add(col);
            }

            allUsersTable.getItems().setAll(generateDataInMapAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z grami.
     * @return ObservableList z grami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMapAllUsers() throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        while (allUsers.next()) {
            Map<String, String> dataRow = new HashMap<>();
            for (int j = 0; j < numberOfColumns; j++) {
                dataRow.put(columnKeys[j], allUsers.getString(j + 1));
            }
            allData.add(dataRow);
        }
        return allData;
    }

    /**
     * Metoda wyświetlająca tablicę z wybranymi użytkownikami.
     */
    public void viewSelectedUsersTable() {
        try {
            selectedUsersTable.getItems().clear();
            selectedUsersTable.getColumns().clear();
        } catch (Exception e) {

        }
        try {
            numberOfColumns = selectedUsers.getMetaData().getColumnCount();
            for(int j = 1; j < numberOfColumns - 2; j++) {
                columnKeys[j] = selectedUsers.getMetaData().getColumnName(j) + "Key";
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j - 1]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                selectedUsersTable.getColumns().add(col);
            }

            selectedUsersTable.getItems().setAll(generateDataInMapSelectedUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z grami.
     * @return ObservableList z grami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMapSelectedUsers() throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        while (selectedUsers.next()) {
            Map<String, String> dataRow = new HashMap<>();
            for (int j = 0; j < numberOfColumns; j++) {
                dataRow.put(columnKeys[j], selectedUsers.getString(j + 1));
            }
            allData.add(dataRow);
        }
        return allData;
    }

    /**
     * Metoda pobierająca id wybranej gry.
     * @return id wybranej gry lub 0, jeśli żadna nie jest wybrana.
     */
    @FXML
    private int getGameId() {
        try {
            ObservableList selectedSession;
            selectedSession = allUsersTable.getSelectionModel().getSelectedItems();
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[2].split("=");
            System.out.println(selectedSession.get(0).toString());
            System.out.println(daneSplit2[1]);
            return Integer.parseInt(daneSplit2[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @FXML
    private void addUser() throws SQLException {
        try {
            ObservableList selectedSession;
            selectedSession = allUsersTable.getSelectionModel().getSelectedItems();
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[3].split("=");
            selectedUsersId[numberOfSelectedUsers] = ManageAccount.getUserInfo(daneSplit2[1])[5];
            numberOfSelectedUsers++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String selectedUsersIdString = "";
        if(numberOfSelectedUsers > 0) {
            selectedUsersIdString = selectedUsersId[0];
            for(int i = 1; i < numberOfSelectedUsers; i++) {
                selectedUsersIdString = selectedUsersIdString + ", " + selectedUsersId[i];
            }
        }
        System.out.println(selectedUsersIdString);
        selectedUsers = executeQuery("SELECT * FROM hotelprojekt.users WHERE user_id IN (" + selectedUsersIdString + ");");
        viewSelectedUsersTable();
        viewAllUsersTable();
    }

    @FXML
    private void removeUser() throws SQLException {
        try {
            ObservableList selectedSession;
            selectedSession = selectedUsersTable.getSelectionModel().getSelectedItems();
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[3].split("=");
            String[] newSelectedUsers = new String[100];
            int newNumberOfSelectedUsers = 0;
            for(int i = 0; i < numberOfSelectedUsers; i++) {
                if(!selectedUsersId[i].equals(ManageAccount.getUserInfo(daneSplit2[1])[5])){
                    newSelectedUsers[newNumberOfSelectedUsers] = selectedUsersId[i];
                    newNumberOfSelectedUsers++;
                }
            }
            selectedUsersId = newSelectedUsers;
            for(int i = 0; i < numberOfSelectedUsers; i++) {
                System.out.println("s: " + selectedUsersId[i]);
            }
            numberOfSelectedUsers--;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String selectedUsersIdString = "";
        if(numberOfSelectedUsers > 0) {
            selectedUsersIdString = selectedUsersId[0];
            for(int i = 1; i < numberOfSelectedUsers; i++) {
                selectedUsersIdString = selectedUsersIdString + ", " + selectedUsersId[i];
            }
        }
        System.out.println(selectedUsersIdString);
        selectedUsers = executeQuery("SELECT * FROM hotelprojekt.users WHERE user_id IN (" + selectedUsersIdString + ");");
        viewSelectedUsersTable();
        viewAllUsersTable();
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
     * Metoda przełączająca na paneladmingamesscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccounts() throws IOException {
        App.setRoot("paneladminaccountsscreen");
    }

    /**
     * Metoda dodająca nową grę.
     * @throws IOException
     */
    @FXML
    private void addGame() throws IOException, SQLException {
        if(numberOfSelectedUsers > 0) {
            String gameId = "";
            executeQuery("INSERT INTO hotelprojekt.game (game_id, current_round) VALUES (DEFAULT, DEFAULT);");
            ResultSet rs = executeQuery("SELECT MAX(game_id) FROM hotelprojekt.game;");
            while (rs.next()) {
                gameId = rs.getString(1);
            }
            for(int i = 0; i < numberOfSelectedUsers; i++) {
                executeQuery("INSERT INTO hotelprojekt.game_users (game_id, user_id) VALUES (" + gameId + ", " + selectedUsersId[i] + ");");
            }
            App.setRoot("paneladmingamesscreen");
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
