import java.util.*;

/*
 * TOPIC: Java Collections Framework
 * --------------------------------------
 * The Collections Framework provides ready-made data structures for
 * storing and manipulating groups of objects. Unlike arrays, collections
 * can grow/shrink dynamically.
 *
 * Main interfaces covered:
 *   - List : ordered, allows duplicates (ArrayList, LinkedList)
 *   - Set  : no duplicates (HashSet, TreeSet)
 *   - Map  : key-value pairs, unique keys (HashMap, TreeMap)
 *   - Queue: FIFO processing order (LinkedList as Queue)
 */
public class Collections_Demo {

    public static void main(String[] args) {

        // =========================================================
        // LIST -- ordered collection, allows duplicate elements,
        // access by index (like a resizable array).
        // =========================================================
        System.out.println("-- List (ArrayList) --");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple"); // duplicates ARE allowed in a List
        arrayList.add(1, "Mango"); // insert at a specific index

        System.out.println("List: " + arrayList);
        System.out.println("Element at index 0: " + arrayList.get(0));
        arrayList.remove("Banana"); // removes first matching element
        System.out.println("After removal: " + arrayList);

        // LinkedList: alternative List implementation, more efficient
        // for frequent insertions/deletions in the middle of the list.
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        System.out.println("LinkedList: " + linkedList);

        // =========================================================
        // SET -- collection with NO duplicate elements.
        // =========================================================
        System.out.println("\n-- Set (HashSet) --");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Red"); // duplicate is silently ignored
        System.out.println("HashSet (no guaranteed order): " + hashSet);

        // TreeSet: keeps elements sorted automatically.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        System.out.println("TreeSet (sorted): " + treeSet);

        // LinkedHashSet: no duplicates, but preserves INSERTION order.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("Third");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        // =========================================================
        // MAP -- stores key-value pairs; keys are unique.
        // =========================================================
        System.out.println("\n-- Map (HashMap) --");
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Alice", 31); // overwrites the previous value for key "Alice"

        System.out.println("Map: " + ages);
        System.out.println("Bob's age: " + ages.get("Bob"));
        System.out.println("Contains key 'Alice': " + ages.containsKey("Alice"));

        // Iterating over a Map using entrySet (most common approach)
        System.out.println("Iterating entries:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // TreeMap: keeps keys sorted automatically.
        Map<String, Integer> sortedMap = new TreeMap<>(ages);
        System.out.println("TreeMap (sorted by key): " + sortedMap);

        // =========================================================
        // QUEUE -- typically processes elements in FIFO (first-in,
        // first-out) order.
        // =========================================================
        System.out.println("\n-- Queue (LinkedList as Queue) --");
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task1"); // add to the back of the queue
        queue.offer("Task2");
        queue.offer("Task3");
        System.out.println("Queue: " + queue);
        System.out.println("Polled (removed from front): " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // =========================================================
        // Sorting a List with Collections utility class
        // =========================================================
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        Collections.sort(numbers);
        System.out.println("\nSorted list: " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed list: " + numbers);
        System.out.println("Max: " + Collections.max(numbers) + ", Min: " + Collections.min(numbers));
    }
}
