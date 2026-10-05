/*
 * TOPIC: Operators in Java
 * -------------------------
 * Operators perform operations on variables and values.
 * Categories covered here:
 *   1) Arithmetic operators
 *   2) Relational (comparison) operators
 *   3) Logical operators
 *   4) Assignment operators
 *   5) Unary operators (increment/decrement)
 *   6) Bitwise operators
 *   7) Ternary operator
 */
public class Operators {

    public static void main(String[] args) {

        int a = 10, b = 3;

        // ---------- Arithmetic Operators ----------
        // + - * / % perform basic math. Note: '/' between two ints does
        // INTEGER division (drops remainder); '%' gives the remainder.
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (integer division)
        System.out.println("a % b = " + (a % b)); // 1 (remainder)

        // ---------- Relational Operators ----------
        // These compare two values and always return a boolean.
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // ---------- Logical Operators ----------
        // Combine multiple boolean expressions.
        // && (AND) -> true only if BOTH sides are true (short-circuits)
        // ||  (OR)  -> true if AT LEAST ONE side is true (short-circuits)
        // !   (NOT) -> flips the boolean value
        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y)); // false
        System.out.println("x || y: " + (x || y)); // true
        System.out.println("!x: " + (!x));          // false

        // ---------- Assignment Operators ----------
        // '=' assigns a value. Compound operators combine an operation
        // with assignment, e.g. c += 5 is shorthand for c = c + 5.
        int c = 5;
        c += 5;  // c = 10
        c -= 2;  // c = 8
        c *= 3;  // c = 24
        c /= 4;  // c = 6
        c %= 4;  // c = 2
        System.out.println("Final c after compound assignments: " + c);

        // ---------- Unary Operators ----------
        // ++ increments by 1, -- decrements by 1.
        // Pre-increment (++i) increments THEN returns the value.
        // Post-increment (i++) returns the value THEN increments.
        int i = 5;
        System.out.println("i++ (post): " + (i++)); // prints 5, then i becomes 6
        System.out.println("++i (pre): " + (++i));  // i becomes 7, then prints 7

        // ---------- Bitwise Operators ----------
        // Operate directly on the binary representation of integers.
        int p = 5;  // binary: 0101
        int q = 3;  // binary: 0011
        System.out.println("p & q (AND): " + (p & q));   // 0001 = 1
        System.out.println("p | q (OR): " + (p | q));    // 0111 = 7
        System.out.println("p ^ q (XOR): " + (p ^ q));   // 0110 = 6
        System.out.println("~p (NOT): " + (~p));         // -6 (inverts all bits)
        System.out.println("p << 1 (left shift): " + (p << 1));  // 10 (multiply by 2)
        System.out.println("p >> 1 (right shift): " + (p >> 1)); // 2  (divide by 2)

        // ---------- Ternary Operator ----------
        // Shorthand for a simple if-else: condition ? valueIfTrue : valueIfFalse
        int num = 7;
        String result = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println(num + " is " + result);
    }
}
