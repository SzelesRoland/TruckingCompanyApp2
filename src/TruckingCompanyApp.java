import expenses.ExpenseManagementWindow;

import javax.swing.*;

public class TruckingCompanyApp {

    private JFrame mainFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public TruckingCompanyApp() {
        initializeUI();
    }

    private void initializeUI() { 
        mainFrame = new JFrame("Trucking Company App");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(mainFrame, "Login successful!");
                mainFrame.dispose();
                new ExpenseManagementWindow().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Invalid username or password. Please try again.");
            }
        });

        GroupLayout layout = new GroupLayout(loginPanel);
        loginPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(usernameLabel)
                .addComponent(usernameField)
                .addComponent(passwordLabel)
                .addComponent(passwordField)
                .addComponent(loginButton));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(usernameLabel)
                .addComponent(usernameField)
                .addComponent(passwordLabel)
                .addComponent(passwordField)
                .addComponent(loginButton));

        mainFrame.add(loginPanel);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TruckingCompanyApp());
    }
}