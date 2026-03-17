/*
Problem: Longest Substring Without Repeating Characters
Category: Sliding Window / HashSet
Platform: LeetCode

Goal:
Find the length of the longest substring without repeating characters.

Approach:
1. Use a sliding window with two pointers (start and end).
2. Use a HashSet to store characters in the current window.
3. Expand the window by moving 'end'.
4. If duplicate found, shrink window from 'start' until duplicate is removed.
5. Track the maximum window size.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        int maxLen = 0;

        Set<Character> seen = new HashSet<>();

        while (end < s.length()) {

            char c = s.charAt(end);

            while (seen.contains(c)) {
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(c);

            int windowSize = end - start + 1;
            maxLen = Math.max(maxLen, windowSize);

            end++;
        }

        return maxLen;
    }
}
