public class M1_ClassTopperFinder {

    public static String findTopper(int[][] marks) {

        int bestRow = 0;
        int bestTotal = -1;

        for (int row = 0; row < marks.length; row++) {

            int total = 0;

            for (int col = 0; col < marks[row].length; col++) {
                total += marks[row][col];
            }

            // Strictly greater preserves the smaller row index during ties
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }

        return "(" + bestRow + ", " + bestTotal + ")";
    }

    public static void main(String[] args) {

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        System.out.println(findTopper(marks));
    }
}