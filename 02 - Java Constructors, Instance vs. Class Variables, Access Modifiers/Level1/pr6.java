package Day7.Level1;
class CarRental {
    public String customerName;
    public String carModel;
    public double rentalDays;
    public double dailyRate;

    CarRental(){
        customerName = "Unknown";
        carModel = "Swift Dzire";
        rentalDays = 1;
        dailyRate = 1000;
    }
    CarRental(String customerName, String carModel, double rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    public double calTotalCost(){
        return rentalDays * dailyRate;
    }
    public void displayTotalCost() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calTotalCost());
    }
}
public class pr6{
    public static void main(String[] args){
        CarRental rental1 = new CarRental("Lucky", "Swift", 3);
        rental1.displayTotalCost();

        System.out.println("--------------");

        CarRental rental2 = new CarRental();
        rental2.displayTotalCost();

    }
}
