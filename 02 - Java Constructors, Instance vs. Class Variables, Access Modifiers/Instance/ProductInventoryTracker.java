package Day7.Instance;
import java.util.Scanner;
class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}
public class ProductInventoryTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            products[i] = new Product(name, price);
        }
        System.out.println("\n--- Product Details ---");
        for(Product p : products) p.displayProductDetails();
        Product.displayTotalProducts();
    }
}
