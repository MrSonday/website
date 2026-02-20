public class Q4{
    public static void main(String[] args){
        SmartBankAccount acc1 = new SmartBankAccount();
        acc1.deposit(200);
        acc1.withdraw(50);

        System.out.println(acc1);
    }
}

class SmartBankAccount{
    public String name;
    private String accountNumber;
    private double balance;
    private String[] transactionHistory;
    private int transactionCount;

    public static int numsSBA = 0;
    public static final double MIN_BALANCE = 100.0;

    SmartBankAccount(){
        this("Unknown", "000000", MIN_BALANCE);
    }

    SmartBankAccount(String name, String accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new String[10];
        this.transactionCount = 0;

        numsSBA++;
        recordTransaction("Account created");
    }

    private void recordTransaction(String transaction){
        if (transactionCount < transactionHistory.length){
            transactionHistory[transactionCount] = transaction;
            transactionCount++;
        } else {
            for (int i = 0; i < transactionHistory.length - 1; i++){
                transactionHistory[i] = transactionHistory[i + 1];
            }
            transactionHistory[transactionHistory.length - 1] = transaction;
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            recordTransaction("Deposit: " + amount);
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && this.balance - amount >= MIN_BALANCE){
            this.balance -= amount;
            recordTransaction("Withdraw: " + amount);
        } else {
            recordTransaction("Withdraw failed");
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public String getTransactionHistory(){
        StringBuilder history = new StringBuilder();
        for (int i = 0; i < transactionCount && i < transactionHistory.length; i++){
            if (transactionHistory[i] != null){
                history.append((i + 1)).append(". ").append(transactionHistory[i]).append("\n");
            }
        }
        return history.toString();
    }

    public String toString(){
        return "Account Holder: " + this.name + ", Account Number: " + this.accountNumber + 
               ", Balance: $" + this.balance;
    }

    public static int getNumSBA(){
        return numsSBA;
    }
}
