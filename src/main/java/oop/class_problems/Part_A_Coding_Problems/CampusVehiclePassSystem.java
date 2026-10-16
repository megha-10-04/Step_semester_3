
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Chargeable {
    void charge();
}

class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner, String type, int fee) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        this.fee = fee;
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {
    ElectricVehicle(String passNumber, String owner, String type, int fee) {
        super(passNumber, owner, type, fee);
    }

    @Override
    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");

            if (parts[0].equals("PASS")) {
                String type = parts[1];
                String pass = parts[2];
                String owner = parts[3];

                int fee = (type.equals("Bike") || type.equals("EBike")
                        || type.equals("E-Bike")) ? 300 : 1000;

                Vehicle vehicle;

                if (type.equals("EBike") || type.equals("E-Bike")
                        || type.equals("ECar") || type.equals("E-Car")) {
                    vehicle = new ElectricVehicle(pass, owner, type, fee);
                } else {
                    vehicle = new Vehicle(pass, owner, type, fee);
                }

                vehicles.put(pass, vehicle);
                vehicle.displayPass();

            } else if (parts[0].equals("CHARGE")) {
                String pass = parts[1];
                Vehicle vehicle = vehicles.get(pass);

                if (vehicle == null) {
                    System.out.println("Vehicle not found");
                } else if (vehicle instanceof Chargeable) {
                    ((Chargeable) vehicle).charge();
                } else {
                    System.out.println(pass + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}
