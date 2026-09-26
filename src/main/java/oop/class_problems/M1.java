abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return 50 * days;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return 80 * days;
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return 100 * days;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
}

public class M1 {

    static Rental rentVehicle(Vehicle vehicle, Customer customer, int days) {

        if (!vehicle.available) {
            System.out.println(vehicle.name + " is currently unavailable.");
            return null;
        }

        vehicle.available = false;

        Rental rental = new Rental(vehicle, customer, days);

        System.out.println(
            vehicle.name + " rented successfully by " + customer.name
        );

        System.out.println(
            "Rental charge: $" + vehicle.calculateCharge(days)
        );

        return rental;
    }

    static void returnVehicle(Rental rental) {

        rental.vehicle.available = true;

        System.out.println(
            rental.vehicle.name + " returned by " + rental.customer.name
        );
    }

    public static void main(String[] args) {

        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Rental r1 = rentVehicle(sedan, c1, 3);

        rentVehicle(sedan, c2, 2);

        returnVehicle(r1);

        rentVehicle(suv, c3, 5);
    }
}