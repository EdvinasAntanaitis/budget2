import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseRecord {
    private static int counter = 0;
    private final int id;
    private final BigDecimal amount;
    private final String category;
    private final LocalDateTime date;
    private final String paymentMethod;
    private final String bankCard;

    public ExpenseRecord(BigDecimal amount, String category, LocalDateTime date, String paymentMethod, String bankCard) {
        this.id = ++counter;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.bankCard = bankCard;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getBankCard() {
        return bankCard;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Amount: %.2f EUR, Category: %s, Date: %s, Payment Method: %s, Bank Card: %s",
                id, amount.doubleValue(), category, date, paymentMethod, bankCard);
    }
}