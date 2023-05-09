package expenses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class GenerateReportWindow extends JFrame {

    private JTextArea reportArea;
    private JComboBox<String> categoryComboBox;
    private JButton generateButton;

    public GenerateReportWindow() {
        setTitle("Generate Report");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel categoryLabel = new JLabel("Category:");
        categoryComboBox = new JComboBox<>(new String[] {"All", "Food", "Gas", "Maintenance"});
        generateButton = new JButton("Generate");

        topPanel.add(categoryLabel);
        topPanel.add(categoryComboBox);
        topPanel.add(generateButton);

        reportArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(reportArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = (String) categoryComboBox.getSelectedItem();
                List<Expense> expenses = ExpenseManager.getExpensesByCategory(category);

                reportArea.setText("");
                double total = 0.0;
                reportArea.append("Report for " + category + " expenses on " + LocalDate.now() + "\n\n");
                for (Expense expense : expenses) {
                    reportArea.append("Description: " + expense.getDescription() + "\n");
                    reportArea.append("Amount: $" + expense.getAmount() + "\n");
                    reportArea.append("Date: " + expense.getDate() + "\n\n");
                    total = (double) expense.getAmount();
                }
                reportArea.append("Total: $" + total);
            }
        });

        setContentPane(panel);
        setVisible(true);
    }

    public GenerateReportWindow(ExpenseManager expenseManager) {

    }
}
