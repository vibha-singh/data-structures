package main.t2025.kandaneAlgo;

public class D_MaxSubArrayWithOnlyPositiveValues {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayWithOnlyPositiveValues(arr));
    }

    public static int maxSubArrayWithOnlyPositiveValues(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int currSum = arr[0];
        int maxSum = arr[0];
        for(int i = 1 ; i< arr.length ; i++) {
            if(arr[i] < 0)
                currSum = 0;
            else {
                currSum += arr[i];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }
}
