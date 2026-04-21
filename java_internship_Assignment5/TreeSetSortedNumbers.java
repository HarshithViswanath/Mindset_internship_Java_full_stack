import java.util.TreeSet;

public class TreeSetSortedNumbers {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Numbers in sorted order (TreeSet): " + numbers);
    }
}
