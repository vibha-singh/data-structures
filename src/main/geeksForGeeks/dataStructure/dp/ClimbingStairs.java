package main.geeksForGeeks.dataStructure.dp;

/**
 *   Complexity Analysis :
 *
 * Time Complexity: O(N)
 * Auxiliary Space: O(1)
 *
 * Optimized approach of Bottom Up i.e Tabular solution
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("No of ways: "+climbingStairs(n));

        int[] arr = {10,15,20};
        System.out.println("No of ways: "+minCost(arr));
    }

    private static int climbingStairs(int n) {
        int prev = 1;
        int prev1 = 1;
        for (int i = 2; i<=n; i++){
            int curr = prev +prev1;
            prev1 = prev;
            prev = curr;
        }

        return prev;
    }


    private static int minCost(int[] arr){
        int dp1 = 0, dp2 = 0;
        for(int i = 0; i<arr.length; i++) {
            int dp0 = arr[i] + Math.min(dp1, dp2);
            dp2 = dp1;
            dp1 = dp0;
        }
        return Math.min(dp1, dp2);
    }
}
