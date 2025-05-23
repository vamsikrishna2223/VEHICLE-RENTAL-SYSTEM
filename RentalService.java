package vehicle;

public class RentalService {
    private VehicleNode head;

    public RentalService() {
        head = null;
    }

    public void addVehicle(Vehicle vehicle) {
        VehicleNode newNode = new VehicleNode(vehicle);
        if (head == null) {
            head = newNode;
        } else {
            VehicleNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void showAvailableVehicles(int day) {
        System.out.println("\nAvailable Vehicles on Day " + day + ":");
        boolean anyAvailable = false;
        VehicleNode current = head;
        while (current != null) {
            if (current.vehicle.isAvailable(day, 1)) {
                current.vehicle.displayInfo(day);
                anyAvailable = true;
            }
            current = current.next;
        }
        if (!anyAvailable) {
            System.out.println("No vehicles available.");
        }
    }

    public void showBookedVehicles() {
        System.out.println("\nBooked Vehicles:");
        boolean anyBooked = false;
        VehicleNode current = head;
        while (current != null) {
            Vehicle v = current.vehicle;
            if (v.getNextAvailableDay() > 1) {
                v.displayBookings();
                System.out.println("→ Available after Day " + v.getNextAvailableDay());
                anyBooked = true;
            }
            current = current.next;
        }
        if (!anyBooked) {
            System.out.println("No vehicles booked yet.");
        }
    }

    public void rentVehicle(String vehicleNumber, int startDay, int days, String userName) {
        VehicleNode current = head;
        while (current != null) {
            Vehicle v = current.vehicle;
            if (v.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                if (v.isAvailable(startDay, days)) {
                    v.book(startDay, days);
                    double total = v.getPricePerDay() * days;
                    System.out.println(userName + " booked " + vehicleNumber + " from day " + startDay + " for " + days + " days.");
                    System.out.println("Total Bill: Rs. " + total);
                } else {
                    System.out.println("Vehicle not available for these days. Available after day " + v.getNextAvailableDay());
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Vehicle " + vehicleNumber + " not found.");
    }
}
