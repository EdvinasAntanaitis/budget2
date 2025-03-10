import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Record {
    private static int counter = 1;

    private final int id;
    private BigDecimal amount;
    private final LocalDateTime date;
    private String info;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Record(BigDecimal amount, LocalDateTime date, String info) {
        this.id = counter++;
        this.amount = amount;
        this.date = date;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    // 🟢 Abstract method that must be overridden in subclasses
    public abstract String toCSV();

    public static Record fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length < 5) return null;

        int id = Integer.parseInt(parts[1]);
        BigDecimal amount = new BigDecimal(parts[2]);
        String info = parts[3];
        LocalDateTime date = LocalDateTime.parse(parts[4], FORMATTER);

        if (parts[0].equals("I")) {  // IncomeRecord
            String category = parts[5];
            boolean isBankTransfer = Boolean.parseBoolean(parts[6]);
            return new IncomeRecord(amount, date, info, category, isBankTransfer);
        } else if (parts[0].equals("E")) {  // ExpenseRecord
            String category = parts[5];
            String paymentMethod = parts[6];
            String bankCard = parts[7];
            return new ExpenseRecord(amount, date, info, category, paymentMethod, bankCard);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Amount: %.2f | Date: %s | Info: %s",
                id, amount, date.format(FORMATTER), info);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Record other = (Record) obj;
        return id == other.id;
    }
}
