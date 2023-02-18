package main.practice.dp;

/**
 * Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.
 * Input: N = 5, arr[] = {1, 101, 2, 3, 100}
 * Output: 106
 * Explanation:The maximum sum of a
 * increasing sequence is obtained from
 * {1, 2, 3, 100}
 */
public class MaximumSumIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr, arr.length));
    }

    public static int maxSumIS(int arr[], int n) {
        int[] dp = new int[arr.length];
        int oMax = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j] && sum < dp[j]) {
                    sum = dp[j];
                }
            }
            dp[i] = sum + arr[i];
            oMax = Math.max(oMax, dp[i]);
        }
        return oMax;
    }

}
