import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static GroceryManager groceryManager = new GroceryManager(); //so we can call the functions inside GroceryManager
    private static FileManager fileManager = new FileManager();  //same but for fileManager methods
   
    public static void main(String[] args) {

        // Load saved data when the program starts
        groceryManager.loadGroceries(fileManager.loadGroceries());
        groceryManager.loadWasteRecords(fileManager.loadWasteRecords());

        System.out.println("==================================");
        System.out.println("     GROCERY & WASTE MANAGER");
        System.out.println("==================================");

        groceryManager.checkExpiringItems(); // expiring alert


        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    groceryManager.displayGroceries();
                    break;

                case 2:
                    addGroceryMenu();
                    break;

                case 3:
                    editGroceryMenu();
                    break;

                case 4: 
                    findGrocery();
                    break;

                case 5:
                    deleteGroceryMenu();
                    break;

                case 6:
                    consumeGroceryMenu();
                    break;

                case 7:
                    wasteGroceryMenu();
                    break;

                case 8:
                    groceryManager.displayWasteHistory();
                    break;

                case 9:
                    showReport(new WasteReport(groceryManager.getWasteRecords()));
                    break;

                case 10:
                  fileManager.saveAll(groceryManager);
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Main menu
    private static void displayMenu() {

        System.out.println("\n============== MAIN MENU ==============");
        System.out.println("1. View Current Groceries");
        System.out.println("2. Add Grocery");
        System.out.println("3. Edit Grocery");
        System.out.println("4. Search Grocery");
        System.out.println("5. Delete Grocery");
        System.out.println("6. Log Consumed Grocery");
        System.out.println("7. Log Wasted Grocery");
        System.out.println("8. View Waste History");
        System.out.println("9. View Waste Report");
        System.out.println("10. Save and Exit");
        System.out.println("=======================================");
    }

    // Add grocery menu
    private static void addGroceryMenu() {

        System.out.println("\n========== ADD GROCERY ==========");

        String name = readNonEmptyString("Enter item name: "); //these used the methods from below to validate entries VVVV
        String category = readNonEmptyString("Enter category: ");

        int quantity = readPositiveInt("Enter quantity: ");

        LocalDate expirationDate = readDate("Enter expiration date (YYYY-MM-DD): ");

        double price = readNonNegativeDouble("Enter total price: ");

        String id = groceryManager.generateGroceryId();

        GroceryItem item = new GroceryItem(id, name, category, quantity, expirationDate, price);

        groceryManager.addGrocery(item);

        System.out.println("\nGrocery item added successfully.");
        System.out.println("Generated ID: " + id);
    }

    //search Grocery
    private static void findGrocery() {
        String name = readNonEmptyString("Enter item name to search: ");

        ArrayList<GroceryItem> results = groceryManager.searchGrocery(name);

        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.printf(
            "%-10s %-18s %-15s %-10s %-15s %s%n",
            "ID", "Name", "Category", "Quantity", "Expiration", "Total Price");

            for (GroceryItem item : results) {
                System.out.println(item.getDetails());
            }

        }
    }

    // Edit grocery menu
    private static void editGroceryMenu() {

        groceryManager.displayGroceries();

        String id = readNonEmptyString("\nEnter grocery ID to edit: ");

        GroceryItem item = groceryManager.findGrocery(id);

        if (item == null) {
            System.out.println("Grocery item not found.");
            return;
        }

        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Quantity");
        System.out.println("4. Expiration Date");
        System.out.println("5. Total Price");

        int choice = readInt("Enter choice: ");

        switch (choice) {

            case 1:
                item.setName(readNonEmptyString("Enter new name: "));
                break;

            case 2:
                item.setCategory(readNonEmptyString("Enter new category: "));
                break;

            case 3:
                item.setQuantity(readPositiveInt("Enter new quantity: "));
                break;

            case 4:
                item.setExpirationDate(
                    readDate("Enter new expiration date (YYYY-MM-DD): ")
                );
                break;

            case 5:
                item.setPrice(readNonNegativeDouble("Enter new total price: "));
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Grocery item updated successfully.");
    }

    // Delete grocery menu
    private static void deleteGroceryMenu() {

        groceryManager.displayGroceries();

        String id = readNonEmptyString("\nEnter grocery ID to delete: ");

        GroceryItem item = groceryManager.findGrocery(id);

        if (item == null) {
            System.out.println("Grocery item not found.");
            return;
        }

        System.out.println("\nYou are deleting: " + item.getName());
        System.out.println("Its existing waste history will be preserved.");

        String confirmation = readNonEmptyString("Confirm deletion? (yes/no): ");

        if (confirmation.equalsIgnoreCase("yes")) {

            groceryManager.deleteGrocery(id);

            System.out.println("Grocery item deleted successfully.");

        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // Log consumed grocery menu
    private static void consumeGroceryMenu() {

        groceryManager.displayGroceries();

        String id = readNonEmptyString("\nEnter grocery ID: ");

        GroceryItem item = groceryManager.findGrocery(id);

        if (item == null) {
            System.out.println("Grocery item not found.");
            return;
        }

        int amount = readPositiveInt("Enter quantity consumed: ");

        if (amount > item.getQuantity()) {
            System.out.println("You cannot consume more than the available quantity.");
            return;
        }

        groceryManager.logConsumed(id, amount);

        System.out.println("Consumption recorded successfully.");
    }

    // Log wasted grocery menu
    private static void wasteGroceryMenu() {

        groceryManager.displayGroceries();

        String id = readNonEmptyString("\nEnter grocery ID: ");

        GroceryItem item = groceryManager.findGrocery(id);

        if (item == null) {
            System.out.println("Grocery item not found.");
            return;
        }

        int amount = readPositiveInt("Enter quantity wasted: ");

        if (amount > item.getQuantity()) {
            System.out.println("You cannot waste more than the available quantity.");
            return;
        }

        String reason = readNonEmptyString(
            "Enter disposal reason (e.g. expired, moldy, spoiled): "
        );

        groceryManager.logWasted(id, amount, reason);

        System.out.println("Waste record created successfully.");
    }

    // Display waste report using a parent-class reference
    private static void displayWasteReport() {

        Report report = new WasteReport(groceryManager.getWasteRecords());

        report.displayReport();
    }


    //input validations
    private static int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static int readPositiveInt(String prompt) {

        while (true) {

            int value = readInt(prompt);

            if (value > 0) {
                return value;
            }

            System.out.println("Value must be greater than zero.");
        }
    }

    private static double readNonNegativeDouble(String prompt) {

        while (true) {

            System.out.print(prompt);

            try {
                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value >= 0 && Double.isFinite(value)) {
                    return value;
                }

                System.out.println("Enter a valid non-negative amount.");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {

        while (true) {

            System.out.print(prompt);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    private static LocalDate readDate(String prompt) {

        while (true) {

            System.out.print(prompt);

            try {
                return LocalDate.parse(scanner.nextLine().trim());

            } catch (Exception e) {
                System.out.println("Invalid date. Use YYYY-MM-DD.");
            }
        }
    }
    
    private static void showReport(Report report) {
        report.displayReport();
    }
}
