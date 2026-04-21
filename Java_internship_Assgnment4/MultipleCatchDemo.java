public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            String text = "123a";
            int number = Integer.parseInt(text);

            int[] arr = new int[2];
            arr[2] = 10;

            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException: " + ex.getMessage());
        } catch (ArithmeticException ex) {
            System.out.println("ArithmeticException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Other exception: " + ex.getMessage());
        }

        System.out.println("Program continues");
    }
}

