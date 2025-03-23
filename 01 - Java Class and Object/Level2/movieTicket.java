package Day6.Level2;
import java.util.Scanner;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean isBooked;

    public MovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }

    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName + " at seat " + seatNumber);
        } else {
            System.out.println("Seat " + seatNumber + " is already booked.");
        }
    }

    public void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (isBooked ? "Booked" : "Available"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();
        MovieTicket ticket = new MovieTicket(movieName, seatNumber, price);
        ticket.displayTicketDetails();
        System.out.print("Do you want to book the ticket? (yes/no): ");
        scanner.nextLine();
        if (scanner.nextLine().equalsIgnoreCase("yes")) ticket.bookTicket();
        ticket.displayTicketDetails();
        scanner.close();
    }
}
