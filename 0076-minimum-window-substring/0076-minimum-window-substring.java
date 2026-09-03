import java.util.HashMap;

public class Solution {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Array to store the required frequencies of characters in t
        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) {
            targetCounts[c]++;
        }

        // Array to store the character counts in the current sliding window
        int[] windowCounts = new int[128];

        // Track how many unique characters have met their target frequency requirement
        int required = 0;
        for (int count : targetCounts) {
            if (count > 0) required++;
        }

        int formed = 0;
        int left = 0;
        
        // Track the best window dimensions: [length, start_index]
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCounts[rightChar]++;

            // If the character matches the required frequency in t, increment formed
            if (targetCounts[rightChar] > 0 && windowCounts[rightChar] == targetCounts[rightChar]) {
                formed++;
            }

            // Shrink the window from the left while it remains valid
            while (left <= right && formed == required) {
                // Update the minimum window if a smaller one is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCounts[leftChar]--;

                // If removing this character breaks the target requirement, decrement formed
                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
