//Code Reviewer: Cherlize Janelle Cuevas
package bankaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    /** SavingsAccount instance. */
    private SavingsAccount account;
    /** BankAccountManager instance. */
    private BankAccountManager manager;
    /** Constant for Php 1000. */
    private static final int P_1000 = 1000;
    /** Constant for Php 500. */
    private static final int P_500 = 500;
    /** Constant for negative Php 500. */
    private static final int NP_500 = -500;
    /** Constant for Php 1500. */
    private static final int P_1500 = 1500;
    /** Constant for Php 100. */
    private static final int P_100 = 100;
    /** Constant for negative Php 100. */
    private static final int NP_100 = -100;
    /** Constant for Php 900. */
    private static final int P_900 = 900;
    /** Constant for Php 600. */
    private static final int P_600 = 600;
    /** Constant for delta. */
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        manager = new BankAccountManager();
        account = new SavingsAccount("Bilog");
        manager.addAccount(account);
    }

    @DisplayName("Test account creation")
    @Test
    void testAddAccount() throws Exception {
        assertNotNull(manager.getAccount(1));
        assertEquals(0, account.getBalance(), DELTA);
        assertEquals("Bilog", account.getOwnerName());
    }

    @DisplayName("Test amount deposit")
    @Test
    void testDepositValidAmount() throws Exception {
        account.deposit(P_1000);
        assertEquals(P_1000, account.getBalance(), DELTA);
    }

    @DisplayName("Test deposit with zero amount")
    @Test
    void testDepositZeroAmountThrowsException() throws Exception {
        assertThrows(InvalidAmountException.class, () -> account.deposit(0));
    }

    @DisplayName("Test deposit with negative amount")
    @Test
    void testDepositNegativeAmountThrowsException() throws Exception {
        assertThrows(InvalidAmountException.class, () -> account.deposit(
                NP_500));
    }

    @DisplayName("Test withdraw amount")
    @Test
    void testWithdrawAmount() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        assertEquals(P_500, account.getBalance(), DELTA);
    }

    @DisplayName("Test withdraw insufficient funds")
    @Test
    void testWithdrawWithInsufficientFundsThrowsException() throws Exception {
        account.deposit(P_1000);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(
                P_1500));
    }

    @DisplayName("Test withdraw negative amount")
    @Test
    void testWithdrawNegativeAmountThrowsException() throws Exception {
        account.deposit(P_1000);
        assertThrows(InvalidAmountException.class, () -> account.withdraw(
                NP_100));
    }

    @DisplayName("Test deposit when account is frozen")
    @Test
    void testDepositWhenFrozenThrowsException() throws Exception {
        account.freezeAccount();
        assertThrows(AccountFrozenException.class, () -> account.deposit(
                P_500));
    }

    @DisplayName("Test withdraw when account is frozen")
    @Test
    void testWithdrawWhenFrozenThrowsException() throws Exception {
        account.deposit(P_1000);
        account.freezeAccount();
        assertThrows(AccountFrozenException.class, () -> account.deposit(
                P_500));
    }

    @DisplayName("Test unfreeze and withdraw")
    @Test
    void testUnfreezeAndWithdraw() throws Exception {
        account.deposit(P_1000);
        account.freezeAccount();
        account.unfreezeAccount();
        account.withdraw(P_100);
        assertEquals(P_900, account.getBalance(), DELTA);
    }

    @DisplayName("Test balance after multiple transactions")
    @Test
    void testBalanceAfterMultipleTransactions() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        account.deposit(P_100);
        assertEquals(P_600, account.getBalance(), DELTA);
    }

    @DisplayName("Test filter transactions above")
    @Test
    void testFilterTransactionsAbove() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        account.deposit(P_100);
        List<Transaction> filtered = manager.filterTransactionsAbove(P_500,
                account.getTransactionHistory());
        assertEquals(2, filtered.size());
        assertEquals("Deposit", filtered.get(0).getType());
    }

    @DisplayName("Test sort transactions by amount")
    @Test
    void testSortTransactionsByAmount() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        account.deposit(P_100);
        List<Transaction> sorted = manager.sortTransactionsByAmount(account
                .getTransactionHistory());
        assertEquals(P_100, sorted.get(0).getAmount(), DELTA);
        assertEquals(P_500, sorted.get(1).getAmount(), DELTA);
        assertEquals(P_1000, sorted.get(2).getAmount(), DELTA);
    }

    @DisplayName("Test handle invalid account access")
    @Test
    void testInvalidAccountAccessHandling() {
        assertThrows(NullPointerException.class, () -> {
            BankAccount invalid = manager.getAccount(P_100);
            invalid.deposit(P_100);
        });

    }

    @DisplayName("Test Transaction to string output")
    @Test
    void testTransactionToString() {
        Transaction deposit = new Transaction("Deposit", P_1000);
        Transaction withdraw = new Transaction("Withdraw", P_500);

        assertEquals("Deposit: Php 1000.0", deposit.toString().trim());
        assertEquals("Withdraw: Php 500.0", withdraw.toString().trim());
    }
}
