package main.t2025.slidingWindow.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given a string and an integer k, find the length of the longest
 * substring with the same character after at most k replacements.
 * o Example:
 * ▪ Input: s = "AABABBA", k = 1
 * ▪ Output: 4 (substring "AABA")
 */
public class C_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println("The length of the longest substring with same character after at most " +
                k + " replacements is: " + result);
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;

        int left = 0;
        int maxLength = 0;
        int maxStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        int currK = 0;
        for(int right = 0; right < s.length() ; right++) {
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);

            // to update currk already replaced
            currK = Math.max(currK, map.get(currChar));

            if(right - left + 1 - currK > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            int currLength = right-left+1;
            if(currLength >  maxLength) {
                maxLength = currLength;
                maxStart = left;
            }

        }
        System.out.println(s.substring(maxStart, maxLength+maxStart));
        return maxLength;
    }
}
