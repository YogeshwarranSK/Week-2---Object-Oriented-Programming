package Day7.Level1;

import java.util.Scanner;

class Books{
    String title;
    String author;
    double price;

    Books(){
        System.out.println("Default Constructor...");
        title = "ABC";
        author = "x";
        price = 20.0;
    }
    
    void Default(){
        System.out.println("Book name is: "+title+
                "\nBook author is: "+ author+
                "\nBook Price: "+"$"+price);
    }

    Books(String title,String author,double price){
        System.out.println("Parameterized Constructor:");
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void Parameterized(){
        System.out.println("Book Name :"+title);
        System.out.println("Book Author: "+author);
        System.out.println("Book price: "+"$"+price);
    }
}
public class BookConstructorDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book title:");
        String title = sc.nextLine();
        System.out.println("Enter Book author:");
        String author = sc.nextLine();
        System.out.println("Enter Book Price:");
        double price = sc.nextDouble();
        Books book1 = new Books();
        book1.Default();
        Books book2 = new Books(title,author,price);
        book2.Parameterized();
        sc.close();
    }
}
