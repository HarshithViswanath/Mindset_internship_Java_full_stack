public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("ArithmeticException caught: " + ex.getMessage());
        }

        System.out.println("Program continues");
    }
}

