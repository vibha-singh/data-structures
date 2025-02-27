package main.practice2024.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;


public class CombinationSum {
    public static void main(String[] args) {
        int targetSum = 8;
        int[] arr = {2,3,5};
        System.out.println(combinationSumOne(arr, targetSum));
    }

    private static HashSet<ArrayList<Integer>> combinationSumOne(int[] arr, int targetSum) {
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), arr, targetSum, 0);
        return result;
    }

    private static void backtrack(HashSet<ArrayList<Integer>> result, ArrayList<Integer> eachList, int[] num , int currSum, int start) {
        if(currSum < 0) return;
        if(currSum == 0) {
            result.add(new ArrayList<>(eachList));
            return;
        }

        for(int i = start; i< num.length; i++) {
            eachList.add(num[i]);
            backtrack(result, eachList, num, currSum-num[i], i);
            eachList.remove(eachList.size()-1);
        }
    }
}
