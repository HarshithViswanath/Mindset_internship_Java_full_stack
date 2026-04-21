abstract class Vehicle {

    abstract void start();   // abstract method

    void fuelType() {        // non-abstract method
        System.out.println("Uses fuel");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with self-start");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.start();
        b.fuelType();
    }
}
