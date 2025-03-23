package Day6.Level1;
import java.util.Scanner;
class Books{
    String title;
    String author;
    int price;
    Books(String title,String author,int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void Details(){
        System.out.println("Book Title is "+title);
        System.out.println("Written by "+author);
        System.out.println("Cost of book: "+price);
    }
}
public class books {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name:");
        String title = sc.nextLine();
        System.out.println("Book Author:");
        String author = sc.nextLine();
        System.out.println("Enter Book Price:");
        int price = sc.nextInt();
        Books book = new Books(title,author,price);
        book.Details();
        sc.close();
    }
}
