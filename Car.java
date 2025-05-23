package vehicle;

public class Car extends Vehicle {
    public Car(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public void displayInfo(int currentDay) {
        System.out.println("Car: " + brand + ", Number: " + vehicleNumber + ", Price/Day: " + pricePerDay +
            ", Available after " + Math.max(0, getNextAvailableDay() - currentDay) + " day(s)");
    }
}
