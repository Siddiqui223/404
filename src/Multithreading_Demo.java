/*
 * TOPIC: Multithreading in Java
 * -----------------------------------
 * A THREAD is an independent path of execution within a program.
 * Multithreading allows multiple parts of a program to run
 * CONCURRENTLY, improving performance for tasks that can be
 * parallelized (e.g., handling multiple requests, background processing).
 *
 * Ways to create a thread:
 *   1) Extending the Thread class
 *   2) Implementing the Runnable interface (preferred, since Java only
 *      allows single class inheritance, and Runnable keeps your class
 *      free to extend something else)
 *
 * Also covers: synchronization to prevent race conditions.
 */

// ---------- Approach 1: extending Thread ----------
class CounterThread extends Thread {
    private String threadName;

    public CounterThread(String name) {
        this.threadName = name;
    }

    // 'run()' contains the code that executes when the thread starts.
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - count: " + i);
            try {
                Thread.sleep(200); // pause this thread for 200ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
    }
}

// ---------- Approach 2: implementing Runnable (preferred) ----------
class PrinterTask implements Runnable {
    private String message;

    public PrinterTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(message + " (" + i + ")");
        }
    }
}

// ---------- Shared resource used to demonstrate synchronization ----------
class SharedCounter {
    private int count = 0;

    // 'synchronized' ensures only ONE thread at a time can execute this
    // method on a given object, preventing a "race condition" where two
    // threads read/modify 'count' simultaneously and corrupt the result.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Multithreading_Demo {

    public static void main(String[] args) throws InterruptedException {

        // ---------- Using the Thread subclass ----------
        CounterThread t1 = new CounterThread("Thread-A");
        CounterThread t2 = new CounterThread("Thread-B");
        t1.start(); // start() creates a new call stack and runs run() concurrently
        t2.start(); // NOTE: never call run() directly -- that just runs it
                    // like a normal method on the current thread, with no
                    // actual concurrency.

        // Wait for these threads to finish before continuing, so output
        // ordering in this demo stays somewhat predictable.
        t1.join();
        t2.join();

        // ---------- Using Runnable with a Thread wrapper ----------
        Thread t3 = new Thread(new PrinterTask("Runnable task"));
        t3.start();
        t3.join();

        // ---------- Using Runnable with a lambda expression (modern style) ----------
        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda thread: " + i);
            }
        });
        t4.start();
        t4.join();

        // ---------- Demonstrating synchronization ----------
        SharedCounter counter = new SharedCounter();

        // Create 100 threads that each increment the shared counter.
        // Without 'synchronized', the final count could be LESS than 100
        // due to threads overwriting each other's updates.
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join(); // wait for every thread to finish
        }

        System.out.println("Final counter value (should be 100): " + counter.getCount());
    }
}
