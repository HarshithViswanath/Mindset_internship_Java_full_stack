// Q2) Java program demonstrating multiple inheritance using interfaces.
//
// A class can implement multiple interfaces, effectively achieving
// multiple inheritance of type.

interface Walkable {
    void walk();
}

interface RunnableTask {
    void runTask();
}

// This class inherits behavior contracts from BOTH interfaces.
class Robot implements Walkable, RunnableTask {
    @Override
    public void walk() {
        System.out.println("Robot is walking.");
    }

    @Override
    public void runTask() {
        System.out.println("Robot is performing a task.");
    }
}

public class MultipleInheritanceExample {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.walk();
        robot.runTask();
    }
}

