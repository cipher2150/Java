// OOP is a programming paradigm based on the concept of "objects", which can contain data and code: data in the form of fields (often known as attributes or properties), and code in the form of procedures (often known as methods). 

// Creating a class.
class Animal {
    String name;
    Animal() {
        this.name = "Unnamed";
    }
    Animal(String name) {
        this.name = name;
    }

    void eat(){
        System.out.println(name + " is eating.");
    }
}

// ENCAPSULATION: 
// Binding data and methods together and restricting direct access.
// make fields private and provide public getters/setters.
class Account {
    private int accNumber;
    private double balance;

    public int getAccNumber() {
        return accNumber;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// INHERITANCE:
// One class acquires properties and methods of another.
// Java supports single inheritance.
// Constructors are not inherited.
// Private members are not accessible.

class Elephant extends Animal { 
    void trumpet() {
        System.out.println(name + " is trumpeting.");
    }
}

// POLYMORPHISM:
// Ability to take many forms.
// Method Overloading: same method name with different parameters.
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}
// Method Overriding: subclass provides specific implementation of a method in superclass.
class Dog extends Animal {
    @Override
    void eat() {
        System.out.println(name + " is eating dog food.");
    }
}

// ABSTRACTION:
// Hiding implementation details and showing only essential features.
// Can have abstract and non-abstract methods.
// Cannot create objects of abstract class, and can have constructors.
abstract class Shape {
    abstract void draw(); // Abstract method.
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

// INTERFACES:
// A contract that a class can implement.
// All methods are abstract by default.
interface Vehicle {
    void start();
    void stop();
}

class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bus started.");
    }
    @Override
    public void stop() {
        System.out.println("Bus stopped.");
    }
    public void honk() {
        System.out.println("Bus is honking.");
    }
}

// Garbage Collection:
// Automatic memory management.
// Java has a built-in garbage collector that automatically deallocates memory for objects that are no longer referenced.
// System.gc() can be called to suggest garbage collection, but it's not guaranteed to run immediately.
public class basicOOPs {
    public static void main(String[] args){
        Animal cat = new Animal("Tom");  // Creating an object of the class.
        //cat.name = "Tom";
        cat.eat();

        Elephant dumbo = new Elephant(); // Inherited class object.
        dumbo.name = "Dumbo";
        dumbo.eat();  // Inherited method.
        dumbo.trumpet(); 

        Account acc = new Account(); // Encapsulation example.
        acc.addBalance(500);
        System.out.println("Account Balance: " + acc.getBalance());

        MathOperations math = new MathOperations(); // Polymorphism example.
        System.out.println("Sum of integers: " + math.add(5, 10));
        System.out.println("Sum of doubles: " + math.add(5.5, 10.5));

        Animal dog = new Dog(); // Method overriding example.
        dog.name = "Bob";
        dog.eat(); // Calls overridden method.
        // Method calls depends on object type, not reference type.
        // Fields are not polymorphic.

        Shape shape = new Circle(); // Abstraction example.
        shape.draw(); // Calls implemented method.

        Vehicle bus = new Bus(); // Interface example.
        bus.start();
        bus.stop();
        //bus.honk(); // Not accessible through Vehicle reference, only through Bus reference.
        // To call honk(), we need to cast it.
        ((Bus) bus).honk();
    }
}