import java.util.ArrayList;
import java.util.List;

public class Budget {
    private final List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        records.add(record);
    }

    public boolean removeRecordById(int id) {
        return records.removeIf(record -> record.getId() == id);
    }

    public Record findRecordById(int id) {
        return records.stream()
                .filter(record -> record.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Record> getAllRecords() {
        return new ArrayList<>(records);  // Return a copy of the list to avoid modifying the original
    }

    public double calculateBalance() {
        double totalIncome = records.stream()
                .filter(r -> r instanceof IncomeRecord)
                .mapToDouble(r -> r.getAmount().doubleValue())
                .sum();

        double totalExpenses = records.stream()
                .filter(r -> r instanceof ExpenseRecord)
                .mapToDouble(r -> r.getAmount().doubleValue())
                .sum();

        return totalIncome - totalExpenses;
    }

    public void loadRecords(List<Record> newRecords) {
        records.clear();
        records.addAll(newRecords);
    }
}
