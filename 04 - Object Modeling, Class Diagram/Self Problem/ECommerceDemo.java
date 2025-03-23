package Day9;
import java.util.*;
class Product {
     String name;
     double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
class Order {
     int orderId;
     List<Product> products;
    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": $" +
                    product.getPrice());
            total += product.getPrice();
        }
        System.out.println("Total Amount: $" + total);
    }
}
class Customer1 {
     String name;
     List<Order> orders;
    public Customer1(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order);
    }
    public void showOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }
}
public class ECommerceDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Mouse", 25.50);
        Product p3 = new Product("Keyboard", 45.00);
        Order order1 = new Order(1);
        order1.addProduct(p1);
        order1.addProduct(p2);
        Order order2 = new Order(2);
        order2.addProduct(p3);
        Customer1 customer = new Customer1("Yogesh");
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        System.out.println();
        customer.showOrders();
    }
}