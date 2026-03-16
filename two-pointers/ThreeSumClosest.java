/*
Problem: 3Sum Closest
Category: Two Pointers / Array
Platform: LeetCode

Goal:
Find three integers in the array whose sum is closest to the target.

Approach:
1. Sort the array.
2. Fix one element (i).
3. Use two pointers (left and right) to find the closest sum.
4. Update the closest sum whenever we find a smaller difference.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

import java.util.*;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
