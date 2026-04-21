import java.util.HashMap;
import java.util.Map;

public class HashMapTraverseEntrySet {
    public static void main(String[] args) {
        HashMap<String, String> countryCapital = new HashMap<>();

        countryCapital.put("USA", "Washington D.C.");
        countryCapital.put("UK", "London");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("India", "New Delhi");

        System.out.println("Traversing HashMap using entrySet():");
        for (Map.Entry<String, String> entry : countryCapital.entrySet()) {
            System.out.println("Country: " + entry.getKey()
                    + ", Capital: " + entry.getValue());
        }
    }
}
