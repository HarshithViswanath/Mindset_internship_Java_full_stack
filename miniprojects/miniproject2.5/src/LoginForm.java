import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginForm extends Frame {

    private final TextField usernameField;
    private final TextField passwordField;
    private final Label messageLabel;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Label titleLabel = new Label("User Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignment(Label.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        Label usernameLabel = new Label("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usernameLabel, gbc);

        usernameField = new TextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        Label passwordLabel = new Label("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new TextField(20);
        passwordField.setEchoChar('*');
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        Button loginButton = new Button("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        messageLabel = new Label("");
        messageLabel.setAlignment(Label.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter username and password.", Color.RED);
            return;
        }

        // Simple validation with hardcoded credentials
        // In real applications, never hardcode credentials.
        if (username.equals("admin") && password.equals("password")) {
            showMessage("Login successful!", new Color(0, 128, 0));
        } else {
            showMessage("Invalid username or password.", Color.RED);
        }
    }

    private void showMessage(String message, Color color) {
        messageLabel.setText(message);
        messageLabel.setForeground(color);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm form = new LoginForm();
                form.setVisible(true);
            }
        });
    }
}

