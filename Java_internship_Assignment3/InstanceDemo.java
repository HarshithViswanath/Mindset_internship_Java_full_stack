class Car {
    String brand;   // instance variable
    int speed;      // instance variable

    void showDetails() {   // instance method
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class InstanceDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.brand = "Tesla";
        c.speed = 120;

        c.showDetails();
    }
}
