/*
 * TOPIC: Variables and Data Types in Java
 * ----------------------------------------
 * Java is a STATICALLY TYPED language, meaning every variable must be
 * declared with a data type before it is used, and that type cannot
 * change later.
 *
 * Data types in Java fall into two categories:
 *   1) Primitive types  -> store actual values (byte, short, int, long,
 *                          float, double, char, boolean)
 *   2) Reference types   -> store references (memory addresses) to
 *                          objects (String, Arrays, custom classes, etc.)
 */
public class Variables_DataTypes {

    public static void main(String[] args) {

        // ---------- Integer types ----------
        // byte: 8-bit, range -128 to 127. Used to save memory in large arrays.
        byte byteVar = 100;

        // short: 16-bit, range -32,768 to 32,767
        short shortVar = 20000;

        // int: 32-bit, most commonly used integer type
        int intVar = 100000;

        // long: 64-bit, used for very large numbers. Note the 'L' suffix.
        long longVar = 10000000000L;

        // ---------- Floating point types ----------
        // float: 32-bit single precision, needs 'f' suffix
        float floatVar = 10.5f;

        // double: 64-bit double precision (default choice for decimals)
        double doubleVar = 19.99;

        // ---------- Character type ----------
        // char: single 16-bit Unicode character, enclosed in single quotes
        char charVar = 'A';

        // ---------- Boolean type ----------
        // boolean: only two possible values -> true or false
        boolean boolVar = true;

        // ---------- Reference type example ----------
        // String is NOT a primitive; it's a class. Text is enclosed in double quotes.
        String stringVar = "Hello, Java!";

        // ---------- var keyword (Java 10+) ----------
        // Compiler infers the type automatically from the assigned value.
        // The type is still fixed at compile time -- it is NOT dynamic typing.
        var inferredInt = 25;          // inferred as int
        var inferredString = "Java";   // inferred as String

        // Printing all variables to see their values
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + boolVar);
        System.out.println("String: " + stringVar);
        System.out.println("var (int): " + inferredInt);
        System.out.println("var (String): " + inferredString);

        // ---------- Type Casting ----------
        // Widening (implicit): smaller type -> larger type, done automatically
        int a = 10;
        double widened = a; // int automatically becomes double

        // Narrowing (explicit): larger type -> smaller type, needs a cast
        // because data/precision might be lost.
        double b = 9.78;
        int narrowed = (int) b; // decimal part is truncated, not rounded

        System.out.println("Widened int->double: " + widened);
        System.out.println("Narrowed double->int: " + narrowed);
    }
}
