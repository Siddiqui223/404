/*
 * TOPIC: Control Statements (Decision Making) in Java
 * -----------------------------------------------------
 * Control statements let the program choose different execution paths
 * based on conditions.
 *   - if, if-else, else-if ladder
 *   - switch statement (traditional and modern "arrow" style)
 */
public class ControlStatements {

    public static void main(String[] args) {

        int marks = 75;

        // ---------- Simple if ----------
        // Executes the block only if the condition is true.
        if (marks > 0) {
            System.out.println("Marks are positive.");
        }

        // ---------- if-else ----------
        // Executes one block OR the other, never both.
        if (marks >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }

        // ---------- else-if ladder ----------
        // Checks multiple conditions in order; the first true one runs,
        // and the rest are skipped.
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }

        // ---------- Nested if ----------
        // An if statement inside another if statement, for checking
        // combined/compound conditions.
        int age = 20;
        boolean hasID = true;
        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry allowed.");
            } else {
                System.out.println("ID required for entry.");
            }
        } else {
            System.out.println("Entry denied: underage.");
        }

        // ---------- Traditional switch statement ----------
        // Compares a variable against multiple constant values.
        // 'break' is required to stop execution from "falling through"
        // into the next case.
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Another day");
                break;
        }

        // ---------- Modern switch expression (Java 14+) ----------
        // Uses arrow syntax "->" so there is no fall-through and no need
        // for 'break'. It can also directly return/assign a value.
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
        System.out.println("Day name (switch expression): " + dayName);
    }
}
