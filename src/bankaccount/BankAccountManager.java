package bankaccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {
    Map<Integer, BankAccount> accounts;
    int nextAccountId;
    
    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.nextAccountId = 1;
    }
    
    void addAccount(BankAccount account) {
        accounts.put(nextAccountId++, account);
        
    }
    
    BankAccount getAccount(int accountId) {
        return accounts.get(accountId);
    }
    
    void listAccounts() {
        
    }
 
}
