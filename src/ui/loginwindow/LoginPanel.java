package src.ui.loginwindow;

import java.awt.*;
import javax.swing.*;

public class LoginPanel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPanel() {

        setPreferredSize(new Dimension(350, 400));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Title
        JLabel title = new JLabel("Sign In", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(new Color(40, 50, 80));

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridLayout(3, 1, 10, 20));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250, 40));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 40));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

        loginButton = new JButton("Log In");
        loginButton.setBackground(new Color(40, 90, 200));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));

        formPanel.add(usernameField);
        formPanel.add(passwordField);
        formPanel.add(loginButton);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        // Button Action
        loginButton.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }
}

