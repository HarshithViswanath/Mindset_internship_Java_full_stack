public class LinearSearchProgram {
    public static void main(String[] args) {

        int[] arr = {4, 9, 2, 7, 5};
        int key = 7;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Element not found");
    }
}
