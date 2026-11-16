import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class FileManager {

    private final String groceryFile = "groceries.txt";
    private final String wasteFile = "waste_records.txt";

    // Encode text so special characters do not break the file format
    private String encode(String text) {
        return Base64.getEncoder().encodeToString(
            text.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String decode(String text) {
        return new String(
            Base64.getDecoder().decode(text),
            StandardCharsets.UTF_8
        );
    }

    // Save grocery items
    public boolean saveGroceries(ArrayList<GroceryItem> groceries) {

        try (PrintWriter writer = new PrintWriter(groceryFile, "UTF-8")) {

            for (GroceryItem item : groceries) {

                writer.println(
                    item.getGroceryId() + "|" +
                    encode(item.getName()) + "|" +
                    encode(item.getCategory()) + "|" +
                    item.getQuantity() + "|" +
                    item.getExpirationDate() + "|" +
                    item.getPrice() + "|" +
                    item.getUnitPrice()
                );
            }

            return true;

        } catch (IOException e) {
            System.out.println("Error saving groceries: " + e.getMessage());
            return false;
        }
    }

    // Load grocery items
    public ArrayList<GroceryItem> loadGroceries() {

        ArrayList<GroceryItem> groceries = new ArrayList<>();

        File file = new File(groceryFile);

        if (!file.exists()) {
            return groceries;
        }

        try (Scanner reader = new Scanner(file, "UTF-8")) {

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] data = line.split("\\|", -1);

                if (data.length != 6 && data.length != 7) {
                    continue;
                }

                try {
                    String id = data[0];
                    String name = decode(data[1]);
                    String category = decode(data[2]);

                    int quantity = Integer.parseInt(data[3]);
                    LocalDate expirationDate = LocalDate.parse(data[4]);
                    double price = Double.parseDouble(data[5]);

                    if (quantity <= 0 || price < 0 || !Double.isFinite(price)) {
                        continue;
                    }

                    GroceryItem item;

                    if (data.length == 7) {
                        double unitPrice = Double.parseDouble(data[6]);

                        if (unitPrice < 0 || !Double.isFinite(unitPrice)) {
                            continue;
                        }

                        item = new GroceryItem(
                            id, name, category, quantity,
                            expirationDate, price, unitPrice
                        );

                    } else {
                        item = new GroceryItem(
                            id, name, category, quantity,
                            expirationDate, price
                        );
                    }

                    groceries.add(item);

                } catch (RuntimeException e) {
                    System.out.println("Skipped an invalid grocery record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading groceries: " + e.getMessage());
        }

        return groceries;
    }

    // Save waste records
    public boolean saveWasteRecords(ArrayList<WasteRecord> records) {

        try (PrintWriter writer = new PrintWriter(wasteFile, "UTF-8")) {

            for (WasteRecord record : records) {

                writer.println(
                    record.getWasteRecordID() + "|" +
                    record.getGroceryID() + "|" +
                    encode(record.getItemName()) + "|" +
                    encode(record.getCategory()) + "|" +
                    record.getQuantity() + "|" +
                    record.getEstimatedLoss() + "|" +
                    encode(record.getDisposalReason()) + "|" +
                    record.getDisposalDate()
                );
            }

            return true;

        } catch (IOException e) {
            System.out.println("Error saving waste records: " + e.getMessage());
            return false;
        }
    }

    // Load waste records
    public ArrayList<WasteRecord> loadWasteRecords() {

        ArrayList<WasteRecord> records = new ArrayList<>();

        File file = new File(wasteFile);

        if (!file.exists()) {
            return records;
        }

        try (Scanner reader = new Scanner(file, "UTF-8")) {

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] data = line.split("\\|", -1);

                if (data.length != 8) {
                    continue;
                }

                try {
                    WasteRecord record = new WasteRecord(
                        data[0],
                        data[1],
                        decode(data[2]),
                        decode(data[3]),
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5]),
                        decode(data[6]),
                        LocalDate.parse(data[7])
                    );

                    records.add(record);

                } catch (RuntimeException e) {
                    System.out.println("Skipped an invalid waste record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading waste records: " + e.getMessage());
        }

        return records;
    }

    // Save both lists
    public void saveAll(GroceryManager manager) {
        boolean ok = saveGroceries(manager.getGroceries());
        ok = saveWasteRecords(manager.getWasteRecords()) && ok;

        if (ok) {
            System.out.println("\nData saved successfully.");
        } else {
            System.out.println("\nData could NOT be fully saved.");
        }
    }
}
