package main.practice.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.HashSet;

/***
 * Combinational Sum with Repetitive numbers
 */
public class CombinationSum {

    public static void main(String[] args) {
        int target = 8;
        int[] nums = {2,2,3,5};
        System.out.println(combinationSum(nums, target));
    }

    public static HashSet<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(HashSet<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] candidates, int remainTarget, int start) {
        if (remainTarget < 0) return;
        if (remainTarget == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, remainTarget - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
