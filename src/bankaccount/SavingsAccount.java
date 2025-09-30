//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

//import java.util.List;

public class SavingsAccount extends AbstractBankAccount {
    /** The name of the account owner. */
    private String ownerName;

    /**
     * Creates a new SavingsAccount for the specified owner.
     *
     * @param owner the account owner's name
     */
    public SavingsAccount(final String owner) {
        super();
        this.ownerName = owner;
    }

    /**
     * Returns the name of the account owner.
     *
     * @return the owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Main method to test SavingsAccount functionality.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) throws Exception {
//        // Test case 1: Add savings account to BankAccountManager.
//        BankAccountManager mngr = new BankAccountManager();
//        SavingsAccount acc = new SavingsAccount("Bilog");
//
//        mngr.addAccount(acc);
//        System.out.println("Account has been added. Balance: Php " + acc
//                .getBalance());
//
//        // Test case 2: Deposit with valid amount.
//        acc.deposit(1000);
//
//        // Test case 3: Deposit with zero amount.
//         acc.deposit(0);
//
//        // Test case 4: Deposit with negative amount.
//         acc.deposit(-500);
//
//        // Test case 5: Withdraw with sufficient funds.
//        acc.withdraw(500);
//
//        // Test case 6: Withdraw with insufficient funds.
//         acc.withdraw(1500);
//
//        // Test case 7: Withdraw with negative amount.
//         acc.withdraw(-100);
//
//        // Test case 8: Deposit when account is frozen.
//         acc.freezeAccount();
//         acc.deposit(500);
//
//        // Test case 9: Withdraw when account is frozen.
//         acc.freezeAccount();
//         acc.withdraw(500);
//
//        // Test case 10: Unfreeze account and withdraw.
//        acc.unfreezeAccount();
//        acc.withdraw(100);
//
//        // Test case 11: Check balance after multiple transactions.
//        System.out.println("Balance: Php " + acc.getBalance());
//
//        // Test case 12: Check transaction history above 500.
//        List<Transaction> history = acc.getTransactionHistory();
//        mngr.filterTransactionsAbove(500, history)
//        .forEach(System.out::println);s
//        // Test case 13: Check transaction history sorted by amount.
//        mngr.sortTransactionsByAmount(history).forEach(System.out::println);
//        //Test case 14: Handle invalid account object access
//        BankAccount invalid = mngr.getAccount(12);
//        invalid.deposit(100);
    }

}
