class Employee {
    String name;
    int id;

    Employee(String n, int i) {   // parameterized constructor
        name = n;
        id = i;
    }

    void show() {
        System.out.println(name + " " + id);
    }
}

public class ParameterConstructorDemo {
    public static void main(String[] args) {
        Employee e = new Employee("Rahul", 101);
        e.show();
    }
}
