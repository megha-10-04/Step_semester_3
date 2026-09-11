package oop.class_problems;

public class M3 {

    static class CineScreen {

        private int seatsTotal;
        private int seatsAvailable;

        CineScreen(int seatsTotal) {

            if (seatsTotal <= 0) {
                throw new IllegalArgumentException("Invalid seat count");
            }

            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }

        void bookSeat() {

            if (seatsAvailable > 0) {
                seatsAvailable--;
            }
        }

        void cancelBooking() {

            if (seatsAvailable < seatsTotal) {
                seatsAvailable++;
            }
        }

        int getSeatsAvailable() {
            return seatsAvailable;
        }
    }

    public static void main(String[] args) {

        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println(screen.getSeatsAvailable());

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();

        System.out.println(screen.getSeatsAvailable());
    }
}