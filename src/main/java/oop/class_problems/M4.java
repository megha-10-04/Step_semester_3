import java.time.LocalDate;
import java.util.*;

abstract class Room {

    int roomNumber;
    double pricePerNight;

    Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    abstract double calculatePrice(int nights);
}

class StandardRoom extends Room {

    StandardRoom(int roomNumber) {
        super(roomNumber, 100);
    }

    double calculatePrice(int nights) {
        return pricePerNight * nights;
    }
}

class DeluxeRoom extends Room {

    DeluxeRoom(int roomNumber) {
        super(roomNumber, 150);
    }

    double calculatePrice(int nights) {
        return pricePerNight * nights;
    }
}

class Suite extends Room {

    Suite(int roomNumber) {
        super(roomNumber, 250);
    }

    double calculatePrice(int nights) {
        return pricePerNight * nights;
    }
}

class Customer {

    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {

    Room room;
    Customer customer;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate cancellationDeadline;
    boolean active = true;

    Reservation(
        Room room,
        Customer customer,
        LocalDate startDate,
        LocalDate endDate,
        LocalDate cancellationDeadline
    ) {
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationDeadline = cancellationDeadline;
    }

    boolean overlaps(LocalDate start, LocalDate end) {

        return active &&
               start.isBefore(endDate) &&
               end.isAfter(startDate);
    }

    double calculatePrice() {

        long nights =
            java.time.temporal.ChronoUnit.DAYS.between(
                startDate,
                endDate
            );

        return room.calculatePrice((int) nights);
    }

    void cancel(LocalDate today) {

        if (!active) {
            System.out.println("Reservation is already cancelled.");
            return;
        }

        if (today.isAfter(cancellationDeadline)) {
            System.out.println(
                "Cancellation deadline has passed."
            );
            return;
        }

        active = false;

        System.out.println(
            "Reservation for " +
            customer.name + ", Room " +
            room.roomNumber +
            " cancelled successfully."
        );
    }
}

public class M4 {

    static ArrayList<Reservation> reservations =
        new ArrayList<>();

    static boolean isAvailable(
        Room room,
        LocalDate start,
        LocalDate end
    ) {

        for (Reservation reservation : reservations) {

            if (reservation.room == room &&
                reservation.overlaps(start, end)) {

                return false;
            }
        }

        return true;
    }

    static Reservation bookRoom(
        Room room,
        Customer customer,
        LocalDate start,
        LocalDate end
    ) {

        if (!isAvailable(room, start, end)) {

            System.out.println(
                "Room " + room.roomNumber +
                " is not available from " +
                start + " to " + end
            );

            return null;
        }

        Reservation reservation =
            new Reservation(
                room,
                customer,
                start,
                end,
                start.minusDays(1)
            );

        reservations.add(reservation);

        System.out.println(
            "Reservation confirmed for " +
            customer.name +
            ", Room " +
            room.roomNumber +
            " (" + start + "-" + end + ")."
        );

        System.out.println(
            "Price: $" + reservation.calculatePrice()
        );

        return reservation;
    }

    public static void main(String[] args) {

        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);

        Customer customerA =
            new Customer("Customer A");

        Customer customerB =
            new Customer("Customer B");

        Customer customerC =
            new Customer("Customer C");

        LocalDate jan1 = LocalDate.of(2027, 1, 1);
        LocalDate jan5 = LocalDate.of(2027, 1, 5);
        LocalDate jan3 = LocalDate.of(2027, 1, 3);
        LocalDate jan7 = LocalDate.of(2027, 1, 7);

        System.out.println(
            "Standard Room 101 is " +
            (isAvailable(standard, jan1, jan5)
                ? "available"
                : "not available") +
            " from Jan 1 to Jan 5."
        );

        Reservation r1 =
            bookRoom(
                standard,
                customerA,
                jan1,
                jan5
            );

        bookRoom(
            standard,
            customerB,
            jan3,
            jan7
        );

        if (r1 != null) {
            r1.cancel(jan1);
        }

        bookRoom(
            deluxe,
            customerC,
            LocalDate.of(2027, 2, 10),
            LocalDate.of(2027, 2, 12)
        );
    }
}