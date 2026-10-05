/*
 * TOPIC: Interfaces in Java
 * -----------------------------
 * An interface is a fully abstract "contract" that specifies WHAT a
 * class must do, without specifying HOW. It defines method signatures
 * that implementing classes are required to provide.
 *
 * Key points:
 *   - Declared with 'interface' keyword.
 *   - All fields are implicitly 'public static final' (constants).
 *   - Methods are implicitly 'public abstract' unless marked
 *     'default' or 'static' (modern Java features).
 *   - A class uses 'implements' to fulfill an interface's contract.
 *   - Unlike classes, a class CAN implement MULTIPLE interfaces,
 *     which is how Java achieves a form of "multiple inheritance"
 *     of behavior/type.
 */

interface Flyable {
    // Implicitly public and abstract -- no method body.
    void fly();

    // 'default' method: provides a DEFAULT implementation that
    // implementing classes can use as-is or override.
    default void land() {
        System.out.println("Landing safely.");
    }

    // 'static' method: belongs to the interface itself, called as
    // Flyable.someUtility(), not through an instance.
    static void info() {
        System.out.println("Flyable: any object capable of flight.");
    }
}

interface Swimmable {
    void swim();
}

// ---------- A class implementing a SINGLE interface ----------
class Bird implements Flyable {
    String name;

    public Bird(String name) {
        this.name = name;
    }

    // MUST implement all abstract methods declared by the interface.
    @Override
    public void fly() {
        System.out.println(name + " flaps its wings and flies.");
    }
    // land() is inherited from the interface's default implementation,
    // so we don't have to redefine it (though we could override it).
}

// ---------- A class implementing MULTIPLE interfaces ----------
// This is how Java gets around not supporting multiple class
// inheritance: a class can only extend one class, but can implement
// as many interfaces as needed.
class Duck implements Flyable, Swimmable {
    String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " flies short distances.");
    }

    @Override
    public void swim() {
        System.out.println(name + " paddles across the pond.");
    }

    // Overriding the default method with custom behavior.
    @Override
    public void land() {
        System.out.println(name + " lands gently on water.");
    }
}

public class Interfaces_Demo {
    public static void main(String[] args) {

        Bird sparrow = new Bird("Sparrow");
        sparrow.fly();
        sparrow.land(); // uses the interface's default implementation

        Duck duck = new Duck("Donald");
        duck.fly();
        duck.swim();
        duck.land(); // uses Duck's OVERRIDDEN version

        // Calling a static interface method directly on the interface.
        Flyable.info();

        // ---------- Interface as a reference type ----------
        // Just like abstract classes, an interface can be used as a
        // reference type, enabling polymorphism across unrelated classes
        // that share a common capability.
        Flyable[] fliers = { sparrow, duck };
        for (Flyable f : fliers) {
            f.fly();
        }
    }
}
