# Java Core Topics — Reference Folder

Each `.java` file below is **self-contained and runnable** (it has its own `main` method)
and covers exactly **one topic**, with detailed comments explaining every block of code.
Compile and run any file individually:

```bash
javac Variables_DataTypes.java
java Variables_DataTypes
```

## Suggested Learning Order

| # | File | Topic |
|---|------|-------|
| 1 | `Variables_DataTypes.java` | Primitive types, reference types, `var` inference |
| 2 | `Operators.java` | Arithmetic, relational, logical, bitwise, ternary, compound assignment |
| 3 | `ControlStatements.java` | `if / else if / else`, `switch` (classic + arrow form) |
| 4 | `Loops.java` | `for`, `while`, `do-while`, enhanced-for, `break`/`continue`, labeled loops |
| 5 | `Arrays_Demo.java` | 1D & 2D arrays, iteration, `Arrays` utility methods |
| 6 | `Strings_Demo.java` | Immutability, common `String` methods, `StringBuilder` |
| 7 | `OOP_ClassesObjects.java` | Classes, objects, constructors, `this` keyword |
| 8 | `Inheritance_Demo.java` | `extends`, method overriding, `super`, constructor chaining |
| 9 | `Polymorphism_Demo.java` | Compile-time (overloading) vs runtime (overriding) polymorphism |
| 10 | `Encapsulation_Demo.java` | Private fields, getters/setters, data validation |
| 11 | `Abstraction_AbstractClass_Demo.java` | `abstract` classes and methods |
| 12 | `Interfaces_Demo.java` | Interfaces, `default`/`static` methods, multiple inheritance of type |
| 13 | `ExceptionHandling_Demo.java` | `try/catch/finally`, checked vs unchecked, custom exceptions, `throw`/`throws` |
| 14 | `Collections_Demo.java` | `ArrayList`, `HashMap`, `HashSet`, iteration, sorting with `Comparator` |
| 15 | `Generics_Demo.java` | Generic classes/methods, bounded types, wildcards |
| 16 | `Multithreading_Demo.java` | Extending `Thread`, `Runnable`, lambdas, race conditions, `synchronized` |

## Notes
- All files were **compiled and executed successfully** with OpenJDK 21 before delivery.
- Files that reference helper classes (e.g. `Dog`, `Shape`, `BankAccount`) define those
  classes in the *same* file, right alongside the topic's main demo class — that's normal
  Java (only one `public` class per file, but any number of package-private classes).
- Comments follow a consistent style: a top file-level block explaining the topic, then
  inline comments on each meaningful block/statement explaining *why*, not just *what*.
