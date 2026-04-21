interface Printable {
    void print();
}

class Document implements Printable {
    @Override
    public void print() {
        System.out.println("Printing a document");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Printable p = new Document();
        p.print();
    }
}

