package Day9;
import java.util.ArrayList;
import java.util.List;

record Book(String title, String author) {
    @Override
    public String toString() {
        return "Book Title: " + title + ", Author: " + author;
    }
}
class Library {
    private final String libraryName;
    private final List<Book> books;
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        System.out.println("Library: " + libraryName);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
public class LibraryManagementDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Data Structures", "Jane Smith");
        Book book3 = new Book("Algorithms", "Alex Brown");
        Library library1 = new Library("City Library");
        Library library2 = new Library("Community Library");
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library1.displayBooks();
        library2.displayBooks();
    }
}