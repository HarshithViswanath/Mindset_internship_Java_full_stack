class Account {
    private double balance;   // private variable

    public void setBalance(double b) {
        balance = b;
    }

    public double getBalance() {
        return balance;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Account a = new Account();

        a.setBalance(5000);
        System.out.println("Balance: " + a.getBalance());
    }
}
