/*
Problem: Top K Frequent Elements
Category: HashMap / Bucket Sort
Platform: LeetCode

Approach:
1. Count frequency of each element using HashMap.
2. Create buckets where index represents frequency.
3. Store numbers inside corresponding frequency buckets.
4. Traverse buckets from highest frequency to lowest.
5. Collect first k elements.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Build frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (index = frequency)
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            buckets[frequency].add(number);
        }

        // Step 4: Collect top k elements
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
