import java.util.LinkedList;

public class LinkedListInsertDelete {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();

        // Insertion
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        cities.addFirst("Sydney");
        cities.addLast("Paris");

        System.out.println("After insertion: " + cities);

        // Deletion
        cities.removeFirst();
        cities.removeLast();
        cities.remove("Tokyo");

        System.out.println("After deletion: " + cities);
    }
}
