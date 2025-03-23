package Day6.Level1;
import java.util.Scanner;
class Items{
    int itemCode;
    String itemName;
    double price;
    int quantity;
    Items(int itemCode, String itemName, double price, int quantity){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    void Details(){
        System.out.println("Itemcode: "+itemCode+
        "\nItemname: "+itemName+
        "\nPrice: "+price);
    }
    void Cost(){
        double totalCost;
        totalCost = (int) (price * quantity);
        System.out.println("Total Cost: "+totalCost);
    }
}
public class items {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Itemcode:");
        int itemCode = sc.nextInt();
        System.out.println("Enter Itemname:");
        String itemName = sc.next();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        System.out.println("Enter Quantity of item: ");
        int quantity = sc.nextInt();
        Items item = new Items(itemCode,itemName,price,quantity);
        item.Details();
        item.Cost();
        sc.close();
    }
}
