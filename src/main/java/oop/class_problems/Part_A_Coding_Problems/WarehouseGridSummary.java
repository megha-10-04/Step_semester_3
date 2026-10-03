public class WarehouseGridSummary {

    public static String warehouseSummary(int[][] grid) {

        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                totalItems += grid[row][col];

                if (grid[row][col] > maxItems) {
                    maxItems = grid[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
    }

    public static void main(String[] args) {

        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid));
    }
}