import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileHandler {
    private static final String FILE_NAME = "budget_records.csv";

    public void saveRecords(List<Record> records) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Record record : records) {
                writer.println(record.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    public List<Record> loadRecords() {
        List<Record> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Record record = Record.fromCSV(line);
                if (record != null) {
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }
        return records;
    }
}
