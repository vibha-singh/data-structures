package main.t2025.recursionAndBacktracking.integer;

import java.util.ArrayList;
import java.util.List;

public class A_Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        generateAllSubsetsOfInteger( ans, nums, 0, new ArrayList<>());
        System.out.println(ans);
    }

    private static void generateAllSubsetsOfInteger(List<List<Integer>> ans, int[] nums, int ci, ArrayList<Integer> curr) {
        if(ci == nums.length) {
            ans.add(curr);
            return;
        }

        int currVal = nums[ci];
        generateAllSubsetsOfInteger( ans, nums, ci+1, new ArrayList<>(curr));
        curr.add(currVal);
        generateAllSubsetsOfInteger( ans, nums, ci+1, new ArrayList<>(curr));
    }

}
