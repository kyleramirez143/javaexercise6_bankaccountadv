//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

import java.util.List;

public interface BankAccount {
    /** Deposits an amount to the account.
     * @param amount
     * @throws Exception if the account is frozen or amount is not positive*/
    void deposit(double amount) throws Exception;
    /** Withdraws an amount to the account.
     * @param amount
     * @throws Exception if the account is frozen or amount is not positive*/
    void withdraw(double amount) throws Exception;
    /** Balance getter.
     * @return balance */
    double getBalance();
    /** Checks whether the account is frozen.
     * @return status of the account*/
    boolean isFrozen();
    /** List of transaction history.
     * @return a list of transaction history of the account
     */
    List<Transaction> getTransactionHistory();
}
