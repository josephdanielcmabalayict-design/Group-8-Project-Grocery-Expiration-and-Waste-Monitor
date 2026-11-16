import java.time.LocalDate;
import java.util.*;

public class GroceryManager {
    
    private ArrayList<GroceryItem> groceries; //create an arrayList for the groceries
    private ArrayList<WasteRecord> wasteRecords;

    private int groceryCount;
    private int wastedRecordCount;
    private int nextGroceryId; //new for simplicity

    public GroceryManager() {
        groceries = new ArrayList<>();
        wasteRecords = new ArrayList<>();

        groceryCount = 0;
        wastedRecordCount = 0;
        nextGroceryId = 1;
    }
    
        // Give out the next unused grocery ID: 1, 2, 3, ...
    public String generateGroceryId() {
        return String.valueOf(nextGroceryId++);
    }

    // Keep the counter ahead of any numeric ID that already exists
    private void updateNextGroceryId(String id) {
        try {
            int number = Integer.parseInt(id);

            if (number >= nextGroceryId) {
                nextGroceryId = number + 1;
            }

        } catch (NumberFormatException e) {
            // Old non-numeric IDs (from earlier save files) are ignored
        }
    }

    // Add a grocery item
    public void addGrocery(GroceryItem item) {
        groceries.add(item);
        groceryCount++;
    }

    // Find a grocery item using its ID
    public GroceryItem findGrocery(String id) {
        for (GroceryItem item : groceries) {
            if (item.getGroceryId().equals(id)) {
                return item;
            }
        }

        return null;
    }


    //search for the item
    public ArrayList<GroceryItem> searchGrocery(String keyword) {
        boolean isFound = false;
        ArrayList<GroceryItem> results = new ArrayList<>();

        for (GroceryItem item : groceries){
            if (item.getName().equalsIgnoreCase(keyword)){
                results.add(item);
                isFound = true;
            }
        }
        if (isFound){
            return results;
        }
        return null;
    }


    // Delete an active grocery item. Its waste history is intentionally preserved.
    public boolean deleteGrocery(String id) {
        GroceryItem item = findGrocery(id);

        if (item == null) {
            return false;
        }

        groceries.remove(item);
        groceryCount--;

        return true;
    }

    // Log consumed quantity
    public boolean logConsumed(String id, int amount) {
        GroceryItem item = findGrocery(id);

        if (item == null || amount <= 0 || amount > item.getQuantity()) {
            return false;
        }

        item.markAsConsumed(amount);

        // Remove the item if its remaining quantity is zero
        if (item.getQuantity() == 0) {
            groceries.remove(item);
            groceryCount--;
        }

        return true;
    }

    // Log wasted quantity and create a waste record
    public boolean logWasted(String id, int amount, String reason) {
        GroceryItem item = findGrocery(id);

        if (item == null || amount <= 0 || amount > item.getQuantity()) {
            return false;
        }

        // Save item information before changing its quantity
        String groceryId = item.getGroceryId();
        String itemName = item.getName();
        String category = item.getCategory();

        double estimatedLoss = item.markAsWasted(amount);

        WasteRecord record = new WasteRecord(
            UUID.randomUUID().toString().substring(0, 8),
            groceryId,
            itemName,
            category,
            amount,
            estimatedLoss,
            reason,
            LocalDate.now()
        );

        wasteRecords.add(record);
        wastedRecordCount++;

        if (item.getQuantity() == 0) {
            groceries.remove(item);
            groceryCount--;
        }

        return true;
    }

    // Display all active grocery items
    public void displayGroceries() {
        if (groceries.isEmpty()) {
            System.out.println("\nNo grocery items found.");
            return;
        }

        System.out.println("\n================ CURRENT GROCERIES ================");

        System.out.printf(
            "%-10s %-18s %-15s %-10s %-15s %s%n",
            "ID", "Name", "Category", "Quantity", "Expiration", "Total Price"
        );

        for (GroceryItem item : groceries) {
            System.out.println(item.getDetails());
        }
    }

    // Find items that are already expired or expire within the next three days
    public void checkExpiringItems() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(3);

        boolean found = false;

        System.out.println("\n============= EXPIRATION ALERTS =============");

        for (GroceryItem item : groceries) {

            LocalDate expiration = item.getExpirationDate();

            if (expiration.isBefore(today)) {
                System.out.println("there");
                System.out.println(item.getDetails() + "  [EXPIRED]");
                found = true;
            } else if (!expiration.isAfter(limit)) {
                System.out.println(item.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expired items or items expiring within the next three days.");
        }
    }

    // Display waste history
    public void displayWasteHistory() {
        if (wasteRecords.isEmpty()) {
            System.out.println("\nNo waste records found.");
            return;
        }

        System.out.println("\n================ WASTE HISTORY ================");

        System.out.printf(
            "%-18s %-15s %-10s %-15s %-22s %s%n",
            "Item", "Category", "Quantity",
            "Estimated Loss", "Reason", "Date"
        );

        for (WasteRecord record : wasteRecords) {
            System.out.println(record.getDetails());
        }
    }

    // Get copies of the lists so other classes cannot
    // directly modify the manager's internal collections
    public ArrayList<GroceryItem> getGroceries() {
        return new ArrayList<>(groceries);
    }

    public ArrayList<WasteRecord> getWasteRecords() {
        return new ArrayList<>(wasteRecords);
    }

    public int getGroceryCount() {
        return groceryCount;
    }

    public int getWastedRecordCount() {
        return wastedRecordCount;
    }

    public void loadGroceries(ArrayList<GroceryItem> items) {
        groceries.clear();
        groceries.addAll(items);
        groceryCount = groceries.size();

        for (GroceryItem item : groceries) {
            updateNextGroceryId(item.getGroceryId());
        }
    }

    public void loadWasteRecords(ArrayList<WasteRecord> records) {
        wasteRecords.clear();
        wasteRecords.addAll(records);
        wastedRecordCount = wasteRecords.size();

        // Waste history still refers to deleted items' IDs,
        // so those numbers must never be reused
        for (WasteRecord record : wasteRecords) {
            updateNextGroceryId(record.getGroceryID());
        }
    }
}
