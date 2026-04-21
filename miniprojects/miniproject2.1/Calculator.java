import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {

    private final TextField firstNumberField;
    private final TextField secondNumberField;
    private final TextField resultField;

    private final Button addButton;
    private final Button subtractButton;
    private final Button multiplyButton;
    private final Button divideButton;
    private final Button clearButton;

    public Calculator() {
        super("Simple AWT Calculator");

        // Use a 5x2 grid layout:
        // Row 1: "First Number" label + text field
        // Row 2: "Second Number" label + text field
        // Row 3: "Result" label + read-only text field
        // Row 4: "+", "-"
        // Row 5: "×", "÷"
        setLayout(new GridLayout(5, 2, 8, 8));

        Label firstNumberLabel = new Label("First Number:");
        firstNumberField = new TextField();

        Label secondNumberLabel = new Label("Second Number:");
        secondNumberField = new TextField();

        Label resultLabel = new Label("Result:");
        resultField = new TextField();
        resultField.setEditable(false);

        addButton = new Button("+");
        subtractButton = new Button("-");
        multiplyButton = new Button("×");
        divideButton = new Button("÷");
        clearButton = new Button("Clear");

        // Add components to the frame
        add(firstNumberLabel);
        add(firstNumberField);

        add(secondNumberLabel);
        add(secondNumberField);

        add(resultLabel);
        add(resultField);

        add(addButton);
        add(subtractButton);

        add(multiplyButton);
        add(divideButton);

        // We will put Clear button and an empty label in a separate row
        add(clearButton);
        add(new Label(""));

        // Register action listeners for buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setSize(350, 250);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == clearButton) {
            firstNumberField.setText("");
            secondNumberField.setText("");
            resultField.setText("");
            return;
        }

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(firstNumberField.getText().trim());
            num2 = Double.parseDouble(secondNumberField.getText().trim());
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
            return;
        }

        double result;

        if (source == addButton) {
            result = num1 + num2;
            resultField.setText(String.valueOf(result));
        } else if (source == subtractButton) {
            result = num1 - num2;
            resultField.setText(String.valueOf(result));
        } else if (source == multiplyButton) {
            result = num1 * num2;
            resultField.setText(String.valueOf(result));
        } else if (source == divideButton) {
            if (num2 == 0) {
                resultField.setText("Cannot divide by zero");
            } else {
                result = num1 / num2;
                resultField.setText(String.valueOf(result));
            }
        }
    }

    public static void main(String[] args) {
        // Use EventQueue.invokeLater to make sure GUI is created on AWT event thread
        EventQueue.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
