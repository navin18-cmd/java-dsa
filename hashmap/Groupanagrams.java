/*
Problem: Group Anagrams
Category: HashMap / Sorting
Approach:
Sort each string to create a unique key.
All anagrams will share the same sorted key.
Store grouped strings using a HashMap.

Time Complexity: O(n * k log k)
- n = number of strings
- k = maximum length of a string
- Sorting each string costs O(k log k)

Space Complexity: O(n * k)
- To store grouped anagrams.
*/

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {

            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}
