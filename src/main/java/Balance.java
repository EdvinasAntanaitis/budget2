import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balance {
    private final List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        records.add(record);
    }

    public boolean removeRecordById(int id) {
        return records.removeIf(record -> record.getId() == id);
    }

    public List<IncomeRecord> getIncomeRecords() {
        return records.stream()
                .filter(r -> r instanceof IncomeRecord)
                .map(r -> (IncomeRecord) r)
                .collect(Collectors.toList());
    }

    public List<ExpenseRecord> getExpenseRecords() {
        return records.stream()
                .filter(r -> r instanceof ExpenseRecord)
                .map(r -> (ExpenseRecord) r)
                .collect(Collectors.toList());
    }

    public double balance() {
        double totalIncome = getIncomeRecords().stream()
                .mapToDouble(i -> i.getAmount().doubleValue())
                .sum();

        double totalExpenses = getExpenseRecords().stream()
                .mapToDouble(e -> e.getAmount().doubleValue())
                .sum();

        return totalIncome - totalExpenses;
    }

    public Record getRecordById(int id) {
        return records.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Record> getAllRecords() {
        return new ArrayList<>(records);
    }
}