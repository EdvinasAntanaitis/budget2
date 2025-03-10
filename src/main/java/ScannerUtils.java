import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ScannerUtils {

    public static IncomeRecord readIncomeRecord(Scanner scanner) {
        System.out.print("Enter income amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Is it a bank transfer? (true/false): ");
        boolean isBankTransfer = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Additional info: ");
        String info = scanner.nextLine();

        return new IncomeRecord(amount, LocalDateTime.now(), info, category, isBankTransfer);
    }

    public static ExpenseRecord readExpenseRecord(Scanner scanner) {
        System.out.print("Enter expense amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter payment method: ");
        String paymentMethod = scanner.nextLine();

        System.out.print("Enter bank card name or number: ");
        String bankCard = scanner.nextLine();

        System.out.print("Additional info: ");
        String info = scanner.nextLine();

        return new ExpenseRecord(amount, LocalDateTime.now(), info, category, paymentMethod, bankCard);
    }
}