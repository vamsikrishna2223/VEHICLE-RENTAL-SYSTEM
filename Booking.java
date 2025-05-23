package vehicle;

public class Booking {
    int startDay;
    int endDay;
    Booking next;

    public Booking(int startDay, int endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.next = null;
    }

    public boolean overlaps(int start, int end) {
        return !(end < this.startDay || start > this.endDay);
    }
}
