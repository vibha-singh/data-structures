package main.t2025.kandaneAlgo;

/**
 * Traverse the array while keeping track of two subarrays:
 * One where the subarray starts with a positive number.
 * Another where the subarray starts with a negative number.
 * At each step, ensure the alternation condition is satisfied.
 * If the alternation condition is violated, reset the current subarray sum.
 * Track the maximum sum encountered.
 */
public class E_MaxSubArraySumWithAltNegAndPosNum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -1, 7, 0};
        int result = maxSubArraySumWithAltNegAndPosNum(arr);
        System.out.println("Maximum Alternating Subarray Sum: " + result); // Output: 4
    }

    public static int maxSubArraySumWithAltNegAndPosNum(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int currSumPositive = arr[0];
        int currSumNegative = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length ; i++) {
             if(arr[i] > 0) {
                 currSumPositive = Math.max(arr[i] , currSumNegative + arr[i]);
                 currSumNegative = arr[i];
             } else if(arr[i] < 0) {
                currSumNegative = Math.max(arr[i], currSumPositive + arr[i]);
                currSumPositive = arr[i];
             } else {
                currSumPositive = 0;
                currSumNegative = 0;
             }
             maxSum = Math.max(maxSum, Math.max(currSumNegative, currSumPositive));
        }
        return maxSum;
    }
}
