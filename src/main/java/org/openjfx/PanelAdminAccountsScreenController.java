package org.openjfx;

import account.authentication.LoginAccount;
import account.management.ManageAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PanelAdminAccountsScreenController {

    private ResultSet accounts;
    private int numberOfColumns;
    public static String[] columnKeys = new String[100];
    private final String[] columnNames = {"Login", "Imie", "Nazwisko", "Email"};

    @FXML
    private TableView usersTable;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() throws SQLException {
        viewTable();
    }

    /**
     * Metoda wyświetlająca tablicę ze wszystkimi graczami.
     */
    public void viewTable() {
        try {
            accounts = ManageAccount.getAccounts();
            usersTable.getItems().clear();
            usersTable.getColumns().clear();
            numberOfColumns = accounts.getMetaData().getColumnCount();

            for(int j = 1; j < numberOfColumns - 2; j++) {
                columnKeys[j] = accounts.getMetaData().getColumnName(j) + "Key";
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j - 1]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                usersTable.getColumns().add(col);
            }

            usersTable.getItems().setAll(generateDataInMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z użytkownikami.
     * @return ObservableList z użytkownikami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMap() throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        while (accounts.next()) {
            Map<String, String> dataRow = new HashMap<>();
            for (int j = 0; j < numberOfColumns; j++) {
                dataRow.put(columnKeys[j], accounts.getString(j + 1));
            }
            allData.add(dataRow);
        }
        return allData;
    }

    /**
     * Metoda pobierająca id wybranego gracza.
     * @return id wybranego gracza lub 0, jeśli żaden nie jest wybrany.
     */
    @FXML
    private int getUserId() {
        ObservableList selectedSession;
        selectedSession = usersTable.getSelectionModel().getSelectedItems();
        try {
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[3].split("=");
            System.out.println(selectedSession.get(0).toString());
            System.out.println(daneSplit2[1]);
            System.out.println(Integer.parseInt(ManageAccount.getUserInfo(daneSplit2[1])[5]));
            return Integer.parseInt(ManageAccount.getUserInfo(daneSplit2[1])[5]);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
     * Metoda przełączająca na createaccountscreen
     * @throws IOException
     */
    @FXML
    private void switchToAddAccount() throws IOException {
        App.setRoot("createaccountscreen");
    }

    /**
     * Metoda przełączająca na editaccountscreen
     * @throws IOException
     */
    @FXML
    private void switchToEditAccount() throws IOException {
        PanelAdminScreenController.setEditUserId(getUserId());
        App.setRoot("editaccountscreen");
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
