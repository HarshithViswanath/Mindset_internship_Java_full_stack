public class AutoboxingUnboxingDemo {
    public static void main(String[] args) {
        int primitiveInt = 25;
        Integer boxedInt = primitiveInt;

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Autoboxed Integer: " + boxedInt);

        Double boxedDouble = 12.5;
        double primitiveDouble = boxedDouble;

        System.out.println("Boxed Double: " + boxedDouble);
        System.out.println("Unboxed double: " + primitiveDouble);
    }
}

