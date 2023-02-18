package main.practice.dp;

/**
 * Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
 * Input:
 * N = 16
 * A[]={0,8,4,12,2,10,6,14,1,9,5
 *      13,3,11,7,15}
 * Output: 6
 * Explanation:Longest increasing subsequence
 * 0 2 6 9 13 15, which has length 6
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] arr = {0,8,4,12,2,10,6,14,1,9,5,
                     13,3,11,7,15};
        int n = arr.length;
        int [] dp = new int[n];
        int len = 1;
        for(int i = 1; i<n ; i++) {
            if(arr[i] > dp[len-1]) {
                dp[len] =  arr[i];
                len++;
            }
            else {
                int c = ceilIndex(dp, 0, len-1, arr[i]);
                dp[c] = arr[i];
            }
        }
        System.out.println(len);
    }

    static int ceilIndex (int dp[], int l, int r, int x) {
        while (l < r) {
            int m = l + (r-l) /2;
            if(dp[m] >= x)
                r = m;
            else
                l = m+1;
        }
        return r;
    }
}
