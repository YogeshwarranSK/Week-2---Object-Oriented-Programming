package Day7.Access_Modifiers;
import java.util.Scanner;
class Book {
    public String ISBN;
    protected String title;
    private String author;
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
class EBook extends Book {
    private double fileSize;
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }
    public void displayEBook() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
    }
}
public class EBookInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter File Size (MB): ");
        double size = sc.nextDouble();
        EBook ebook = new EBook(isbn, title, author, size);
        ebook.displayEBook();
        sc.nextLine();
        System.out.print("Update Author: ");
        String newAuthor = sc.nextLine();
        ebook.setAuthor(newAuthor);
        System.out.println("\nUpdated EBook Details:");
        ebook.displayEBook();
    }
}
