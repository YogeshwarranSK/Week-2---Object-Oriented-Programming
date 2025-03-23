package Day11;
import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.borrowerName = "";
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    protected void setBorrowerName(String name) { this.borrowerName = name; }
    protected String getBorrowerName() { return borrowerName; }

    protected void setReserved(boolean reserved) { this.isReserved = reserved; }
    protected boolean isReserved() { return isReserved; }

    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Reserved: " + (isReserved ? "Yes" : "No"));
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Book reserved for: " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Magazine reserved for: " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("DVD reserved for: " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

public class LibraryManagementSystem {
    public static void processLibraryItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                System.out.println("Available: " + res.checkAvailability());
            }
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        System.out.print("Enter number of library items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1));
            System.out.print("Item type (Book/Magazine/DVD): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Item ID: ");
            String id = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            if (type.equals("book")) {
                items.add(new Book(id, title, author));
            } else if (type.equals("magazine")) {
                items.add(new Magazine(id, title, author));
            } else if (type.equals("dvd")) {
                items.add(new DVD(id, title, author));
            } else {
                System.out.println("Invalid item type. Skipping.");
            }
        }

        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                System.out.print("Enter borrower name to reserve item " + item.getTitle() + ": ");
                String borrower = sc.nextLine();
                ((Reservable) item).reserveItem(borrower);
            }
        }

        System.out.println("\n=== Library Item Summary ===");
        processLibraryItems(items);
        sc.close();
    }
}

