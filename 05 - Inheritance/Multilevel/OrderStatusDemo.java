package Day10;
import java.util.Scanner;
class Order {
    protected String orderId;
    protected String orderDate;
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus() {
        return "Shipped with Tracking No: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }
}
public class OrderStatusDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Order Date: ");
        String orderDate = sc.nextLine();
        System.out.print("Enter Tracking Number: ");
        String tracking = sc.nextLine();
        System.out.print("Enter Delivery Date: ");
        String delivery = sc.nextLine();
        DeliveredOrder order = new DeliveredOrder(id, orderDate, tracking, delivery);
        System.out.println("\n--- Order Status ---");
        System.out.println(order.getOrderStatus());
    }
}
