public class MaximizeAreaBetweenTwoBoundaries {

    // Brute Force Approach
    // Time: O(n²)
    // Space: O(1)
    public static int maxAreaBruteForce(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {

                int width = j - i;
                int height = Math.min(heights[i], heights[j]);

                int area = width * height;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // Two Pointer Approach
    // Time: O(n)
    // Space: O(1)
    public static int maxContainerArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            int area = width * height;

            maxArea = Math.max(maxArea, area);

            // Move the pointer at the shorter boundary
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Brute Force: "
                + maxAreaBruteForce(heights));

        System.out.println("Two Pointer: "
                + maxContainerArea(heights));
    }
}