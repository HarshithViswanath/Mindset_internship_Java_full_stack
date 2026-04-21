// Q5) Java program using wrapper classes to convert primitive data types into objects.

public class WrapperClassesDemo {
    public static void main(String[] args) {
        // Primitive values
        int intPrimitive = 10;
        double doublePrimitive = 3.14;
        boolean boolPrimitive = true;

        // Converting primitives to wrapper objects (boxing)
        Integer intObject = Integer.valueOf(intPrimitive);
        Double doubleObject = Double.valueOf(doublePrimitive);
        Boolean boolObject = Boolean.valueOf(boolPrimitive);

        System.out.println("Integer object: " + intObject);
        System.out.println("Double object: " + doubleObject);
        System.out.println("Boolean object: " + boolObject);
    }
}

