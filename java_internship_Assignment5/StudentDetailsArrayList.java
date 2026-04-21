import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentDetailsArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Rahul", 85.5));
        students.add(new Student(2, "Sneha", 92.0));
        students.add(new Student(3, "Aman", 76.3));

        System.out.println("Student details:");
        for (Student s : students) {
            s.display();
        }
    }
}
