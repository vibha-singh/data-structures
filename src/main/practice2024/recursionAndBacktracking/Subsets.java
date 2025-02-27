package main.practice2024.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        HashSet<HashSet<Integer>> result = new HashSet<>();
        List<Integer> arr = Arrays.asList(1,2,2,3);
        generateAllSubsets(arr, 0,new HashSet<>(), result);
        System.out.println(result);

        String str = "abc";
        List<String> ans = new ArrayList<>();
        generateAllSubsequence(str, 0, "", ans);
        System.out.println(ans);

        List<String> res = new ArrayList<>();
        generateAllSubstring(str, res);
        System.out.println(res);
    }

    private static void generateAllSubsequence(String str, int currIndex, String eachStr, List<String> ans) {
        if(currIndex >= str.length()) {
            ans.add(eachStr);
            return;
        }

        char currValue = str.charAt(currIndex);
        generateAllSubsequence(str, currIndex+1, eachStr, ans);
        eachStr += currValue;
        generateAllSubsequence(str, currIndex+1, eachStr, ans);
    }

    public static void generateAllSubsets (List<Integer> nums, int currIndex,HashSet<Integer> eachSet,  HashSet<HashSet<Integer>> res) {
        if(currIndex >= nums.size()) {
            res.add(eachSet);
            return;
        }

        int currValue = nums.get(currIndex);
        generateAllSubsets(nums, currIndex+1, new HashSet<>(eachSet), res);
        eachSet.add(currValue);
        generateAllSubsets(nums, currIndex+1, new HashSet<>(eachSet), res);
    }

    private static void generateAllSubstring ( String str, List<String> res) {
        for(int i = 0; i< str.length() ; i++) {
            StringBuilder ans = new StringBuilder();
            for (int j = i; j<str.length() ; j++) {
                ans.append(str.charAt(j));
                res.add(ans.toString());
            }
        }
    }


}
