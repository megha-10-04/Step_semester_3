package oop.assigment_problems;

interface Ringable {
    String ring();
}

class AlarmClock implements Ringable {
    private String time;

    AlarmClock(String time) {
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Time cannot be blank");
        }
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class Doorbell implements Ringable {
    private String location;

    Doorbell(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be blank");
        }
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class M1 {

    public static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {

        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");

        System.out.println(a.ring());
        System.out.println(d.ring());

        ringAll(new Ringable[]{a, d});
    }
}