package oop.class_problems;

public class M1 {

    static abstract class Toy {

        private static int toyCount = 1000;
        private final String toyId;

        public Toy() {
            toyCount++;
            toyId = "TOY-" + toyCount;
        }

        public abstract String makeSound();

        public String getToyId() {
            return toyId;
        }
    }

    static class ToyCar extends Toy {

        private String name;

        public ToyCar(String name) {
            super();
            this.name = name;
        }

        @Override
        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    static class ToyRobot extends Toy {

        private String name;

        public ToyRobot(String name) {
            super();
            this.name = name;
        }

        @Override
        public String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {

        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());

        // Toy t = new Toy();
        // This cannot compile because Toy is abstract.
    }
}