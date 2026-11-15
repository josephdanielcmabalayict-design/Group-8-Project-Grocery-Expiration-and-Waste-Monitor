import java.time.LocalDate;

public class GroceryItem {

        private String groceryId;
        private String name;
        private String category;
        private int quantity;
        private LocalDate expirationDate; //the localdate import
        private double price;
        private double unitPrice;

        public GroceryItem(String groceryId, String name, String category, int quantity, LocalDate expirationDate, double price){
            
            this.groceryId = groceryId; 
            this.name = name;
            this.category = category;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
            this.price = price;
           //(also removed from parameters this.unitPrice = price / quantity; //from sirs suggestion. try 2 understand this part better
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

        public String getDetails() {
        return String.format(
            "ID: %s | Name: %s | Category: %s | Quantity: %d | Expiration: %s | Price: PHP %.2f",
            groceryId, name, category, quantity,
            expirationDate, price
        );
        }

       //le setters

       public void setName(String name){
            this.name = name;
       }

       public void setCategory(String category){
            this.category = category;
       }
                            
       public void setQuantity (int quantity){
            this.quantity = quantity;
            this.price = unitPrice * quantity; //bcos divided
       }

       public void setPrice (double price){
            this.price = price;
            this.unitPrice = price / quantity; //update happens twice i think? bcos both changes affect both variables. makes sense.
        }

       public void setExpirationDate (LocalDate expirationDate){
            this.expirationDate = expirationDate;
       }

   

       // Reduce grocery qty after consumption

    public double markAsConsumed(int amount) {

        double consumedValue = unitPrice * amount;

        quantity -= amount;
        price = unitPrice * quantity;

        return consumedValue;
    }

    // Reduce grocery qty after disposal

    public double markAsWasted(int amount) {

        double wastedValue = unitPrice * amount;

        quantity -= amount;
        price = unitPrice * quantity;

        return wastedValue;
    }
}
