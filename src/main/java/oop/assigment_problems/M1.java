abstract class WashType {

    abstract int getDuration();

    abstract double getCharge();

    abstract String getName();
}

class QuickWash extends WashType {

    int getDuration() {
        return 30;
    }

    double getCharge() {
        return 20;
    }

    String getName() {
        return "Quick";
    }
}

class NormalWash extends WashType {

    int getDuration() {
        return 45;
    }

    double getCharge() {
        return 30;
    }

    String getName() {
        return "Normal";
    }
}

class HeavyWash extends WashType {

    int getDuration() {
        return 60;
    }

    double getCharge() {
        return 45;
    }

    String getName() {
        return "Heavy";
    }
}

class Student {

    private String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class WashingMachine {

    private String machineId;
    private boolean busy = false;

    WashingMachine(String machineId) {
        this.machineId = machineId;
    }

    String getMachineId() {
        return machineId;
    }

    boolean isBusy() {
        return busy;
    }

    void startMachine() {
        busy = true;
    }

    void completeMachine() {
        busy = false;
    }
}

class WashCycle {

    private Student student;
    private WashingMachine machine;
    private WashType washType;

    WashCycle(
        Student student,
        WashingMachine machine,
        WashType washType
    ) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    void start() {

        if (machine.isBusy()) {
            System.out.println(
                "Machine " +
                machine.getMachineId() +
                " is currently busy."
            );
            return;
        }

        machine.startMachine();

        System.out.println(
            washType.getName() +
            " wash started on " +
            machine.getMachineId() +
            " for " +
            student.getName() +
            " (" +
            washType.getDuration() +
            " min)."
        );

        System.out.printf(
            "Charge: ₹%.2f%n",
            washType.getCharge()
        );
    }

    void complete() {

        machine.completeMachine();

        System.out.println(
            machine.getMachineId() +
            " cycle completed."
        );

        System.out.println(
            machine.getMachineId() +
            " is now free."
        );
    }
}

public class M1 {

    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 =
            new WashingMachine("M1");

        WashingMachine m2 =
            new WashingMachine("M2");

        WashCycle quickWash =
            new WashCycle(
                asha,
                m1,
                new QuickWash()
            );

        quickWash.start();

        WashCycle heavyWashOnM1 =
            new WashCycle(
                ravi,
                m1,
                new HeavyWash()
            );

        heavyWashOnM1.start();

        WashCycle heavyWashOnM2 =
            new WashCycle(
                ravi,
                m2,
                new HeavyWash()
            );

        heavyWashOnM2.start();

        quickWash.complete();

        WashCycle normalWash =
            new WashCycle(
                neha,
                m1,
                new NormalWash()
            );

        normalWash.start();
    }
}