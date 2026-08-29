import java.util.Scanner;

public class M5MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {

        String[] words = review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {

            int wordLength = word.length();

            if (wordLength <= 4) {
                shortWords++;
            } else if (wordLength <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords
                + " | Medium: " + mediumWords
                + " | Long: " + longWords);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();

        if (review.trim().isEmpty()) {
            System.out.println("Error: Review cannot be empty.");
        } else {
            classifyWordLengths(review);
        }

        scanner.close();
    }
}