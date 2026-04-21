class MathOps {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class OverloadingDemo {
    public static void main(String[] args) {
        MathOps m = new MathOps();

        System.out.println(m.add(2, 3));
        System.out.println(m.add(2, 3, 4));
    }
}
