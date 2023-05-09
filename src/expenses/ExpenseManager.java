package expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private static List<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public static void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public static ExpenseManager getInstance() {
        return null;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public static List<Expense> getExpensesByCategory(String category) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public double getTotalExpense() {
        double total = 0;
        for (Expense expense : expenses) {
            total =total +(double)  expense.getAmount();
        }
        return total;
    }

    public double getTotalExpenseByCategory(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                total =total +(double)  expense.getAmount();
            }
        }
        return total;
    }
}
