package Day11;
import java.util.*;

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private final double nonVegCharge = 10;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    public double calculateTotalPrice() {
        double total = (getPrice() + nonVegCharge) * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discount + "%";
    }
}

public class FoodOrderSystem {
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FoodItem> order = new ArrayList<>();

        System.out.print("Enter number of items in the order: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1));
            System.out.print("Type (Veg/NonVeg): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Item Name: ");
            String name = sc.nextLine();

            System.out.print("Price per unit: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Discount percentage: ");
            double discount = sc.nextDouble();
            sc.nextLine();

            if (type.equals("veg")) {
                VegItem veg = new VegItem(name, price, qty);
                veg.applyDiscount(discount);
                order.add(veg);
            } else if (type.equals("nonveg")) {
                NonVegItem nonVeg = new NonVegItem(name, price, qty);
                nonVeg.applyDiscount(discount);
                order.add(nonVeg);
            } else {
                System.out.println("Invalid item type. Skipping.");
            }
        }

        System.out.println("\n=== Order Summary ===");
        processOrder(order);
        sc.close();
    }
}
