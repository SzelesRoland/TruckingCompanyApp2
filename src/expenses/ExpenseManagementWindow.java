package expenses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExpenseManagementWindow {
    private JFrame frame;
    private JButton addExpenseButton, viewExpensesButton, generateReportButton;

    public ExpenseManagementWindow() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Expense Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        addExpenseButton = new JButton("Add Expense");
        viewExpensesButton = new JButton("View Expenses");
        generateReportButton = new JButton("Generate Report");

        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Expense button clicked");
                AddExpenseWindow addExpenseWindow = new AddExpenseWindow();
                addExpenseWindow.setVisible(true);
            }
        });

        viewExpensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Expenses button clicked");
                ViewExpensesWindow viewExpensesWindow = new ViewExpensesWindow();
                viewExpensesWindow.setVisible(true);
            }
        });

        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Generate Report button clicked");
                GenerateReportWindow generateReportWindow = new GenerateReportWindow();
                generateReportWindow.setVisible(true);
            }
        });

        frame.add(addExpenseButton);
        frame.add(viewExpensesButton);
        frame.add(generateReportButton);
        frame.setVisible(true);
    }

    public void setVisible(boolean b) {
    }
}