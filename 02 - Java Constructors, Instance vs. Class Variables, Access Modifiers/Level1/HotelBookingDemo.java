package Day7.Level1;

class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}
    public class HotelBookingDemo {
        public static void main(String[] args) {
            System.out.println("Default Booking:");
            HotelBooking booking1 = new HotelBooking();
            booking1.displayBooking();

            System.out.println("\nParameterized Booking:");
            HotelBooking booking2 = new HotelBooking("Lucky", "Luxury", 3);
            booking2.displayBooking();

            System.out.println("\nCopied Booking:");
            HotelBooking booking3 = new HotelBooking(booking2);
            booking3.displayBooking();
        }
    }
