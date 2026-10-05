/*
 * TOPIC: Loops in Java
 * ---------------------
 * Loops let a block of code run repeatedly.
 *   - for loop        : best when the number of iterations is known
 *   - while loop       : best when repetition depends on a condition
 *   - do-while loop    : runs the body AT LEAST once before checking condition
 *   - for-each loop    : used to iterate over arrays/collections
 *   - break / continue : loop control statements
 */
public class Loops {

    public static void main(String[] args) {

        // ---------- for loop ----------
        // Structure: for (initialization; condition; update)
        System.out.println("-- for loop --");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // ---------- while loop ----------
        // Condition is checked BEFORE each iteration; body may run 0 times.
        System.out.println("-- while loop --");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // ---------- do-while loop ----------
        // Condition is checked AFTER each iteration, so the body always
        // executes at least once, even if the condition is false initially.
        System.out.println("-- do-while loop --");
        int n = 10;
        do {
            System.out.println("This runs at least once. n = " + n);
            n++;
        } while (n < 5); // condition is false, but body already ran once

        // ---------- for-each loop (enhanced for loop) ----------
        // Used to iterate directly over elements of an array or collection
        // without manually managing an index.
        System.out.println("-- for-each loop --");
        int[] numbers = {10, 20, 30, 40};
        for (int num : numbers) {
            System.out.println("Value: " + num);
        }

        // ---------- break statement ----------
        // Immediately exits the nearest enclosing loop.
        System.out.println("-- break example --");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // stop the loop entirely once i reaches 5
            }
            System.out.println("i = " + i);
        }

        // ---------- continue statement ----------
        // Skips the rest of the current iteration and moves to the next one.
        System.out.println("-- continue example --");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // skip printing when i == 3
            }
            System.out.println("i = " + i);
        }

        // ---------- Nested loops ----------
        // A loop inside another loop, commonly used for grids/patterns.
        System.out.println("-- nested loop (multiplication pattern) --");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print((i * j) + " ");
            }
            System.out.println(); // move to next line after inner loop finishes
        }
    }
}
