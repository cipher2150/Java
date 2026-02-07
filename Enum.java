// Enumerations (enums) 
// It is a special Java class that represents a fixed set of constants.

enum PaymentStatus{
    PENDING(0, "Payment is pending"),
    SUCCESS(1, "Payment successful"),
    FAILED(2, "Payment failed");

    private int code;
    private String msg;

    PaymentStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}


// Enum Restructions:
// Cannot extend a class
// Cannot be instantiated using new keyword
// Constructors cannot be public or protected.
// Cannot extend another enum.
// Can implement interfaces.
// Can have fields and methods.

// Method Overloading.
// Promotion Order: byte -> short -> int -> long -> float -> double

// Overloading with reference types:

class referenceOverloading {
    void method(Object obj) {
        System.out.println("Object version");
    }
    void method(String str) {
        System.out.println("String version");
    }
}

// Var-Args (Variable Arguments)
// Allows 0 or more arguments.

class varArgsDemo {
    void sum(int... numbers){
        int total = 0;
        for (int n : numbers){
            total += n;
        }
        System.out.println("Sum: " + total);
    }
}
// Only one var-args per method.
// Must be last parameter.

// void test(int a, double b){}
// void test(double a, int b){}
// Compile-time error.
// void test(int... nums){}
// void test(int[] arr){}
// compile-time error due to ambiguity.

public class Enum {
    public static void main(String[] args) {
        PaymentStatus status = PaymentStatus.SUCCESS; //Internally: new PaymentStatus(1, "Payment successful");
        System.out.println("Payment Status: " + status);
        System.out.println("Code: " + status.getCode());
        System.out.println("Message: " + status.getMsg());
        referenceOverloading ro = new referenceOverloading();
        ro.method("Hello"); // Calls the String version
        ro.method(123); // Calls the Object version (autoboxing to Integer)

        varArgsDemo vd = new varArgsDemo();
        vd.sum(1, 2, 3); // Sum: 6
    }
}