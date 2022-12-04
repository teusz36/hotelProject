package org.openjfx;

import account.authentication.LoginAccount;
import account.management.ManageAccount;
import display.GameDisplayer;
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

public class PanelAdminGamesScreenController {

    private ResultSet games;
    private int numberOfColumns;
    public static String[] columnKeys = new String[100];
    private final String[] columnNames = {"Id gry", "Data rozpoczęcia", "Data zakończenia", "Gra aktywna", "Obecna runda", "Liczba użytkowników"};

    @FXML
    private TableView gamesTable;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() throws SQLException {
        viewTable();
    }

    /**
     * Metoda wyświetlająca tablicę ze wszystkimi grami.
     */
    public void viewTable() {
        try {
            games = ManageGame.getGames();
            gamesTable.getItems().clear();
            gamesTable.getColumns().clear();
            numberOfColumns = games.getMetaData().getColumnCount();

            for(int j = 0; j < numberOfColumns; j++) {
                columnKeys[j] = games.getMetaData().getColumnName(j+1) + "Key";
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                gamesTable.getColumns().add(col);
            }
            TableColumn<Map, String> col = new TableColumn<>("Gotowa do przeniesienia");
            col.setCellValueFactory(new MapValueFactory(columnKeys[numberOfColumns]));
            gamesTable.getColumns().add(col);

            gamesTable.getItems().setAll(generateDataInMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z grami.
     * @return ObservableList z grami.
     * @throws SQLException
     */
    private ObservableList<Map> generateDataInMap() throws SQLException {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        while (games.next()) {
            Map<String, String> dataRow = new HashMap<>();
            for (int j = 0; j < numberOfColumns; j++) {
                if(games.getString(j + 1) != null) {
                    if (games.getString(j + 1).equals("t")) {
                        dataRow.put(columnKeys[j], "tak");
                    } else if (games.getString(j + 1).equals("f")) {
                        dataRow.put(columnKeys[j], "nie");
                    } else {
                        dataRow.put(columnKeys[j], games.getString(j + 1));
                    }
                } else {
                    dataRow.put(columnKeys[j], games.getString(j + 1));
                }
            }
            if(ManageGame.isGameReady(games.getString(1))) {
                dataRow.put(columnKeys[numberOfColumns], "tak");
            } else {
                dataRow.put(columnKeys[numberOfColumns], "nie");
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
            selectedSession = gamesTable.getSelectionModel().getSelectedItems();
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

    /**
     * Metoda pobierająca numer rundy wybranej gry.
     * @return numer rundy wybranej gry.
     */
    @FXML
    private int getGameNumber() {
        try {
            ObservableList selectedSession;
            selectedSession = gamesTable.getSelectionModel().getSelectedItems();
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[4].split("=");
            return Integer.parseInt(daneSplit2[1]);
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
     * Metoda przełączająca na paneladmingamesscreen
     * @throws IOException
     */
    @FXML
    private void switchToAccounts() throws IOException {
        App.setRoot("paneladminaccountsscreen");
    }

    /**
     * Metoda przełączająca na createaccountscreen
     * @throws IOException
     */
    @FXML
    private void switchToAddGame() throws IOException {
        App.setRoot("paneladminaddgamescreen");
    }

    /**
     * Metoda przenosząca grę do następnej rundy.
     * @throws IOException
     */
    @FXML
    private void moveGameToNextRound() throws SQLException, IOException {
        if(ManageGame.isGameReady(String.valueOf(getGameId()))) {
            ManageGame.moveGameToNextRound(getGameId(), getGameNumber() + 1);
        }
        App.setRoot("paneladmingamesscreen");
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
