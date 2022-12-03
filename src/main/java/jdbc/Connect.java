package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasa odpowiedzialna za połączenie z bazą danych PostgreSQL
 */
public class Connect {

    private String driver = "org.postgresql.Driver";

    private String host = "195.150.230.210";

    private String port = "5436";//wymagane kiedy nie jest domyślny dla bazy

    private String dbname = ""; //nazwa bazy
    private String user = ""; //student

    private String url = "";
    private String pass = ""; //hasło
    private static Connection connection;

    /**
     * Konstruktor tworzący obiekt połączenia z bazą.
     * @param host adres hosta bazy.
     * @param port port, na którym aplikacja łączy się z bazą.
     * @param dbname nazwa bazy, z którą nawiązuje się połączenie.
     * @param user nazwa użytkownika bazy danych.
     * @param pass hasło użytkownika bazy danych.
     */
    public Connect (String host, String port, String dbname, String user, String pass) {
        this.host = host;
        this.port = port;
        this.dbname = dbname;
        this.user = user;
        this.pass = pass;
        connection = makeConnection();
    }

    /**
     * Metoda pozwalająca na uzyskanie obiektu połączenia z bazą.
     * @return statyczny obiekt Connection
     */
    public static Connection getConnection(){
        return(connection);
    }

    /**
     * Metoda służąca do zamknięcia połączenia z bazą.
     */
    public void close() {
        try {
            connection.close(); }

        catch (SQLException sqle){
            System.err.println("Blad przy zamykaniu polaczenia: " + sqle);

        } }

    /**
     * Metoda do nawiązywania połączenia z bazą.
     * @return obiekt klasy Connection będący połączeniem z bazą.
     */
    public Connection makeConnection(){
        url = "jdbc:postgresql://" + host+":"+port + "/" + dbname;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            return(connection);

        }
        catch(ClassNotFoundException cnfe) {
            System.err.println("Blad ladowania sterownika: " + cnfe);

            return(null);
        }
        catch(SQLException sqle) {
            System.err.println("Blad przy nawiązywaniu polaczenia: " + sqle);

            return(null);
        }
    }

    /**
     * Setter ustawiający host dla połączenia.
     * @param host adres hosta bazy.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Setter ustawiający port połączenia z bazą.
     * @param port port, na którym aplikacja łączy się z bazą.
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Setter ustawiający nazwę bazy, z którą nawiązuje się połączenie.
     * @param dbname nazwa bazy, z którą nawiązuje się połączenie.
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    /**
     * Setter ustawiający nazwę użytkownika.
     * @param user nazwa użytkownika bazy danych.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Setter ustawiający hasło użytkownika.
     * @param pass hasło użytkownika bazy danych.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}