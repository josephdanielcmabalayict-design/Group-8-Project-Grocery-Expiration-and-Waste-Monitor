import java.time.LocalDate;

class WasteRecord {

    private String wasteRecordID;
    private String groceryId;
    private String itemName;
    private String category;
    private int quantity;
    private double estimatedLoss;
    private String disposalReason;
    private LocalDate disposalDate;
    
    public WasteRecord(String wasteRecordID, String groceryId, String itemName, String category, int quantity, double estimatedLoss,
                       String disposalReason, LocalDate disposalDate) {

        this.wasteRecordID = wasteRecordID;
        this.groceryId = groceryId;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.estimatedLoss = estimatedLoss;
        this.disposalReason = disposalReason;
        this.disposalDate = disposalDate;
    }

    // Getters
    public String getWasteRecordID() {
        return wasteRecordID;
    }

    public String getGroceryID() {
        return groceryId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getEstimatedLoss() {
        return estimatedLoss;
    }

    public String getDisposalReason() {
        return disposalReason;
    }

    public LocalDate getDisposalDate() {
        return disposalDate;
    }

    public String getDetails() {
        return String.format(
            "%-18s %-15s %-10d PHP %-12.2f %-22s %s", itemName, category, quantity, estimatedLoss, disposalReason, disposalDate );
    }
}
