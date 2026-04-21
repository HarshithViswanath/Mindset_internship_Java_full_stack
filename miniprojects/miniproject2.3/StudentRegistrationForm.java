import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends Frame implements ActionListener, WindowListener {
    private final TextField nameField;
    private final Choice genderChoice;
    private final Choice courseChoice;

    private final Checkbox hobbySports;
    private final Checkbox hobbyMusic;
    private final Checkbox hobbyReading;

    private final Button submitBtn;
    private final Button clearBtn;

    private final TextArea outputArea;

    public StudentRegistrationForm() {
        super("Student Registration Form (AWT)");

        setLayout(new BorderLayout(10, 10));

        Panel formPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(new Label("Student Name:"), gbc);

        nameField = new TextField(25);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(new Label("Gender:"), gbc);

        genderChoice = new Choice();
        genderChoice.add("Select");
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.add("Other");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        formPanel.add(genderChoice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        formPanel.add(new Label("Course:"), gbc);

        courseChoice = new Choice();
        courseChoice.add("Select");
        courseChoice.add("BCA");
        courseChoice.add("B.Sc");
        courseChoice.add("B.Com");
        courseChoice.add("B.Tech");
        courseChoice.add("MBA");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        formPanel.add(courseChoice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        formPanel.add(new Label("Hobbies:"), gbc);

        Panel hobbiesPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        hobbySports = new Checkbox("Sports");
        hobbyMusic = new Checkbox("Music");
        hobbyReading = new Checkbox("Reading");
        hobbiesPanel.add(hobbySports);
        hobbiesPanel.add(hobbyMusic);
        hobbiesPanel.add(hobbyReading);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        formPanel.add(hobbiesPanel, gbc);

        add(formPanel, BorderLayout.NORTH);

        Panel btnPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 12, 8));
        submitBtn = new Button("Submit");
        clearBtn = new Button("Clear");
        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        btnPanel.add(submitBtn);
        btnPanel.add(clearBtn);
        add(btnPanel, BorderLayout.CENTER);

        outputArea = new TextArea("", 8, 60, TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.SOUTH);

        addWindowListener(this);
        setSize(650, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearBtn) {
            nameField.setText("");
            genderChoice.select(0);
            courseChoice.select(0);
            hobbySports.setState(false);
            hobbyMusic.setState(false);
            hobbyReading.setState(false);
            outputArea.setText("");
            return;
        }

        String name = nameField.getText().trim();
        String gender = genderChoice.getSelectedItem();
        String course = courseChoice.getSelectedItem();

        if (name.isEmpty()) {
            showMessage("Please enter Student Name.");
            nameField.requestFocus();
            return;
        }
        if ("Select".equals(gender)) {
            showMessage("Please select Gender.");
            return;
        }
        if ("Select".equals(course)) {
            showMessage("Please select Course.");
            return;
        }

        String hobbies = buildHobbiesString();

        String result =
                "----- Submitted Details -----\n" +
                "Name   : " + name + "\n" +
                "Gender : " + gender + "\n" +
                "Course : " + course + "\n" +
                "Hobbies: " + hobbies + "\n";

        outputArea.setText(result);
    }

    private String buildHobbiesString() {
        StringBuilder sb = new StringBuilder();
        if (hobbySports.getState()) sb.append("Sports, ");
        if (hobbyMusic.getState()) sb.append("Music, ");
        if (hobbyReading.getState()) sb.append("Reading, ");

        if (sb.length() == 0) return "None";
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    private void showMessage(String msg) {
        Dialog d = new Dialog(this, "Message", true);
        d.setLayout(new BorderLayout(10, 10));
        d.add(new Label("  " + msg + "  "), BorderLayout.CENTER);

        Button ok = new Button("OK");
        ok.addActionListener(ev -> d.setVisible(false));
        Panel p = new Panel(new FlowLayout(FlowLayout.CENTER));
        p.add(ok);
        d.add(p, BorderLayout.SOUTH);

        d.pack();
        d.setLocationRelativeTo(this);
        d.setVisible(true);
        d.dispose();
    }

    @Override public void windowClosing(WindowEvent e) { dispose(); System.exit(0); }
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}

