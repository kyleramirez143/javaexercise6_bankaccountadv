//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountManager {
    /** Accounts hashmap. */
    private Map<Integer, BankAccount> accounts;
    /** Account ID. */
    private int nextAccountId;

    /**
     * Constructs a BankAccountManager.
     */
    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.nextAccountId = 1;
    }

    /**
     * Adds an account to the list.
     * @param account
     */
    public void addAccount(final BankAccount account) {
        accounts.put(nextAccountId++, account);

    }

    /**
     * Gets an account from the list.
     * @param accountId
     * @return BankAccount object mapped to the accountId
     * @throws Exception
     */
    public BankAccount getAccount(final int accountId) throws Exception {
        return accounts.get(accountId);
    }

    final void listAccounts() {
        for (BankAccount a : accounts.values()) {
            System.out.println(((SavingsAccount) a).getOwnerName() + ": Php "
                    + a.getBalance());
        }
    }

    /** Filters the transactions using the amount specified.
     * @param amount
     * @param txList
     * @return filtered list of transactions
     */
    public List<Transaction> filterTransactionsAbove(final double amount,
            final List<Transaction> txList) {
        return txList.stream().filter(tx -> tx.getAmount() >= amount).collect(
                Collectors.toList());
    }
    /**
     * Sort the transactions by amount in ascending order.
     * @param txList
     * @return sorted transactions list
     */
    public List<Transaction> sortTransactionsByAmount(
            final List<Transaction> txList) {
        return txList.stream().sorted((t1, t2) -> Double.compare(t1.getAmount(),
                t2.getAmount())).collect(Collectors.toList());

    }

}
