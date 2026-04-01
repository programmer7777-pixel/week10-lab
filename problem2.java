class InsufficientFundsException extends Exception {
    private double shortfall;

    public InsufficientFundsException(double shortfall) {
        this.shortfall = shortfall;
    }

    @Override
    public String getMessage() {
        return "Insufficient funds. You are short by $" + String.format("%.2f", shortfall);
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException(shortfall);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + String.format("%.2f", amount) +
                    ". Remaining balance: $" + String.format("%.2f", balance));
        }
    }

    public double getBalance() {
        return balance;
    }
}
public class problem2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);

        System.out.println("Balance: $" + String.format("%.2f", account.getBalance()));

        double[] withdrawals = {200, 400, 100};

        for (double amount : withdrawals) {
            try {
                account.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}