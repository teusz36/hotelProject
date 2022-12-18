package account;

public class AccountException extends Exception{
    public AccountException() {}

    public AccountException(String errorMessage) {
        super(errorMessage);
    }
}
