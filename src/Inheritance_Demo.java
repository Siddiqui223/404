/*
 * TOPIC: Inheritance in Java
 * -----------------------------
 * Inheritance allows one class (the SUBCLASS/child) to acquire the
 * fields and methods of another class (the SUPERCLASS/parent), enabling
 * code reuse and establishing an "is-a" relationship.
 *
 * Keyword: extends
 * Covers: single inheritance, method overriding, 'super' keyword,
 *         and the concept that Java does NOT support multiple class
 *         inheritance (a class can extend only one other class).
 */

// ---------- Parent / Superclass ----------
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // A method that subclasses can inherit or override.
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// ---------- Child / Subclass ----------
// 'extends' establishes the inheritance relationship: Dog IS-A Animal.
class Dog extends Animal {

    String breed;

    public Dog(String name, String breed) {
        // 'super(...)' calls the PARENT class's constructor.
        // Must be the first statement in the child constructor.
        super(name);
        this.breed = breed;
    }

    // ---------- Method Overriding ----------
    // Same method signature as the parent, but a NEW implementation.
    // @Override tells the compiler to verify this actually overrides
    // a parent method (catches typos at compile time).
    @Override
    public void eat() {
        System.out.println(name + " (a " + breed + ") is eating dog food.");
    }

    // A method unique to Dog, not present in Animal.
    public void bark() {
        System.out.println(name + " says Woof!");
    }

    // Using 'super' to call the PARENT's version of an overridden method,
    // in addition to this class's own behavior.
    public void sleepLikeAnimalAndDog() {
        super.sleep();                    // parent's generic sleep behavior
        System.out.println(name + " curls up in its bed.");
    }
}

// Another subclass showing that multiple classes can extend the same parent.
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating cat food.");
    }
}

public class Inheritance_Demo {
    public static void main(String[] args) {

        Dog dog = new Dog("Buddy", "Labrador");
        Cat cat = new Cat("Whiskers");

        // Inherited method from Animal, but Dog OVERRIDES it, so
        // Dog's version runs.
        dog.eat();
        cat.eat();

        // Inherited, non-overridden method -- uses Animal's version directly.
        dog.sleep();

        // Method that only exists in Dog.
        dog.bark();

        dog.sleepLikeAnimalAndDog();

        // ---------- Upcasting ----------
        // A Dog object can be referred to using an Animal-type reference,
        // since Dog IS-A Animal. This is the basis for polymorphism
        // (see topic 09).
        Animal genericAnimal = dog;
        genericAnimal.eat(); // still calls Dog's overridden eat() at runtime
    }
}
