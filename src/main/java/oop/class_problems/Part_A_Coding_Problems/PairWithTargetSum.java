import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {

    // Approach 1: Brute Force
    // Time: O(n²)
    // Space: O(1)
    public static boolean hasPairBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // Approach 2: HashSet
    // Time: O(n) average
    // Space: O(n)
    public static boolean hasPairWithSum(int[] nums, int target) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {

            int complement = target - num;

            if (seen.contains(complement)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 4, 6};
        int target2 = 20;

        System.out.println(hasPairWithSum(nums1, target1));
        System.out.println(hasPairWithSum(nums2, target2));

        System.out.println("Brute Force: "
                + hasPairBruteForce(nums1, target1));
    }
}