/*
 * TOPIC: OOP Basics - Classes and Objects
 * ------------------------------------------
 * A CLASS is a blueprint/template that defines fields (data/state) and
 * methods (behavior). An OBJECT is an actual instance created from
 * that blueprint, with its own copy of the fields.
 *
 * Also covers: constructors, 'this' keyword, and method overloading.
 */

// The blueprint for a "Car" -- defines what every car object will have.
class Car {

    // ---------- Fields (instance variables) ----------
    // Each Car object gets its own copy of these.
    String brand;
    String model;
    int year;

    // ---------- Constructor ----------
    // Special method with the SAME NAME as the class, called automatically
    // when an object is created with 'new'. Used to initialize fields.
    // This is a "parameterized constructor" since it takes arguments.
    public Car(String brand, String model, int year) {
        // 'this' refers to the CURRENT object, distinguishing the
        // instance field from the constructor parameter of the same name.
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // ---------- No-argument (default-style) constructor ----------
    // Constructors can be overloaded, just like methods.
    public Car() {
        this("Unknown", "Unknown", 2000); // 'this(...)' calls another constructor
    }

    // ---------- Instance method ----------
    // Defines behavior that operates on this object's fields.
    public void displayInfo() {
        System.out.println(year + " " + brand + " " + model);
    }

    // ---------- Method Overloading ----------
    // Multiple methods with the SAME NAME but DIFFERENT parameter lists.
    // The compiler picks the right one based on arguments provided.
    public void honk() {
        System.out.println(brand + " says: Beep!");
    }

    public void honk(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(brand + " says: Beep!");
        }
    }
}

public class OOP_ClassesObjects {
    public static void main(String[] args) {

        // ---------- Creating objects (instances) ----------
        // 'new' allocates memory and calls the constructor.
        Car car1 = new Car("Toyota", "Corolla", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);
        Car car3 = new Car(); // uses the no-arg constructor

        // Each object has its OWN independent copy of the fields.
        car1.displayInfo();
        car2.displayInfo();
        car3.displayInfo();

        // Calling overloaded methods
        car1.honk();       // calls honk()
        car2.honk(3);       // calls honk(int) three times

        // Objects can be modified after creation via their fields/methods
        car1.year = 2024;
        System.out.println("Updated car1 year: " + car1.year);
    }
}
