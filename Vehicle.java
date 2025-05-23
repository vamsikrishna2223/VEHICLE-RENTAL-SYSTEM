package vehicle;

public abstract class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected double pricePerDay;

    protected Booking bookingHead;  // linked list head of bookings

    public Vehicle(String vehicleNumber, String brand, double pricePerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.bookingHead = null;
    }

    public boolean isAvailable(int startDay, int days) {
        int endDay = startDay + days - 1;
        Booking current = bookingHead;
        while (current != null) {
            if (current.overlaps(startDay, endDay)) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void book(int startDay, int days) {
        int endDay = startDay + days - 1;
        Booking newBooking = new Booking(startDay, endDay);
        if (bookingHead == null) {
            bookingHead = newBooking;
        } else {
            Booking current = bookingHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBooking;
        }
    }

    public int getNextAvailableDay() {
        int maxEnd = 0;
        Booking current = bookingHead;
        while (current != null) {
            if (current.endDay > maxEnd) {
                maxEnd = current.endDay;
            }
            current = current.next;
        }
        return maxEnd + 1;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void displayBookings() {
        if (bookingHead == null) {
            System.out.println("No bookings yet.");
            return;
        }
        Booking current = bookingHead;
        System.out.print(vehicleNumber + " bookings: ");
        while (current != null) {
            System.out.print("[Day " + current.startDay + " to Day " + current.endDay + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public abstract void displayInfo(int currentDay);
}
