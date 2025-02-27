package main.t2025.slidingWindow;

public class C_MaxSumSubArrayWithMinK {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, -4, 5, 6};
//        int k = 3;

//        int[] arr = {};
//        int k = 2;
//        int[] arr = {1, -2, 3, -4, 5};
//        int k = 1;

//        int[] arr = {1, 2, 3, 4, 5};
//        int k = 5;

//        int[] arr = {1, -2, 3, -4, 5};
//        int k = 2;
//        int[] arr = {-1, -2, -3, -4, -5};
//        int k = 2;

        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maxSumSubArrayWithMinK(arr, k)); // Output: 13 (subarray: [5, 6, 2])
    }

    public static int maxSumSubArrayWithMinK (int[] arr, int k){
        if(arr == null || arr.length == 0 || k<=0 || k > arr.length) return 0;

        int currSum = 0;
        for(int i = 0; i<k; i++) {
            currSum += arr[i];
        }
        int maxSum = currSum;
        for(int i = k; i<arr.length ; i++) {
            currSum = Math.max(arr[i] , currSum + arr[i]);
            maxSum = Math.max(currSum , maxSum);
        }
        return maxSum;
    }
}
