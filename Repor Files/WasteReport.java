import java.util.*;

public class WasteReport extends Report {

    private ArrayList<WasteRecord> wasteRecords;

    public WasteReport(ArrayList<WasteRecord> wasteRecords) {
        this.wasteRecords = new ArrayList<>(wasteRecords);
    }

    @Override
    protected String getTitle() {
        return "WASTE REPORT";
    }

    @Override
    protected boolean hasData() {
        return !wasteRecords.isEmpty();
    }

    @Override
    protected String getEmptyMessage() {
        return "No waste records available for reporting.";
    }

    @Override
    protected void printBody() {

        int totalWasteQuantity = 0;
        double totalEstimatedLoss = 0;

        HashMap<String, Integer> categoryTotals = new HashMap<>();

        for (WasteRecord record : wasteRecords) {

            totalWasteQuantity += record.getQuantity();
            totalEstimatedLoss += record.getEstimatedLoss();

            String category = record.getCategory();

            categoryTotals.put(
                category,
                categoryTotals.getOrDefault(category, 0) + record.getQuantity()
            );
        }

        int highestQuantity = 0;

        for (int quantity : categoryTotals.values()) {
            if (quantity > highestQuantity) {
                highestQuantity = quantity;
            }
        }

        System.out.println("Total Waste Records: " + wasteRecords.size());
        System.out.println("Total Items Wasted: " + totalWasteQuantity);
        System.out.printf("Total Estimated Loss: PHP %.2f%n", totalEstimatedLoss);

        System.out.println("\nMost Wasted Category:");

        for (String category : categoryTotals.keySet()) {
            if (categoryTotals.get(category) == highestQuantity) {
                System.out.println(category + " - " + highestQuantity + " item(s)");
            }
        }
    }
}
