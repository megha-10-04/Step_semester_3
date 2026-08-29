import java.util.Scanner;

public class M2TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = (matchedCharacters * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, original.length(), accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position "
                    + firstMismatchPosition
                    + " ('" + original.charAt(firstMismatchPosition - 1)
                    + "' vs '" + typed.charAt(firstMismatchPosition - 1) + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must have equal length.");
        } else if (original.length() == 0) {
            System.out.println("Error: Text cannot be empty.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        scanner.close();
    }
}