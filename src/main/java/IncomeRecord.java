import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeRecord extends Record {
    private String category;
    private boolean isBankTransfer;

    public IncomeRecord(BigDecimal amount, LocalDateTime date, String info, String category, boolean isBankTransfer) {
        super(amount, date, info);
        this.category = category;
        this.isBankTransfer = isBankTransfer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBankTransfer() {
        return isBankTransfer;
    }

    public void setBankTransfer(boolean isBankTransfer) {
        this.isBankTransfer = isBankTransfer;
    }

    @Override
    public String toCSV() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Category: %s | Bank Transfer: %s", category, isBankTransfer);
    }
}