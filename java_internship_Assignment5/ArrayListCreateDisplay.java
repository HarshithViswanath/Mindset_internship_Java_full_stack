import java.util.ArrayList;

public class ArrayListCreateDisplay {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        System.out.println("ArrayList elements: " + list);
    }
}
