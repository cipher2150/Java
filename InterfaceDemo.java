// An interface is a contract that a class can implement. 
// It defines a set of abstract methods that the implementing class must provide. 
// Interfaces are used to achieve abstraction and multiple inheritance in Java.

import java.util.List;

interface Vechicle{
    int MAX_SPEED = 120; // public static final by default
    void start();
}

class Car implements Vechicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}

// java does not support multiple inheritance with classes.
// But a class can implement multiple interfaces.

/*
    class A{}
    class B{}
    class C extends A, B{} // Diamond Problem: This will cause a compilation error.
*/

// class always wins over interface if there is a conflict in method signatures.
// In interface static methods cannot be called using instance, 
// They must be called using the interface name.

//Functional interfaces: An interface with a single abstract method is called a functional interface.
// they enable Lambda expressions, which provide a concise way to implement the abstract method of the functional interface.
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// Lambdas with collections & Streams

public class InterfaceDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        System.out.println("Max Speed: " + Vechicle.MAX_SPEED);
        // Using a lambda expression to implement the Calculator interface.
        Calculator add = (a, b) -> a + b;
        System.out.println("Addition: " + add.calculate(5, 3));
        
        List<Integer> nums = List.of(1,2,3,4,5);
        nums.stream()
            .filter(n -> n % 2 == 0) // Using a lambda expression to filter even numbers.
            .map(n -> n * n)
            .forEach(System.out::println);// Using method reference to print the filtered numbers.
    }
}

// Lambda can't throw checked exceptions directly.
