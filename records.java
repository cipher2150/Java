record User(String name, int age) {
    public User {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}

// Records cannot extend other classes, but they can implement interfaces.
interface Printable {
    void print();
}

record Invoice(int id, double amount) implements Printable {
    @Override
    public void print() {
        System.out.println("Invoice ID: " + id + ", Amount: " + amount);
    }
    // adding a method.
    public void discount(double percentage) {
        double discountAmount = amount * (percentage / 100);
        System.out.println("Discounted Amount: " + (amount - discountAmount));
    }
} 

// Records are shallowly immutable, 
// meaning that while the record itself cannot be modified after creation, 
// if it contains mutable objects, those objects can be modified.




public class records {
    public static void main(String[] args) {
        User user1 = new User("Alice", 30);
        System.out.println("Name: " + user1.name());
        System.out.println("Age: " + user1.age());  
        //user1.age = 31;  This will cause a compilation error because records are immutable.
        User updateUser = new User(user1.name(), 33); // To update, we create a new instance with the desired changes.
        System.out.println("Updated Age: " + updateUser.age());
        Invoice invoice1 = new Invoice(101, 250.75);
        invoice1.print();
        invoice1.discount(10);
    }
}    