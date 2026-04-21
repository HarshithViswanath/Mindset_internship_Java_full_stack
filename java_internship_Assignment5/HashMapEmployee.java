import java.util.HashMap;
import java.util.Map;

public class HashMapEmployee {
    public static void main(String[] args) {
        HashMap<Integer, String> employees = new HashMap<>();

        employees.put(101, "Alice");
        employees.put(102, "Bob");
        employees.put(103, "Charlie");
        employees.put(104, "Diana");

        System.out.println("Employee details:");
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
