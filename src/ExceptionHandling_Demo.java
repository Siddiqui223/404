/*
 * TOPIC: Exception Handling in Java
 * --------------------------------------
 * Exceptions are runtime errors that disrupt normal program flow.
 * Java provides a structured way to detect and handle them gracefully
 * instead of crashing the program.
 *
 * Keywords: try, catch, finally, throw, throws
 *
 * Exception hierarchy (simplified):
 *   Throwable
 *     -> Error            (serious JVM-level problems, not meant to be caught)
 *     -> Exception
 *          -> Checked exceptions   (must be handled or declared, e.g. IOException)
 *          -> RuntimeException     (unchecked, e.g. ArithmeticException, NullPointerException)
 */

// A CUSTOM checked exception -- extends Exception, so callers are FORCED
// (by the compiler) to either catch it or declare it with 'throws'.
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message); // pass the message up to the Exception base class
    }
}

public class ExceptionHandling_Demo {

    // A method that may throw our custom CHECKED exception.
    // 'throws' in the signature declares this possibility to callers.
    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            // 'throw' actually creates and raises the exception object.
            throw new InsufficientFundsException("Cannot withdraw " + amount + "; balance is only " + balance);
        }
        System.out.println("Withdrawal successful. New balance: " + (balance - amount));
    }

    public static void main(String[] args) {

        // ---------- Basic try-catch ----------
        // Code that might fail goes in 'try'; 'catch' handles the specific
        // exception type if it occurs, preventing a program crash.
        try {
            int result = 10 / 0; // throws ArithmeticException (unchecked)
            System.out.println("Result: " + result); // never reached
        } catch (ArithmeticException e) {
            System.out.println("Caught an error: " + e.getMessage());
        }

        // ---------- Multiple catch blocks ----------
        // Different exception types can be handled differently.
        // Catch blocks are checked top to bottom; put more specific
        // exceptions BEFORE more general ones.
        try {
            int[] arr = new int[3];
            arr[5] = 10; // throws ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error: " + e.getMessage());
        } catch (Exception e) {
            // Generic fallback for any other exception type.
            System.out.println("General error: " + e.getMessage());
        }

        // ---------- finally block ----------
        // Code in 'finally' ALWAYS executes, whether or not an exception
        // occurred -- commonly used for cleanup (closing files, connections).
        try {
            System.out.println("Inside try block.");
            String text = null;
            System.out.println(text.length()); // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs (cleanup here).");
        }

        // ---------- Handling a CHECKED custom exception ----------
        // Because withdraw() declares 'throws InsufficientFundsException',
        // the caller MUST handle it (or also declare 'throws').
        try {
            withdraw(500, 700);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        // ---------- try-with-resources (brief mention) ----------
        // Used with resources (like files/streams) that implement
        // AutoCloseable -- they are automatically closed after the try
        // block, even if an exception occurs. (No actual resource here,
        // just illustrating the syntax shape in a comment):
        //
        // try (SomeResource r = new SomeResource()) {
        //     r.use();
        // } catch (Exception e) {
        //     // handle
        // } // r.close() is called automatically here

        System.out.println("Program continues normally after handled exceptions.");
    }
}
