
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Budget budget = new Budget();
        FileHandler fileHandler = new FileHandler();
        Menu menu = new Menu(scanner, budget, fileHandler);
        menu.start();
        scanner.close();
    }
}