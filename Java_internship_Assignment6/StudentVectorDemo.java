import java.util.Random;
import java.util.Vector;

class Student<T> {
    private int rollNumber;
    private T data;

    public Student(int rollNumber, T data) {
        this.rollNumber = rollNumber;
        this.data = data;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Student{rollNumber=" + rollNumber + ", data=" + data + "}";
    }
}

public class StudentVectorDemo {
    public static void main(String[] args) {
        Vector<Student<String>> students = new Vector<>();
        Random random = new Random();

        String[] names = {"Alice", "Bob", "Charlie", "David", "Eva"};

        for (String name : names) {
            int rollNumber = random.nextInt(9000) + 1000; // random 4-digit roll number
            Student<String> student = new Student<>(rollNumber, name);
            students.add(student);
        }

        System.out.println("Student details:");
        for (Student<String> student : students) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getData());
        }
    }
}

