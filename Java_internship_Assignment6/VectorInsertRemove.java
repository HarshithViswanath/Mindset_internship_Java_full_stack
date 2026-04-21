import java.util.Vector;

public class VectorInsertRemove {
    public static void main(String[] args) {
        Vector<String> items = new Vector<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");

        System.out.println("Original Vector: " + items);

        int insertIndex = 2;
        String elementToInsert = "X";
        if (insertIndex >= 0 && insertIndex <= items.size()) {
            items.add(insertIndex, elementToInsert);
        }
        System.out.println("After insertion at index " + insertIndex + ": " + items);

        int removeIndex = 3;
        if (removeIndex >= 0 && removeIndex < items.size()) {
            items.remove(removeIndex);
        }
        System.out.println("After removal at index " + removeIndex + ": " + items);
    }
}

