package expenses;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ViewExpensesWindow extends JFrame {

    public ViewExpensesWindow() {
        setTitle("View Expenses");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        setContentPane(scrollPane);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("expenses.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading expenses.txt file: " + e.getMessage());
        }

        setVisible(true);
    }
}



