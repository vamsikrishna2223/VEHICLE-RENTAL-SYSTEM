package vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
        Scanner sc = new Scanner(System.in);

        // Add vehicles
        rentalService.addVehicle(new Car("C001", "Toyota", 1500));
        rentalService.addVehicle(new Bike("B001", "Yamaha", 500));
        rentalService.addVehicle(new Truck("T001", "Tata", 2500));

        while (true) {
            System.out.print("\nDo you want to book a vehicle? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Thank you! Goodbye.");
                break;
            }

            System.out.print("Enter day to check availability: ");
            int day = sc.nextInt();

            rentalService.showAvailableVehicles(day);
            rentalService.showBookedVehicles();

            sc.nextLine();  // consume newline
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter vehicle number to book: ");
            String vehicleNo = sc.nextLine();
            System.out.print("Enter booking start day: ");
            int startDay = sc.nextInt();
            System.out.print("Enter number of days to book: ");
            int days = sc.nextInt();

            rentalService.rentVehicle(vehicleNo, startDay, days, name);
        }
        sc.close();
    }
}
