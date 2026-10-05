/*
 * TOPIC: Polymorphism in Java
 * -------------------------------
 * "Polymorphism" means "many forms" -- the ability of an object to
 * behave differently depending on context. Java supports two kinds:
 *
 *   1) COMPILE-TIME (Static) Polymorphism -> Method Overloading
 *      Decided by the compiler based on method signature.
 *
 *   2) RUNTIME (Dynamic) Polymorphism -> Method Overriding
 *      Decided at runtime based on the ACTUAL object type,
 *      not the reference type. This is also called "dynamic dispatch".
 */

class Shape {
    // A generic method that subclasses will override with specific logic.
    public double area() {
        return 0.0;
    }

    public void describe() {
        System.out.println("This is a generic shape with area: " + area());
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// A class demonstrating compile-time polymorphism (method overloading).
class Calculator {
    // Same method name 'add', different parameter lists.
    // The compiler chooses which one to call based on argument types/count.
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Polymorphism_Demo {
    public static void main(String[] args) {

        // ---------- Runtime Polymorphism ----------
        // The reference type is 'Shape', but the actual object can be
        // Circle or Rectangle. At runtime, JVM calls the OVERRIDDEN
        // version of area() based on the real object -- not the
        // declared reference type. This is dynamic method dispatch.
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Circle(2)
        };

        for (Shape s : shapes) {
            // Even though every element is typed as 'Shape', each call
            // to area() runs the CORRECT subclass implementation.
            s.describe();
        }

        // ---------- Compile-time Polymorphism ----------
        Calculator calc = new Calculator();
        System.out.println("int add: " + calc.add(2, 3));          // calls add(int,int)
        System.out.println("double add: " + calc.add(2.5, 3.5));   // calls add(double,double)
        System.out.println("3-arg add: " + calc.add(1, 2, 3));     // calls add(int,int,int)
    }
}
