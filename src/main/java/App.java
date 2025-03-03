import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Balance balance = new Balance();

        while (true) {
            System.out.println("\nBudget control system");
            System.out.println("1. Add income");
            System.out.println("2. Add expenses");
            System.out.println("3. Check balance");
            System.out.println("4. View all records");
            System.out.println("5. Remove income or expense record");
            System.out.println("6. Exit");
            System.out.print("Insert menu number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addIncome(scanner, balance);
                case 2 -> addExpenses(scanner, balance);
                case 3 -> System.out.println("Current balance: " + balance.balance() + " EUR");
                case 4 -> printAllRecords(balance);
                case 5 -> removeRecord(scanner, balance);
                case 6 -> {
                    System.out.println("Program closed.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Error: wrong number");
            }
        }
    }

    private static void addIncome(Scanner scanner, Balance balance) {
        System.out.println("Enter income value: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Category: ");
        String category = scanner.nextLine();
        System.out.println("Has the money been received in the bank? (true/false): ");
        boolean isBankTransfer = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Extra info: ");
        String info = scanner.nextLine();
        IncomeRecord incomeRecord = new IncomeRecord(amount, category, LocalDateTime.now(), isBankTransfer, info);
        balance.addIncomeRecord(incomeRecord);
        System.out.println("Added income.");
    }

    private static void addExpenses(Scanner scanner, Balance balance) {
        System.out.print("Enter expense amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Payment method: ");
        String paymentMethod = scanner.nextLine();
        System.out.print("Bank card: ");
        String bankCard = scanner.nextLine();
        System.out.print("Extra info: ");
        String info = scanner.nextLine();
        ExpenseRecord expenseRecord = new ExpenseRecord(amount, category, LocalDateTime.now(), paymentMethod, bankCard);
        balance.addExpenseRecord(expenseRecord);
        System.out.println("Added expense.");
    }

    private static void printAllRecords(Balance balance) {
        System.out.println("\nIncome Records:");
        balance.getIncomeRecords().forEach(System.out::println);
        System.out.println("\nExpense Records:");
        balance.getExpenseRecords().forEach(System.out::println);
    }

    private static void removeRecord(Scanner scanner, Balance balance) {
        System.out.print("Enter the ID of the record to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (balance.removeIncomeRecord(id)) {
            System.out.println("Income record removed.");
        } else if (balance.removeExpenseRecord(id)) {
            System.out.println("Expense record removed.");
        } else {
            System.out.println("Record not found.");
        }
    }
}