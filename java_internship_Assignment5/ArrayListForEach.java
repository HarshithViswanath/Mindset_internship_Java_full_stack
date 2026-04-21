import java.util.ArrayList;

public class ArrayListForEach {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");
        list.add("Purple");

        System.out.println("Iterating using for-each loop:");
        for (String color : list) {
            System.out.println(color);
        }
    }
}
