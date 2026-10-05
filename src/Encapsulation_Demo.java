/*
 * TOPIC: Encapsulation in Java
 * --------------------------------
 * Encapsulation means bundling data (fields) and the methods that
 * operate on it into a single unit (a class), while RESTRICTING direct
 * access to internal fields from outside the class.
 *
 * Achieved via:
 *   - Making fields 'private'
 *   - Providing public 'getter' and 'setter' methods to read/modify them
 *     (with validation logic if needed)
 *
 * Benefit: internal implementation can change freely without breaking
 * code that depends on the class, and invalid data can be rejected.
 */

class BankAccount {

    // ---------- Private fields ----------
    // 'private' means these can ONLY be accessed directly from within
    // this class. Outside code cannot do account.balance = -500;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        // Reuse the setter so validation logic runs during construction too.
        setBalance(initialBalance);
    }

    // ---------- Getter ----------
    // Public method that provides READ access to a private field.
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    // ---------- Setter ----------
    // Public method that provides controlled WRITE access, allowing
    // validation before the field is actually changed.
    public void setBalance(double balance) {
        if (balance < 0) {
            // Reject invalid data instead of silently corrupting state.
            System.out.println("Error: Balance cannot be negative. Ignoring update.");
            return;
        }
        this.balance = balance;
    }

    // ---------- Behavior methods that safely modify internal state ----------
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + " | New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + " | New balance: " + balance);
    }
}

public class Encapsulation_Demo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Alice", 1000.0);

        // Direct access like account.balance = -5000; would NOT COMPILE
        // because 'balance' is private. We must go through public methods.
        System.out.println("Account holder: " + account.getAccountHolder());
        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(500);
        account.withdraw(200);
        account.withdraw(10000); // rejected: insufficient funds

        // Attempting to set an invalid balance is safely rejected.
        account.setBalance(-100);
        System.out.println("Balance after invalid update attempt: " + account.getBalance());
    }
}
