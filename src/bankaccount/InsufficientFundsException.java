//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

public class InsufficientFundsException extends Exception {
    /** Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /** InsufficientFundsException constructor.
     * @param message
     */
    public InsufficientFundsException(final String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    /** Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /** InvalidAmountException constructor.
     * @param message
     */
    InvalidAmountException(final String message) {
        super(message);
    }
}

class AccountFrozenException extends Exception {
    /** Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /** AccountFrozenException constructor.
     * @param message
     */
    AccountFrozenException(final String message) {
        super(message);
    }
}

