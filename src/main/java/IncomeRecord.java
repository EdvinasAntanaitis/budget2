import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeRecord {
    private static int counter = 0;
    private final int id;
    private final BigDecimal amount;
    private final String category;
    private final LocalDateTime date;
    private final boolean isBankTransfer;
    private final String otherInfo;

    public IncomeRecord(BigDecimal amount, String category, LocalDateTime date, boolean isBankTransfer, String otherInfo) {
        this.id = ++counter;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isBankTransfer = isBankTransfer;
        this.otherInfo = otherInfo;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isBankTransfer() {
        return isBankTransfer;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Amount: %.2f EUR, Category: %s, Date: %s, Bank Transfer: %b, Info: %s",
                id, amount.doubleValue(), category, date, isBankTransfer, otherInfo);
    }
}