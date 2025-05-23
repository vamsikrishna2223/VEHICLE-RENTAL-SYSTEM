package vehicle;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public void displayInfo(int currentDay) {
        System.out.println("Bike: " + brand + ", Number: " + vehicleNumber + ", Price/Day: " + pricePerDay +
            ", Available after " + Math.max(0, getNextAvailableDay() - currentDay) + " day(s)");
    }
}
