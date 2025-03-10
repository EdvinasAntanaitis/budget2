import java.util.List;
import java.util.Scanner;

class Menu {
    private final Budget budget;
    private final Scanner scanner;
    private final FileHandler fileHandler;

    public Menu(Scanner scanner, Budget budget, FileHandler fileHandler) {
        this.scanner = scanner;
        this.budget = budget;
        this.fileHandler = fileHandler;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int choice = readChoice();
            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> showBalance();
                case 4 -> showAllRecords();
                case 5 -> removeRecord();
                case 6 -> editRecord();
                case 7 -> saveToFile();
                case 8 -> loadFromFile();
                case 9 -> {
                    System.out.println("Exiting program. Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Budget Control Menu ===");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. Show Balance");
        System.out.println("4. Show All Records");
        System.out.println("5. Remove Record");
        System.out.println("6. Edit Record");
        System.out.println("7. Save to File");
        System.out.println("8. Load from File");
        System.out.println("9. Exit");
        System.out.print("Select option: ");
    }

    private int readChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void addIncome() {
        IncomeRecord income = ScannerUtils.readIncomeRecord(scanner);
        budget.addRecord(income);
        System.out.println("Income added.");
    }

    private void addExpense() {
        ExpenseRecord expense = ScannerUtils.readExpenseRecord(scanner);
        budget.addRecord(expense);
        System.out.println("Expense added.");
    }

    private void showBalance() {
        double balance = budget.calculateBalance();
        System.out.printf("Your current balance is: %.2f EUR\n", balance);
    }

    private void showAllRecords() {
        System.out.println("\n--- All Records ---");
        budget.getAllRecords().forEach(System.out::println);
    }

    private void removeRecord() {
        System.out.print("Enter ID of record to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean removed = budget.removeRecordById(id);
        if (removed) {
            System.out.println("Record removed.");
        } else {
            System.out.println("Record not found.");
        }
    }

    private void editRecord() {
        System.out.print("Enter ID of record to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Record record = budget.findRecordById(id);
        if (record == null) {
            System.out.println("Record not found.");
            return;
        }
        RecordEditor.editRecord(scanner, record);
    }

    private void saveToFile() {
        fileHandler.saveRecords(budget.getAllRecords());
        System.out.println("Records saved to file.");
    }

    private void loadFromFile() {
        List<Record> records = fileHandler.loadRecords();
        budget.loadRecords(records);
        System.out.println("Records loaded from file.");
    }
}