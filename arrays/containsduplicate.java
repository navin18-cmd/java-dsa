/*
Problem: Contains Duplicate
Category: Array / HashSet
Approach:
Use a HashSet to track elements we have already seen.
If an element appears again, return true immediately.

Time Complexity: O(n)
- Single pass through the array.
- HashSet operations are O(1) average.

Space Complexity: O(n)
- In worst case, all elements are stored in the set.
*/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}
