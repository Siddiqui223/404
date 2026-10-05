import java.util.ArrayList;
import java.util.List;

/*
 * TOPIC: Generics in Java
 * ---------------------------
 * Generics allow classes, interfaces, and methods to operate on a
 * TYPE PARAMETER specified at compile time, instead of a fixed type.
 * This provides:
 *   - Type safety   : errors caught at compile time, not runtime
 *   - Reusability   : one class/method works with many types
 *   - No casting    : no need to manually cast Object back to a type
 */

// ---------- A generic class ----------
// <T> is a placeholder ("type parameter") for whatever type the
// caller decides to use when creating an instance of this class.
class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

// ---------- A generic class with multiple type parameters ----------
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class Generics_Demo {

    // ---------- A generic method ----------
    // The <T> before the return type declares this method's own type
    // parameter, independent of any class-level generics.
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // ---------- Bounded type parameter ----------
    // "<T extends Number>" restricts T to Number or its subclasses
    // (Integer, Double, etc.), so we can safely call Number methods on it.
    public static <T extends Number> double sumOfList(List<T> list) {
        double sum = 0.0;
        for (T item : list) {
            sum += item.doubleValue(); // safe because T is guaranteed to be a Number
        }
        return sum;
    }

    public static void main(String[] args) {

        // ---------- Using the generic Box class with different types ----------
        // No casting needed, and using the wrong type won't even compile.
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        String value = stringBox.get(); // no cast required
        System.out.println("String box: " + value);

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println("Integer box: " + intBox.get());

        // The next line would NOT COMPILE, demonstrating type safety:
        // stringBox.set(42); // ERROR: incompatible types

        // ---------- Using the generic Pair class ----------
        Pair<String, Integer> studentAge = new Pair<>("Alice", 21);
        System.out.println("Pair: " + studentAge);

        // ---------- Using the generic method ----------
        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"a", "b", "c"};
        printArray(intArray);   // T is inferred as Integer
        printArray(stringArray); // T is inferred as String

        // ---------- Using the bounded generic method ----------
        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Double> doubleList = new ArrayList<>(List.of(1.5, 2.5, 3.0));
        System.out.println("Sum of int list: " + sumOfList(intList));
        System.out.println("Sum of double list: " + sumOfList(doubleList));

        // ---------- Wildcards (brief mention) ----------
        // '?' represents an unknown type, useful for methods that just
        // need to READ from a generic collection regardless of its type.
        List<? extends Number> wildcardList = intList;
        System.out.println("Wildcard list read: " + wildcardList);
    }
}
