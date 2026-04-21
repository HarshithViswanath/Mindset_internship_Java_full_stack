class Student {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class ClassObjectDemo {
    public static void main(String[] args) {
        Student s1 = new Student();   // object creation
        s1.name = "Harshith";
        s1.age = 21;

        s1.display();
    }
}
