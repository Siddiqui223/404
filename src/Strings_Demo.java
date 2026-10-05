/*
 * TOPIC: Strings in Java
 * ------------------------
 * A String represents a sequence of characters. In Java, String objects
 * are IMMUTABLE -- once created, their content can never change. Any
 * operation that appears to "modify" a String actually creates a NEW
 * String object.
 *
 * Covered here:
 *   - String creation (literal vs 'new')
 *   - Common String methods
 *   - String immutability & the String Pool
 *   - StringBuilder for efficient, mutable string operations
 */
public class Strings_Demo {

    public static void main(String[] args) {

        // ---------- Creating Strings ----------
        // Literal creation: stored in the "String Pool" for reuse/efficiency.
        String s1 = "Hello";

        // Using 'new' forces creation of a separate object in heap memory,
        // even if an identical literal already exists in the pool.
        String s2 = new String("Hello");

        // '==' compares references (memory addresses), NOT content.
        // '.equals()' compares actual character content.
        System.out.println("s1 == s2 (reference compare): " + (s1 == s2));       // false
        System.out.println("s1.equals(s2) (content compare): " + s1.equals(s2)); // true

        // ---------- Common String methods ----------
        String text = "  Java Programming  ";

        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: '" + text.trim() + "'");           // removes leading/trailing spaces
        System.out.println("Upper case: " + text.toUpperCase());
        System.out.println("Lower case: " + text.toLowerCase());
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Replace: " + text.replace("Java", "Python"));
        System.out.println("Substring(2,6): " + text.substring(2, 6));   // start inclusive, end exclusive
        System.out.println("Char at index 2: " + text.charAt(2));
        System.out.println("Index of 'Programming': " + text.indexOf("Programming"));
        System.out.println("Split by space: ");
        for (String word : text.trim().split(" ")) {
            System.out.println(" -> " + word);
        }

        // ---------- String Immutability demonstration ----------
        String original = "Hello";
        String modified = original.concat(" World"); // creates a NEW string
        System.out.println("original (unchanged): " + original);
        System.out.println("modified (new object): " + modified);

        // ---------- String comparison methods ----------
        String x = "apple";
        String y = "Apple";
        System.out.println("equals: " + x.equals(y));               // case-sensitive -> false
        System.out.println("equalsIgnoreCase: " + x.equalsIgnoreCase(y)); // true
        System.out.println("compareTo: " + x.compareTo(y));         // lexicographic difference

        // ---------- StringBuilder: mutable alternative ----------
        // Since String is immutable, repeatedly modifying strings in a loop
        // (e.g., concatenation) creates many throwaway objects and is slow.
        // StringBuilder solves this by allowing in-place modification.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append("Item").append(i).append(" "); // append is efficient, no new object each time
        }
        System.out.println("StringBuilder result: " + sb.toString());

        // StringBuilder also supports insert, delete, reverse, etc.
        sb.reverse();
        System.out.println("Reversed: " + sb.toString());
    }
}
