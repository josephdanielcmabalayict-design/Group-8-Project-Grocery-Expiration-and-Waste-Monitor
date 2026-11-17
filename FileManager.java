import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileManager {

    private final String groceryFile = "groceries.txt";
    private final String wasteFile = "waste_records.txt";

    // Save grocery items
    public boolean saveGroceries(ArrayList<GroceryItem> groceries) {

        try {
            PrintWriter writer = new PrintWriter(groceryFile);

            for (GroceryItem item : groceries) {

                writer.println(
                    item.getGroceryId() + "|" +
                    item.getName() + "|" +
                    item.getCategory() + "|" +
                    item.getQuantity() + "|" +
                    item.getExpirationDate() + "|" +
                    item.getPrice() + "|" +
                    item.getUnitPrice()
                );
            }

            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error saving groceries.");
            return false;
        }
    }

    // Load grocery items
    public ArrayList<GroceryItem> loadGroceries() {

        ArrayList<GroceryItem> groceries = new ArrayList<>();

        try {
            File file = new File(groceryFile);

            if (!file.exists()) {
                return groceries;
            }

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] data = line.split("\\|");

                if (data.length == 7) {

                    String id = data[0];
                    String name = data[1];
                    String category = data[2];
                    int quantity = Integer.parseInt(data[3]);
                    LocalDate expirationDate = LocalDate.parse(data[4]);
                    double price = Double.parseDouble(data[5]);
                    double unitPrice = Double.parseDouble(data[6]);

                    GroceryItem item = new GroceryItem(
                        id, name, category, quantity,
                        expirationDate, price, unitPrice
                    );

                    groceries.add(item);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading groceries.");
        }

        return groceries;
    }

    // Save waste records
    public boolean saveWasteRecords(ArrayList<WasteRecord> records) {

        try {
            PrintWriter writer = new PrintWriter(wasteFile);

            for (WasteRecord record : records) {

                writer.println(
                    record.getWasteRecordID() + "|" +
                    record.getGroceryID() + "|" +
                    record.getItemName() + "|" +
                    record.getCategory() + "|" +
                    record.getQuantity() + "|" +
                    record.getEstimatedLoss() + "|" +
                    record.getDisposalReason() + "|" +
                    record.getDisposalDate()
                );
            }

            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error saving waste records.");
            return false;
        }
    }

    // Load waste records
    public ArrayList<WasteRecord> loadWasteRecords() {

        ArrayList<WasteRecord> records = new ArrayList<>();

        try {
            File file = new File(wasteFile);

            if (!file.exists()) {
                return records;
            }

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] data = line.split("\\|");

                if (data.length == 8) {

                    WasteRecord record = new WasteRecord(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5]),
                        data[6],
                        LocalDate.parse(data[7])
                    );

                    records.add(record);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading waste records.");
        }

        return records;
    }

    // Save all data
    public void saveAll(GroceryManager manager) {

        boolean grocerySaved = saveGroceries(manager.getGroceries());
        boolean wasteSaved = saveWasteRecords(manager.getWasteRecords());

        if (grocerySaved && wasteSaved) {
            System.out.println("Data saved successfully.");
        } else {
            System.out.println("Error saving data.");
        }
    }
}
