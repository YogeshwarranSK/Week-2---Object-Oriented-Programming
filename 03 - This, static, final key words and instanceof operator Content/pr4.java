package Day8;
import java.util.Scanner;

class Product {
    static double discount = 10.0;
    private static int productCounter = 0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productID = ++productCounter;
        this.productName = this.setProductName(productName);
        this.price = this.setPrice(price);
        this.quantity = this.setQuantity(quantity);
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price * (1 - discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
        } else {
            System.out.println("Invalid product object.");
        }
    }

    public String setProductName(String name) {
        this.productName = name;
        return this.productName;
    }

    public double setPrice(double price) {
        this.price = price;
        return this.price;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return this.quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products to add to cart: ");
        int n = Integer.parseInt(scanner.nextLine());

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1));
            System.out.print("Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            products[i] = new Product(name, price, qty);
        }

        System.out.print("\nEnter new discount percentage to apply: ");
        double newDiscount = Double.parseDouble(scanner.nextLine());
        Product.updateDiscount(newDiscount);

        System.out.println("\nShopping Cart Details:");
        for (Product p : products) {
            p.displayProductDetails();
            System.out.println();
        }

        scanner.close();
    }
}
