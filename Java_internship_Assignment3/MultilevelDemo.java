class A {
    void show() {
        System.out.println("Class A method");
    }
}

class B extends A {
    void show() {
        System.out.println("Class B method");
    }
}

class C extends B {
    void show() {
        System.out.println("Class C method");
    }
}

public class MultilevelDemo {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();   // overridden method
    }
}
