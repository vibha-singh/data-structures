package main.t2025.slidingWindow.string;

import java.util.HashMap;
import java.util.Map;

public class D_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + longestSubstringWithoutRepeatingCharacters(s)); // Output: 3
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s){
        int maxLength = 0;
        int maxStart = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right<s.length(); right++) {
            char currChar = s.charAt(right);

            if(map.containsKey(currChar) && map.get(currChar) >= left) {
                left = map.get(currChar)+1;
            }

            map.put(currChar, right);
            int currLength = right -left +1;
            if(currLength > maxLength){
               maxLength = currLength;
               maxStart = left;
            }
        }
        System.out.println(s.substring(maxStart, maxLength+maxStart));
        return  maxLength;
    }
}
