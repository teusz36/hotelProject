package account;

/**
 * Klasa reprezentująca konto. Istnieją dwa rodzaje kont. Konto zarządzającego rozgrywką i konto gracza.
 */
public class Account {
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int accountType;

    public static int PLAYER = 1;
    public static int GAME_ADMIN = 2;

    public Account(String username, String name, String lastName, String email, String password, int accountType) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object object) {
        if(object != null) {
            return this.username.equals(((Account) object).username) &&
                    this.name.equals(((Account) object).name) &&
                    this.lastName.equals(((Account) object).lastName) &&
                    this.email.equals(((Account) object).email) &&
                    this.password.equals(((Account) object).password) &&
                    this.accountType == ((Account) object).accountType;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
