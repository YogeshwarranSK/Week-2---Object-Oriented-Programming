package Day11;
import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    public String getTaxDetails() {
        return "Tax on Electronics: 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
    public double calculateTax() {
        return getPrice() * 0.05;
    }
    public String getTaxDetails() {
        return "Tax on Clothing: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ProductManagement {
    public static void printFinalPrice(List<Product> products) {
        for (Product product : products) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = 0;
            if (product instanceof Taxable) {
                Taxable t = (Taxable) product;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
            }
            double finalPrice = product.getPrice() + tax - discount;
            System.out.printf("Discount: %.2f\n", discount);
            System.out.printf("Tax: %.2f\n", tax);
            System.out.printf("Final Price: %.2f\n", finalPrice);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1));
            System.out.print("Product type (Electronics/Clothing/Groceries): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            if (type.equals("electronics")) {
                products.add(new Electronics(id, name, price));
            } else if (type.equals("clothing")) {
                products.add(new Clothing(id, name, price));
            } else if (type.equals("groceries")) {
                products.add(new Groceries(id, name, price));
            } else {
                System.out.println("Invalid product type. Skipping.");
            }
        }

        System.out.println("\n=== Final Price Details ===");
        printFinalPrice(products);
        sc.close();
    }
}
