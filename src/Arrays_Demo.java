import java.util.Arrays;

/*
 * TOPIC: Arrays in Java
 * -----------------------
 * An array is a fixed-size, ordered collection of elements of the SAME
 * data type, stored in contiguous memory. Once created, its size cannot
 * change.
 *   - 1D arrays
 *   - 2D (multi-dimensional) arrays
 *   - Common array utility operations (sort, fill, copy) via java.util.Arrays
 */
public class Arrays_Demo {

    public static void main(String[] args) {

        // ---------- Declaring and initializing a 1D array ----------
        // Method 1: declare size, then assign values by index
        int[] scores = new int[5]; // creates array of 5 ints, default value 0
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 78;
        scores[3] = 92;
        scores[4] = 88;

        // Method 2: array literal (declare + initialize together)
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};

        // ---------- Accessing elements ----------
        // Arrays are zero-indexed: first element is at index 0.
        System.out.println("First fruit: " + fruits[0]);
        System.out.println("Array length: " + fruits.length); // no parentheses, it's a field

        // ---------- Iterating over an array ----------
        System.out.println("-- Scores (index-based loop) --");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index " + i + ": " + scores[i]);
        }

        System.out.println("-- Fruits (for-each loop) --");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // ---------- 2D Arrays (array of arrays / matrix) ----------
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("-- 2D Array (matrix) traversal --");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // ---------- Useful java.util.Arrays utility methods ----------

        // Sorting: arranges elements in ascending order (in place)
        int[] unsorted = {5, 2, 8, 1, 9};
        Arrays.sort(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(unsorted));

        // Filling: sets every element to the same value
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled array: " + Arrays.toString(filled));

        // Copying: creates a new array with a specified length
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, 5); // extra slots filled with 0
        System.out.println("Copied array: " + Arrays.toString(copy));

        // Searching: binarySearch requires the array to be SORTED first
        int index = Arrays.binarySearch(unsorted, 8);
        System.out.println("Index of value 8 in sorted array: " + index);

        // Comparing two arrays for equality (same elements, same order)
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};
        System.out.println("Arrays equal? " + Arrays.equals(a1, a2));
    }
}
