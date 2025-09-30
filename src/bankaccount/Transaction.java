//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

public class Transaction {
    /** Type of transaction. */
    private String type;
    /** Amount of transaction. */
    private double amount;

    /**
     * Transaction class constructor.
     * @param transactType
     * @param transactAmount
     */
    public Transaction(final String transactType, final double transactAmount) {
        this.type = transactType;
        this.amount = transactAmount;
    }

    /**
     * Transaction type getter.
     * @return type of transaction
     */
    public String getType() {
        return type;
    }

    /**
     * Transaction amount getter.
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Merges and convert the type and amount to string.
     * @return type and amount
     */
    public String toString() {
        return type + ": Php " + amount;
    }

}
