import java.util.HashMap;
import java.util.Map;

public class M3_MostPopularCanteenOrder {

    public static String mostPopular(String[] orders) {

        Map<String, Integer> counts = new HashMap<>();

        // Count each item
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        String popularItem = orders[0];
        int highestCount = counts.get(popularItem);

        // Scan in original order to handle ties
        for (String order : orders) {

            int count = counts.get(order);

            if (count > highestCount) {
                highestCount = count;
                popularItem = order;
            }
        }

        return "(\"" + popularItem + "\", " + highestCount + ")";
    }

    public static void main(String[] args) {

        String[] orders1 = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] orders2 = {
            "tea", "coffee", "coffee", "tea"
        };

        System.out.println("Sample 1: " + mostPopular(orders1));
        System.out.println("Sample 2: " + mostPopular(orders2));
    }
}
