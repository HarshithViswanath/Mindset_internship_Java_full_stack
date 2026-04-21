public class BinarySearchProgram {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};
        int key = 8;

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Found at index " + mid);
                return;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Element not found");
    }
}
