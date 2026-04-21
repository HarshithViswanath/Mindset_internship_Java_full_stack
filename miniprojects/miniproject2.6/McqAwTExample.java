import java.awt.*;
import java.awt.event.*;

public class McqAwTExample extends Frame implements ActionListener {

    private Label questionLabel;
    private CheckboxGroup optionsGroup;
    private Checkbox optionA, optionB, optionC, optionD;
    private Button submitButton;
    private Label resultLabel;

    public McqAwTExample() {
        super("MCQ using AWT");

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        questionLabel = new Label("What is the capital of France?");
        add(questionLabel);

        optionsGroup = new CheckboxGroup();
        optionA = new Checkbox("Berlin", optionsGroup, false);
        optionB = new Checkbox("Madrid", optionsGroup, false);
        optionC = new Checkbox("Paris", optionsGroup, false);
        optionD = new Checkbox("Rome", optionsGroup, false);

        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);

        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        resultLabel = new Label("Select an answer and click Submit.");
        add(resultLabel);

        setSize(400, 250);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Checkbox selected = optionsGroup.getSelectedCheckbox();

        if (selected == null) {
            resultLabel.setText("Please select an answer.");
            return;
        }

        String selectedText = selected.getLabel();

        if ("Paris".equals(selectedText)) {
            resultLabel.setText("Correct! Paris is the capital of France.");
        } else {
            resultLabel.setText("Incorrect. Try again.");
        }
    }

    public static void main(String[] args) {
        new McqAwTExample();
    }
}
