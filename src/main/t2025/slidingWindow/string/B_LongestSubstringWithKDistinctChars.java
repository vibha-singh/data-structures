package main.t2025.slidingWindow.string;

import java.util.HashMap;
import java.util.Map;

public class B_LongestSubstringWithKDistinctChars {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int result = longestSubstringWithKDistinctChars(s, k);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + result);

        String s1 = "eceba";
        int k1 = 2;
        int result1 = longestSubstringWithKDistinctChars(s1, k1);
        System.out.println("Length of the longest substring with at most " + k1 + " distinct characters: " + result1);
    }

    public static int longestSubstringWithKDistinctChars (String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        int maxLength = 0;
        int len = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right< len ; right++){
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0) +1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);

                if(map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }

            maxLength = Math.max(maxLength, right-left +1);
        }
        return maxLength;
    }
}
