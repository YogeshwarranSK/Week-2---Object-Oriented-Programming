package Day10;
import java.util.Scanner;
class Book {
    protected String title;
    protected int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book {
    private String name;
    private String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
public class BookAuthorManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Publication Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Author Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Author Bio: ");
        String bio = sc.nextLine();
        Author bookWithAuthor = new Author(title, year, name, bio);
        System.out.println("\n--- Book Details ---");
        bookWithAuthor.displayInfo();
    }
}

