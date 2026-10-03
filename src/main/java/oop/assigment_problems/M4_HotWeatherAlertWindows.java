public class M4_HotWeatherAlertWindows {

    public static int countAlerts(int[] readings, int k, int threshold) {

        int sum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            sum += readings[i];
        }

        int count = 0;

        // Check the first window
        if (sum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < readings.length; i++) {

            sum += readings[i];
            sum -= readings[i - k];

            if (sum >= k * threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println("Alert windows: "
                + countAlerts(readings, k, threshold));
    }
}