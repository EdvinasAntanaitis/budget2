import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {

    static final BudgetService budgetService = new BudgetService();

    public static void main(String[] args) {

        List<IncomeRecord> incomeRecords = new ArrayList<>();


        System.out.println("Hello My Budget!");
        System.out.println("This is Demo Version!");
        final IncomeRecord incomeRecord = new IncomeRecord(
                BigDecimal.valueOf(1500), "Salary", LocalDateTime.now(), true, null);
        final ExpenseRecord expenseRecord = new ExpenseRecord(
                BigDecimal.valueOf(100), "Food", LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"));

        budgetService.setIncomeRecord(incomeRecord);
        budgetService.setExpenseRecords(expenseRecord);

        printIncomeRecords();
        printExpenseRecords();
    }

    private static void printIncomeRecords() {
        final List<IncomeRecord> records = budgetService.getIncomeRecords();
        for (IncomeRecord record : records) {
            System.out.println(record);
        }
    }

    private static void printExpenseRecords() {
        final List<ExpenseRecord> records = budgetService.getExpenseRecords();
        for (ExpenseRecord record : records) {
            System.out.println(record);
        }
    }
}