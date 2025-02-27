package main.t2025.slidingWindow.string;

import java.util.HashMap;
import java.util.Map;

public class A_CountAnagrams {
    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String pattern = "for";
        System.out.println(countAnagrams(s, pattern)); // Output: 3
    }

    private static int countAnagrams(String s, String pattern) {
        int k = pattern.length();
        Map<Character, Integer> patternMap = new HashMap<>();
        for(Character c: pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        for ( int i = 0; i<k; i++) {
            Character c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0)+1);
        }

        int count = 0;
        if(windowMap.equals(patternMap)) count++;

        for(int i = k ; i<s.length(); i++) {
            Character c = s.charAt(i);
            windowMap.put(s.charAt(i-k), windowMap.get(s.charAt(i-k))-1);
            if(windowMap.get(s.charAt(i-k)) == 0) windowMap.remove(s.charAt(i-k));

            windowMap.put(c, windowMap.getOrDefault(c,0) + 1);
            if(windowMap.equals(patternMap)) count++;
        }

        return count;
    }
}
