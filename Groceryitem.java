import java.time.LocalDate;

public class GroceryItem {

        private String groceryId;
        private String name;
        private String category;
        private int quantity;
        private LocalDate expirationDate; //the localdate import
        private double price;
        private double unitPrice;

        //constructor for new grocery
        public GroceryItem(String groceryId, String name, String category, int quantity, 
                           LocalDate expirationDate, double price){
            
            if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
            }

            this.groceryId = groceryId; 
            this.name = name;
            this.category = category;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.price = price;
            this.unitPrice = price / quantity; //from sirs suggestion. try 2 understand this part better
        }

        //constructor for loading saved grocery
        public GroceryItem(String groceryId, String name, String category, int quantity, 
                           LocalDate expirationDate, double price, double unitPrice) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        this.groceryId = groceryId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.price = price;
        this.unitPrice = unitPrice;
    }

        //the gettersz
        public String getGroceryId() {
            return groceryId;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public int getQuantity() {
            return quantity;
        }

        public LocalDate getExpirationDate() {
            return expirationDate;
        }

        public double getPrice() {
            return price;
        }

        public double getUnitPrice() {
        return unitPrice;
        }   

        public String getDetails() {
        return String.format(
            "%-10s %-18s %-15s %-10d %-15s PHP %.2f",
            groceryId, name, category, quantity, expirationDate, price
        ); //String format
        }

       //Setters
       public void setName(String name){
            this.name = name;
       }

       public void setCategory(String category){
            this.category = category;
       }
                            
       public void setQuantity (int quantity){
           if (quantity <= 0) {
              throw new IllegalArgumentException("Quantity must be greater than zero.");
            }

            this.quantity = quantity;
            this.price = unitPrice * quantity; //bcos divided
       }

       public void setPrice (double price){
            if (price < 0 || !Double.isFinite(price)) {
                throw new IllegalArgumentException("Invalid price.");
            }

            this.price = price;
            this.unitPrice = price / quantity; //update happens twice i think? bcos both changes affect both variables. makes sense.
        }

       public void setExpirationDate (LocalDate expirationDate){
            this.expirationDate = expirationDate;
       }

       // Reduce grocery qty after consumption
       public double markAsConsumed(int amount) {
        if (amount <= 0 || amount > quantity) {
            throw new IllegalArgumentException("Invalid quantity.");
        }

        double consumedValue = unitPrice * amount;

        quantity -= amount;
        price = unitPrice * quantity;

        return consumedValue;
    }

    // Reduce grocery qty after disposal
    public double markAsWasted(int amount) {
        if (amount <= 0 || amount > quantity) {
            throw new IllegalArgumentException("Invalid quantity.");
        }

        double wastedValue = unitPrice * amount;

        quantity -= amount;
        price = unitPrice * quantity;

        return wastedValue;
    }
}
