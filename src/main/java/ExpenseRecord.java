import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseRecord extends Record {
    private String category;
    private String paymentMethod;
    private String bankCard;

    public ExpenseRecord(BigDecimal amount, LocalDateTime date, String info, String category, String paymentMethod, String bankCard) {
        super(amount, date, info);
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.bankCard = bankCard;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public String toCSV() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Category: %s | Payment: %s | Card: %s",
                category, paymentMethod, bankCard);
    }
}