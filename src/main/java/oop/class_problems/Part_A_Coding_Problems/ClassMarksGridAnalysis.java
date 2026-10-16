
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 2);
            String name = parts[0];

            String numbers = parts[1]
                    .replace("[", "")
                    .replace("]", "");

            String[] values = numbers.split(",");
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(values[i].trim());
            }

            names.add(name);
            marksList.add(marks);
        }

        int n = names.size();
        int[][] grid = new int[n][3];
        int[] totals = new int[n];
        int[] subjectTotals = new int[3];

        int topperIndex = 0;

        for (int i = 0; i < n; i++) {
            grid[i] = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += grid[i][j];
                subjectTotals[j] += grid[i][j];
            }

            if (i > 0 && totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }
        }

        System.out.print("Totals ");
        for (int i = 0; i < n; i++) {
            System.out.print(names.get(i) + " " + totals[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();

        System.out.print("averages ");
        for (int j = 0; j < 3; j++) {
            double average = n == 0 ? 0 : (double) subjectTotals[j] / n;
            System.out.printf("%.2f", average);
            if (j < 2) System.out.print(", ");
        }
        System.out.println();

        if (n > 0) {
            System.out.println("topper " + names.get(topperIndex)
                    + " (" + totals[topperIndex] + ")");
        }

        sc.close();
    }
}
