import java.util.HashSet;

public class HashSetNoDuplicates {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20); // duplicate
        numbers.add(10); // duplicate

        System.out.println("HashSet elements: " + numbers);
        System.out.println("Size of HashSet: " + numbers.size());
    }
}
