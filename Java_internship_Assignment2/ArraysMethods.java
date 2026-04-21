import java.util.Arrays;

public class ArraysMethods {
    public static void main(String[] args) {

        int[] arr = {7,2,9,1};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int index = Arrays.binarySearch(arr, 7);
        System.out.println("Index of 7 = " + index);
    }
}
