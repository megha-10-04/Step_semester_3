import java.util.*;

abstract class Seat {

    protected String seatNumber;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    abstract double getPrice();

    String getSeatNumber() {
        return seatNumber;
    }
}

class RegularSeat extends Seat {

    RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {

    PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {

    ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 400;
    }
}

class Customer {

    private String name;

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Show {

    private String showName;
    private String showTime;
    private boolean started;

    private Set<String> bookedSeats = new HashSet<>();

    Show(String showName, String showTime) {
        this.showName = showName;
        this.showTime = showTime;
        this.started = false;
    }

    boolean isSeatAvailable(String seatNumber) {
        return !bookedSeats.contains(seatNumber);
    }

    boolean reserveSeat(String seatNumber) {

        if (!isSeatAvailable(seatNumber)) {
            return false;
        }

        bookedSeats.add(seatNumber);
        return true;
    }

    void releaseSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
    }

    boolean hasStarted() {
        return started;
    }

    void startShow() {
        started = true;
    }
}

class Booking {

    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private boolean cancelled = false;

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>();
    }

    boolean addSeat(Seat seat) {

        if (cancelled) {
            return false;
        }

        if (seats.size() >= 6) {

            System.out.println(
                "Cannot book more than 6 seats."
            );

            return false;
        }

        if (!show.reserveSeat(seat.getSeatNumber())) {

            System.out.println(
                "Seat " +
                seat.getSeatNumber() +
                " is already booked for this show."
            );

            return false;
        }

        seats.add(seat);
        return true;
    }

    double calculateTotal() {

        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    void confirm() {

        System.out.print(
            "Booking confirmed for " +
            customer.getName() +
            ": "
        );

        for (int i = 0; i < seats.size(); i++) {

            System.out.print(
                seats.get(i).getSeatNumber()
            );

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf(
            ". Total: ₹%.2f%n",
            calculateTotal()
        );
    }

    void cancel() {

        if (show.hasStarted()) {

            System.out.println(
                "Cannot cancel: show has already started."
            );

            return;
        }

        if (cancelled) {
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(
                seat.getSeatNumber()
            );
        }

        cancelled = true;

        System.out.println(
            customer.getName() +
            "'s booking cancelled."
        );

        System.out.print("Seats ");

        for (int i = 0; i < seats.size(); i++) {

            System.out.print(
                seats.get(i).getSeatNumber()
            );

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" released.");
    }
}

public class M3 {

    public static void main(String[] args) {

        Show show =
            new Show(
                "Campus Premiere",
                "7 PM"
            );

        Customer asha =
            new Customer("Asha");

        Customer ravi =
            new Customer("Ravi");

        Customer neha =
            new Customer("Neha");

        Booking ashaBooking =
            new Booking(asha, show);

        ashaBooking.addSeat(
            new RegularSeat("A1")
        );

        ashaBooking.addSeat(
            new RegularSeat("A2")
        );

        ashaBooking.addSeat(
            new PremiumSeat("F5")
        );

        ashaBooking.confirm();

        Booking raviBooking =
            new Booking(ravi, show);

        raviBooking.addSeat(
            new RegularSeat("A2")
        );

        raviBooking.addSeat(
            new ReclinerSeat("R1")
        );

        raviBooking.confirm();

        ashaBooking.cancel();

        Booking nehaBooking =
            new Booking(neha, show);

        nehaBooking.addSeat(
            new RegularSeat("A2")
        );

        nehaBooking.confirm();
    }
}