import java.math.BigDecimal;
import java.util.Scanner;

public class RecordEditor {

    public static void editRecord(Scanner scanner, Record record) {
        System.out.println("\nEditing Record: ID = " + record.getId());

        System.out.printf("Amount: %.2f\n", record.getAmount());
        if (confirmEdit(scanner)) {
            System.out.print("Enter new amount: ");
            BigDecimal newAmount = scanner.nextBigDecimal();
            scanner.nextLine();
            record.setAmount(newAmount);
        }

        System.out.println("Info: " + record.getInfo());
        if (confirmEdit(scanner)) {
            System.out.print("Enter new info: ");
            String newInfo = scanner.nextLine();
            record.setInfo(newInfo);
        }

        if (record instanceof IncomeRecord income) {
            System.out.println("Category: " + income.getCategory());
            if (confirmEdit(scanner)) {
                System.out.print("Enter new category: ");
                income.setCategory(scanner.nextLine());
            }

            System.out.println("Bank transfer: " + income.isBankTransfer());
            if (confirmEdit(scanner)) {
                System.out.print("Is it a bank transfer? (true/false): ");
                boolean newBankTransfer = scanner.nextBoolean();
                scanner.nextLine();
                income.setBankTransfer(newBankTransfer);
            }

        } else if (record instanceof ExpenseRecord expense) {
            System.out.println("Category: " + expense.getCategory());
            if (confirmEdit(scanner)) {
                System.out.print("Enter new category: ");
                expense.setCategory(scanner.nextLine());
            }

            System.out.println("Payment method: " + expense.getPaymentMethod());
            if (confirmEdit(scanner)) {
                System.out.print("Enter new payment method: ");
                expense.setPaymentMethod(scanner.nextLine());
            }

            System.out.println("Bank card: " + expense.getBankCard());
            if (confirmEdit(scanner)) {
                System.out.print("Enter new bank card: ");
                expense.setBankCard(scanner.nextLine());
            }
        }

        System.out.println("Record updated.");
    }

    private static boolean confirmEdit(Scanner scanner) {
        System.out.print("[1] Edit | [2] Skip: ");
        String input = scanner.nextLine();
        return input.equals("1");
    }
}
