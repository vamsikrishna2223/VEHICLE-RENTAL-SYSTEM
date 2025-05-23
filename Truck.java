package vehicle;

public class Truck extends Vehicle {
    public Truck(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public void displayInfo(int currentDay) {
        System.out.println("Truck: " + brand + ", Number: " + vehicleNumber + ", Price/Day: " + pricePerDay +
            ", Available after " + Math.max(0, getNextAvailableDay() - currentDay) + " day(s)");
    }
}
