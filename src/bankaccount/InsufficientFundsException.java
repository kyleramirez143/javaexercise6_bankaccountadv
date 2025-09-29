package bankaccount;

public class InsufficientFundsException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountFrozenException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AccountFrozenException(String message) {
        super(message);
    }
}

