import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeRecord extends Record{

    private final String category;
    private final boolean isBankTransfer;

    public IncomeRecord(int id, BigDecimal amount, LocalDateTime date, String info, String category, boolean isBankTransfer) {
        super(id, amount, date, info);
        this.category = category;
        this.isBankTransfer = isBankTransfer;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBankTransfer() {
        return isBankTransfer;
    }

    @Override
    public String toString() {
        return super.toString() + ", category='" + category + "', isBankTransfer=" + isBankTransfer;
    }
}