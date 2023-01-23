package org.openjfx;

import account.authentication.LoginAccount;
import account.management.ManageAccount;
import display.GameDisplayer;
import game.management.CurrentlyPlayedGame;
import game.management.ManageGame;
import game.room.RoomsManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static jdbc.DataManager.executeQuery;

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
    private int getRoundNumber() {
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
        int gameID = getGameId();
        if(ManageGame.isGameReady(String.valueOf(gameID))) {
            ResultSet usersNumber = executeQuery("select COUNT(*) from hotelprojekt.game g LEFT JOIN hotelprojekt.game_users gu ON g.game_id = gu.game_id WHERE g.game_id = " + gameID + ";");
            usersNumber.next();
            ResultSet users = executeQuery("select gu.user_id, gu.hotel_id, g.current_round from hotelprojekt.game g LEFT JOIN hotelprojekt.game_users gu ON g.game_id = gu.game_id WHERE g.game_id = " + gameID + ";");
            while(users.next()) {
                int userID = users.getInt(1);
                int hotelID = users.getInt(2);
                int roundNumber = users.getInt(3);
                int totalEarnedMoney = 0;
                int totalNumberOfSales = 0;
                StringBuilder interestInRooms = new StringBuilder();
                StringBuilder soldRooms = new StringBuilder();

                ResultSet rooms = executeQuery("SELECT room_id, room_number, is_bought, is_active, quality_bought, resources_1, resources_2, resources_3, price FROM hotelprojekt.room WHERE hotel_id = " + hotelID + ";");
                while (rooms.next()) {
                    if(rooms.getBoolean(3) && rooms.getBoolean(4)) {
                        int roomID = rooms.getInt(1);
                        int roomNumber = rooms.getInt(2);
                        int qualityBought = rooms.getInt(5);
                        int resources1 = rooms.getInt(6);
                        int resources2 = rooms.getInt(7);
                        int resources3 = rooms.getInt(8);
                        int price = rooms.getInt(9);
                        double seasonalityRate = RoomsManagement.rooms[roomNumber - 1].getSeasonality()[roundNumber - 1];

                        int numberOfClientsArrivedAtHotel = (int) ((RoomsManagement.rooms[roomNumber - 1].getYearlyDemand() / 12) * seasonalityRate);



                        System.out.println("Pokój nr. " + (roomNumber - 1) + " jest aktywny i kupiony z jakością: " + qualityBought + ".");
                        System.out.println("Zasoby 1*: " + resources1 + ", zasoby 2*: " + resources2 + ", zasoby 3*: " + resources3);
                        System.out.println("Cena: " + price);
                        System.out.println("Do pokoju przybyło: " + numberOfClientsArrivedAtHotel + " klientów.");



                        int numberOfClientsHotelCanServe;

                        int resourcesSum = resources1 + resources2 + resources3;
                        if(numberOfClientsArrivedAtHotel <= resourcesSum) {
                            numberOfClientsHotelCanServe = numberOfClientsArrivedAtHotel;
                        } else {
                            numberOfClientsHotelCanServe = resourcesSum;
                        }
                        System.out.println("Hotel może obsłużyć " + numberOfClientsHotelCanServe + " klientów.");
                        interestInRooms.append(numberOfClientsArrivedAtHotel + ",");
                        int numberOfClientsWhoBoughtRoom = 0;
                        double preferredPriceWithRoomQuality;
                        preferredPriceWithRoomQuality = RoomsManagement.rooms[roomNumber - 1].getPreferredPrice();
                        switch (qualityBought) {
                            case 1:
                                preferredPriceWithRoomQuality *= 1.1;
                                break;
                            case 2:
                                preferredPriceWithRoomQuality *= 1.2;
                        }
                        int numberOfClientsHotelCanServeTmp = numberOfClientsHotelCanServe;
                        while (numberOfClientsHotelCanServeTmp > 0) {
                            System.out.println("----- klient " + (numberOfClientsHotelCanServe - numberOfClientsHotelCanServeTmp + 1));
                            double roomPrefPrice = preferredPriceWithRoomQuality;
                            int resourcesActive = 0;
                            if(resources3 > 0) {
                                roomPrefPrice *= 1.2;
                                resourcesActive = 2;
                            } else if(resources2 > 0) {
                                roomPrefPrice *= 1.1;
                                resourcesActive = 1;
                            }
                            int roomReservationProbability = 0;
                            if(roomPrefPrice + 10 > price) {
                                roomReservationProbability = 10;
                            } else if(roomPrefPrice + 20 > price) {
                                roomReservationProbability = 8;
                            } else if(roomPrefPrice + 30 > price) {
                                roomReservationProbability = 5;
                            } else if(roomPrefPrice + 40 > price) {
                                roomReservationProbability = 2;
                            }
                            int randRoomReserv = new Random().nextInt(11);
                            System.out.println("Preferowana cena przy jakości " + resourcesActive + ": " + roomPrefPrice);
                            System.out.println("Prawdopodobieństwo zakupu: " + roomReservationProbability + " wylosowano: " + randRoomReserv);
                            if(roomReservationProbability >= randRoomReserv) {
                                //klient kupił pokój
                                System.out.println("Pokój kupiony");
                                numberOfClientsWhoBoughtRoom++;
                                totalNumberOfSales++;
                                switch (resourcesActive) {
                                    case 2:
                                        resources3--;
                                        break;
                                    case 1:
                                        resources2--;
                                        break;
                                    case 0:
                                        resources1--;
                                        break;
                                }
                            } else {
                                //klient nie kupił pokoju
                                System.out.println("Pokój nie kupiony");
                            }
                            numberOfClientsHotelCanServeTmp--;
                        }

                        totalEarnedMoney += price * numberOfClientsWhoBoughtRoom;
                        soldRooms.append( numberOfClientsWhoBoughtRoom + ",");

                        executeQuery("UPDATE hotelprojekt.room SET resources_1 = " + resources1 + ", resources_2 = " + resources2 + ", resources_3 = " + resources3 + " WHERE room_id = " + roomID + ";");

                        System.out.println(numberOfClientsWhoBoughtRoom + " klientów kupiło pokój");
                        System.out.println("res1: " + resources1 + ", res2: " + resources2 + ", res3: " + resources3);
                        System.out.println("=================");
                    }
                }
                ResultSet rs1 = executeQuery("SELECT balance FROM hotelprojekt.hotel WHERE hotel_id = " + hotelID + ";");
                int balanceOld = 0;
                while (rs1.next()) {
                    balanceOld = rs1.getInt(1);
                }
                int balanceNew = balanceOld + totalEarnedMoney;

                ResultSet rs2 = executeQuery("SELECT b.account_cost, b.card_cost, a.single_cost, a.full_cost, a.law_cost, h.profit_last_round FROM hotelprojekt.hotel h LEFT JOIN hotelprojekt.bank b ON h.chosen_bank_id = b.bank_id LEFT JOIN hotelprojekt.accounting a ON h.chosen_accounting_id = a.accounting_id WHERE hotel_id = " + hotelID + ";");
                int totalCost = 0;
                int profitDB = 0;
                while (rs2.next()) {
                    int accountCost = rs2.getInt(1);
                    int cardCost = rs2.getInt(2);
                    int singleCost = rs2.getInt(3);
                    profitDB = rs2.getInt(6);
                    totalCost = accountCost + cardCost + (singleCost * totalNumberOfSales);
                }
                balanceNew -= totalCost;
                executeQuery("UPDATE hotelprojekt.hotel SET balance = " + balanceNew + " WHERE hotel_id = " + hotelID);
                executeQuery("UPDATE hotelprojekt.hotel SET number_of_sales_in_prev_round = " + totalNumberOfSales + " WHERE hotel_id = " + hotelID);
                executeQuery("UPDATE hotelprojekt.hotel SET tab_of_interest_in_prev_round = '" + interestInRooms + "' WHERE hotel_id = " + hotelID);
                System.out.println("UPDATE hotelprojekt.hotel SET tab_of_interest_in_prev_round = '" + interestInRooms + "' WHERE hotel_id = " + hotelID);
                executeQuery("UPDATE hotelprojekt.hotel SET tab_of_sales_in_prev_round = '" + soldRooms + "' WHERE hotel_id = " + hotelID);
                executeQuery("UPDATE hotelprojekt.hotel SET income_last_round = " + totalEarnedMoney + " WHERE hotel_id = " + hotelID);
                executeQuery("UPDATE hotelprojekt.hotel SET profit_last_round = " + (profitDB + totalEarnedMoney - totalCost) + " WHERE hotel_id = " + hotelID);

                System.out.println("profitDB, totalEarnedMoney, totalCost " + profitDB + ", " + totalEarnedMoney + ", " + totalCost);
                System.out.println("\nRazem zarobiono " + totalEarnedMoney + " i sprzedano " + totalNumberOfSales + " pokoi");
                System.out.println("Całkowity koszt wyniósł: " + totalCost);
            }

            ResultSet rsProfit = executeQuery("SELECT h.hotel_id FROM hotelprojekt.hotel h LEFT JOIN hotelprojekt.game_users gu ON h.hotel_id = gu.hotel_id WHERE gu.game_id = " + gameID + " ORDER BY h.profit_last_round;");
            int place = 1;
            while (rsProfit.next()) {
                int hotelID = rsProfit.getInt(1);
                executeQuery("UPDATE hotelprojekt.hotel SET place = " + place + " WHERE hotel_id = " + hotelID);
                place++;
            }
            if(getRoundNumber() < 12) {
                ManageGame.moveGameToNextRound(gameID, getRoundNumber() + 1);
            } else {
                executeQuery("UPDATE hotelprojekt.game SET isongoing = false, end_date = CURRENT_TIMESTAMP WHERE game_id = " + gameID);
            }
        }
        App.setRoot("paneladmingamesscreen");
    }

    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("adminaccountscreen");
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
