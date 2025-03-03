import java.util.ArrayList;
import java.util.List;

public class Balance {
    private final List<IncomeRecord> incomeRecords = new ArrayList<>();
    private final List<ExpenseRecord> expenseRecords = new ArrayList<>();

    public void addIncomeRecord(IncomeRecord incomeRecord) {
        incomeRecords.add(incomeRecord);
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord) {
        expenseRecords.add(expenseRecord);
    }

    public List<IncomeRecord> getIncomeRecords() {
        return incomeRecords;
    }

    public List<ExpenseRecord> getExpenseRecords() {
        return expenseRecords;
    }

    public double balance() {
        double totalIncome = incomeRecords.stream().mapToDouble(i -> i.getAmount().doubleValue()).sum();
        double totalExpenses = expenseRecords.stream().mapToDouble(e -> e.getAmount().doubleValue()).sum();
        return totalIncome - totalExpenses;
    }

    public boolean removeIncomeRecord(int id) {
        return incomeRecords.removeIf(record -> record.getId() == id);
    }

    public boolean removeExpenseRecord(int id) {
        return expenseRecords.removeIf(record -> record.getId() == id);
    }
}