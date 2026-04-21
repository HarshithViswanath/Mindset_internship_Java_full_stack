import java.util.ArrayList;
import java.util.Collections;

public class SortArrayListStrings {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Zara");
        names.add("Arun");
        names.add("Mohan");
        names.add("Kiran");
        names.add("Bhavna");

        System.out.println("Before sorting: " + names);
        Collections.sort(names);
        System.out.println("After sorting: " + names);
    }
}
