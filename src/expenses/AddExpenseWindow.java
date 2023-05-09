package expenses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddExpenseWindow extends JFrame {
    private JTextField descriptionField;
    private JTextField amountField;

    public AddExpenseWindow() {
        setTitle("Add Expense");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField();
        contentPanel.add(descriptionLabel);
        contentPanel.add(descriptionField);

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        contentPanel.add(amountLabel);
        contentPanel.add(amountField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                double amount = Double.parseDouble(amountField.getText());

                // Code to save expense here
                // You can access the description and amount variables here
                File file = new File("expenses.txt");
                try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(description + "," + amount + "\n");
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                dispose(); // Close the window after saving
            }
        });
        contentPanel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window without saving
            }
        });
        contentPanel.add(cancelButton);

        setContentPane(contentPanel);
        setVisible(true);
    }
}