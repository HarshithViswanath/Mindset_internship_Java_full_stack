import java.util.HashMap;
import java.util.Map;

public class HashMapSubjectMarks {
    public static void main(String[] args) {
        HashMap<String, Integer> subjectMarks = new HashMap<>();

        subjectMarks.put("Math", 90);
        subjectMarks.put("Physics", 85);
        subjectMarks.put("Chemistry", 88);
        subjectMarks.put("English", 92);
        subjectMarks.put("Computer Science", 95);

        System.out.println("Subject marks:");
        for (Map.Entry<String, Integer> entry : subjectMarks.entrySet()) {
            System.out.println("Subject: " + entry.getKey()
                    + ", Marks: " + entry.getValue());
        }
    }
}
