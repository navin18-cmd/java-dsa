/*
Problem: 3Sum
Category: Two Pointers / Array
Platform: LeetCode

Goal:
Find all unique triplets [nums[i], nums[j], nums[k]] such that
nums[i] + nums[j] + nums[k] = 0.

Approach:
1. Sort the array.
2. Fix one number (i).
3. Use two pointers (left and right) to find the remaining two numbers.
4. Skip duplicates to avoid repeating triplets.

Time Complexity: O(n²)
Space Complexity: O(1) extra (excluding output)
*/

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
