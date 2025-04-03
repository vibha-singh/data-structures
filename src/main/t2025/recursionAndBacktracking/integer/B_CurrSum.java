package main.t2025.recursionAndBacktracking.integer;

import java.util.ArrayList;
import java.util.List;

public class B_CurrSum {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(ans, 0, nums, target, new ArrayList<>());
        System.out.println(ans);
    }

    private static void combinationSum(List<List<Integer>> ans, int ci, int[] nums, int target, ArrayList<Integer> curr) {
        if(nums.length == ci) return;
        if( target == 0) {
            ans.add(curr);
            return;
        }
        int currVal = nums[ci];
        if(target >= currVal) {
            curr.add(currVal);
            combinationSum(ans, ci, nums, target-currVal, new ArrayList<>(curr));
        }
        curr.remove(curr.size()-1);
        combinationSum(ans, ci+1, nums, target, curr);
    }
}
