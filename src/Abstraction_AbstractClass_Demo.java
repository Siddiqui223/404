/*
 * TOPIC: Abstraction & Abstract Classes in Java
 * -------------------------------------------------
 * Abstraction means hiding implementation details and exposing only the
 * essential features. In Java, one way to achieve this is with an
 * ABSTRACT CLASS.
 *
 * Rules for abstract classes:
 *   - Declared with the 'abstract' keyword.
 *   - CANNOT be instantiated directly (no 'new AbstractClass()').
 *   - Can contain a mix of:
 *       * abstract methods (no body -- subclasses MUST implement them)
 *       * concrete methods (regular methods with a body, inherited as-is)
 *       * fields and constructors
 *   - A subclass extending an abstract class MUST implement all abstract
 *     methods, unless the subclass is also declared abstract.
 */

// ---------- Abstract class ----------
abstract class Vehicle {

    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method: no implementation here. Declares WHAT must be done,
    // leaving HOW it's done to each concrete subclass.
    public abstract void startEngine();

    public abstract double fuelEfficiency(); // km per liter, e.g.

    // Concrete (regular) method: shared implementation available to
    // ALL subclasses without needing to be rewritten.
    public void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

// ---------- Concrete subclass 1 ----------
class ElectricCar extends Vehicle {

    public ElectricCar(String brand) {
        super(brand);
    }

    // MUST provide implementations for all abstract methods, or this
    // class would also need to be declared abstract.
    @Override
    public void startEngine() {
        System.out.println(brand + ": Silent start (electric motor engaged).");
    }

    @Override
    public double fuelEfficiency() {
        // Electric cars don't use fuel, so we return an equivalent metric.
        return 0.0; // not applicable, using kWh instead conceptually
    }
}

// ---------- Concrete subclass 2 ----------
class PetrolCar extends Vehicle {

    public PetrolCar(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + ": Vroom! Petrol engine ignited.");
    }

    @Override
    public double fuelEfficiency() {
        return 15.5; // km per liter
    }
}

public class Abstraction_AbstractClass_Demo {
    public static void main(String[] args) {

        // The following line would NOT COMPILE because Vehicle is abstract:
        // Vehicle v = new Vehicle("Generic"); // ERROR

        // Instead, we work with concrete subclasses, but can still
        // reference them using the abstract parent type.
        Vehicle car1 = new ElectricCar("Tesla");
        Vehicle car2 = new PetrolCar("Toyota");

        car1.displayBrand();   // inherited concrete method
        car1.startEngine();    // subclass-specific implementation
        System.out.println("Efficiency: " + car1.fuelEfficiency());

        car2.displayBrand();
        car2.startEngine();
        System.out.println("Efficiency: " + car2.fuelEfficiency() + " km/l");
    }
}
