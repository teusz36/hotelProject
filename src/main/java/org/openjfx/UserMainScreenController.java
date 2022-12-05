package org.openjfx;

import account.authentication.LoggedInAccount;
import account.authentication.LoginAccount;
import account.management.ManageAccount;
import display.GameDisplayer;
import game.Game;
import game.management.CurrentlyPlayedGame;
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

public class UserMainScreenController {

    private ResultSet games;
    private int numberOfColumns;
    public static String[] columnKeys = new String[100];
    private final String[] columnNames = {"Id gry", "Data rozpoczęcia", "Data zakończenia", "Gra aktywna", "Obecna runda", "Liczba użytkowników"};

    @FXML
    private TableView userGamesTable;

    /**
     * Metoda inicjalizująca. Wywoływana przy tworzeniu okna.
     */
    public void initialize() throws SQLException {
        viewTable();
    }

    /**
     * Metoda wyświetlająca tablicę z grami gracza.
     */
    public void viewTable() {
        try {
            games = GameDisplayer.getUserGames(String.valueOf(ManageAccount.getUserId(LoggedInAccount.getLoggedInAccount().getUsername())));
            userGamesTable.getItems().clear();
            userGamesTable.getColumns().clear();
            numberOfColumns = games.getMetaData().getColumnCount();

            for(int j = 0; j < numberOfColumns; j++) {
                columnKeys[j] = games.getMetaData().getColumnName(j+1) + "Key";
                TableColumn<Map, String> col = new TableColumn<>(columnNames[j]);
                col.setCellValueFactory(new MapValueFactory(columnKeys[j]));
                userGamesTable.getColumns().add(col);
            }
            TableColumn<Map, String> col = new TableColumn<>("Gotowa do przeniesienia");
            col.setCellValueFactory(new MapValueFactory(columnKeys[numberOfColumns]));
            userGamesTable.getColumns().add(col);

            userGamesTable.getItems().setAll(generateDataInMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda generująca dane do tabeli z grami.
     * @return ObservableList z użytkownikami.
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

    @FXML
    private void playSelectedGame() {
        try {
            ObservableList selectedSession;
            selectedSession = userGamesTable.getSelectionModel().getSelectedItems();
            String[] daneSplit = selectedSession.get(0).toString().split(",");
            String[] daneSplit2 = daneSplit[2].split("=");
            ResultSet gameInfo = GameDisplayer.getGameByID(daneSplit2[1]);
            while (gameInfo.next()) {
                CurrentlyPlayedGame.setCurrentGame(new Game(gameInfo.getString(1), gameInfo.getString(5), gameInfo.getString(4), ManageGame.isGameReady(gameInfo.getString(1)), gameInfo.getString(6)));
            }
            App.setRoot("gamedashboard");
        } catch (Exception e) {
            System.out.println("Nie wybrano gry");
        }
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
