package bankaccount;

public class Transaction {
    
    private String type;
    private double amount;
    
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    public String getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String toString(String type, double amount) {
        return type + " Php: " + amount;
    }

}
