package main.practice.recursion_and_backtracking;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * TC : 2^n
 * SC: 2^n
 */

public class Subsets {
    public static void main(String[] args) {
        // HashSets for no duplicates
        HashSet<HashSet<Integer>> result = new HashSet<>();
        HashSet<Integer> eachSet = new HashSet<>();
        List<Integer> nums = Arrays.asList(1,2,2,3);
        generateAllSubsets(nums, 0, eachSet, result);
        System.out.println(result);
        ArrayList<String> substring = new ArrayList<>();
        generateAllSubstring("abc",0,"",substring);
        System.out.println(substring);

        generateAllSubstring("abc");
    }

    /**
     * Recursive solution TC & SC: 2^n
     * @param nums
     * @param currIndex
     * @param eachSet
     * @param result
     */
    private static void generateAllSubsets(List<Integer> nums, int currIndex, HashSet<Integer> eachSet, HashSet<HashSet<Integer>> result) {
        if(currIndex >=nums.size()){
            result.add(eachSet);
            return;
        }
        int currentValue = nums.get(currIndex);
        generateAllSubsets(nums, currIndex+1, new HashSet<>(eachSet), result);
        eachSet.add(currentValue);
        generateAllSubsets(nums, currIndex+1, new HashSet<>(eachSet), result);
    }

    /**
     * Recursive solution TC & SC: 2^n
     * @param str
     * @param currIndex
     * @param eachSet
     * @param result
     */
    private static void generateAllSubstring(String str, int currIndex, String eachSet, ArrayList<String> result) {
        if(currIndex >=str.length()){
            result.add(eachSet);
            return;
        }
        char currentValue = str.charAt(currIndex);
        generateAllSubstring(str, currIndex+1, eachSet, result);
        eachSet += currentValue;
        generateAllSubstring(str, currIndex+1, eachSet, result);
    }

    /**
     * Iterative
     * @param str
     */
    private static void generateAllSubstring(String str) {
        for(int i = 0; i<str.length(); i++) {
            StringBuilder s  = new StringBuilder(String.valueOf(str.charAt(i)));
            System.out.print(s+",");
            for(int j=i+1; j<str.length();j++) {
                s.append(str.charAt(j));
                System.out.print(s+",");
            }
        }
    }


}
