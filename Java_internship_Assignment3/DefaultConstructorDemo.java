class Book {
    String title;

    Book() {   // default constructor
        title = "Java Basics";
        System.out.println("Default constructor called");
    }
}

public class DefaultConstructorDemo {
    public static void main(String[] args) {
        Book b = new Book();
        System.out.println(b.title);
    }
}
