import java.util.Scanner;

public class M1ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int numberOfSeats = scanner.nextInt();

        int[] seatNumbers = new int[numberOfSeats];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < numberOfSeats; i++) {
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);

        scanner.close();
    }
}
