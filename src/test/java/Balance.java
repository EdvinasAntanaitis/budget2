import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Balance {
    private Budget budget;

    @BeforeEach
    void setUp() {
        budget = new Budget();
    }

    @Test
    void testCalculateBalance() {
        LocalDateTime LocalDateTime = null;
        budget.addRecord(new IncomeRecord(new BigDecimal("500.00"), LocalDateTime, "salary", "Bank transfer", true));
        budget.addRecord(new ExpenseRecord(new BigDecimal("200.00"), LocalDateTime, "gas", "Bank transfer", "Card", "GreatBank"));
        assertEquals(300.00, budget.calculateBalance(), 0.01);
    }
}