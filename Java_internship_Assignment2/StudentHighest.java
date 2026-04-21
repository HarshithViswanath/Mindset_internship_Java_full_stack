class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentHighest {
    public static void main(String[] args) {

        Student[] s = {
            new Student("Ram", 85),
            new Student("Sam", 92),
            new Student("Tom", 78)
        };

        Student top = s[0];

        for (Student st : s) {
            if (st.marks > top.marks)
                top = st;
        }

        System.out.println("Topper: " + top.name + " Marks: " + top.marks);
    }
}
