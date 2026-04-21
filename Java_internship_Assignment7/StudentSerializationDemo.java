import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class StudentSerializationDemo {
    public static void main(String[] args) {
        String fileName = "student.ser";

        Student s = new Student(1, "Alice", 88.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(s);
            System.out.println("Student object serialized to " + fileName);
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student deserialized = (Student) ois.readObject();
            System.out.println("Deserialized student: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
    }
}
