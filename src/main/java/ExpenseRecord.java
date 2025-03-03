import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseRecord extends Record {
    private final String category;
    private final String paymentMethod;
    private final String bankCard;

    public ExpenseRecord(int id, BigDecimal amount, LocalDateTime date, String info, String category, String paymentMethod, String bankCard) {
        super(id, amount, date, info);
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.bankCard = bankCard;
    }

    public String getCategory() {
        return category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getBankCard() {
        return bankCard;
    }

    @Override
    public String toString() {
        return super.toString() + ", category='" + category + "', paymentMethod='" + paymentMethod + "', bankCard='" + bankCard + "'";
    }
}