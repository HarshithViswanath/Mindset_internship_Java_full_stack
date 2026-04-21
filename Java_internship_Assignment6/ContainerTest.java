class Container<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class ContainerTest {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.setValue(42);
        System.out.println("Integer value: " + intContainer.getValue());

        Container<String> stringContainer = new Container<>();
        stringContainer.setValue("Hello Generics");
        System.out.println("String value: " + stringContainer.getValue());

        Container<Double> doubleContainer = new Container<>();
        doubleContainer.setValue(3.14159);
        System.out.println("Double value: " + doubleContainer.getValue());
    }
}

