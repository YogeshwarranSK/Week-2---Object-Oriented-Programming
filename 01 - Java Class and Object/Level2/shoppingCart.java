package Day6.Level2;

import java.util.ArrayList;
import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    private ArrayList<CartItem> cart = new ArrayList<>();

    public void addItem(String itemName, double price, int quantity) {
        for (CartItem item : cart) {
            if (item.itemName.equalsIgnoreCase(itemName)) {
                item.quantity += quantity;
                return;
            }
        }
        cart.add(new CartItem(itemName, price, quantity));
    }

    public void removeItem(String itemName) {
        for (CartItem item : cart) {
            if (item.itemName.equalsIgnoreCase(itemName)) {
                cart.remove(item);
                System.out.println(itemName + " removed from the cart.");
                return;
            }
        }
        System.out.println(itemName + " not found in the cart.");
    }

    public void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        System.out.printf("Total Cost: $%.2f\n", total);
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (CartItem item : cart) {
                System.out.printf("%s - $%.2f x %d = $%.2f\n",
                        item.itemName, item.price, item.quantity, item.getTotalPrice());
            }
        }
    }
}

public class shoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Show Cart\n4. Display Total Cost\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = sc.nextLine();
                    System.out.print("Enter item price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    cart.addItem(itemName, price, qty);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    cart.removeItem(removeName);
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    cart.displayTotalCost();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
