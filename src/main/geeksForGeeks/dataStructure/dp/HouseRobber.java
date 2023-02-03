package main.geeksForGeeks.dataStructure.dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println("House Robber I: "+houseRobber1(arr));
        System.out.println("House Robber II: "+houseRobber2(arr));

        int[] arr1 = {1,1,3,5,4};
        System.out.println("House Robber I: "+houseRobber1(arr1));
        System.out.println("House Robber II: "+houseRobber2(arr1));
    }

    private static int houseRobber1(int[] arr) {
        if(arr.length == 0) return 0;
        int val1 = arr[0];
        if(arr.length == 1) return val1;

        int val2 = Math.max(arr[0], arr[1]);
        if(arr.length == 2) return val2;

        int res = Integer.MIN_VALUE;
        for(int i = 2; i<arr.length; i++) {
            res = Math.max(val1+arr[i],val2);
            val1 = val2;
            val2 = res;
        }
        return res;
    }

    // Work on first and last house scenario
    private static int houseRobber2(int[] arr) {
        if(arr.length == 0) return 0;
        int val1 = arr[0];
        if(arr.length == 1) return val1;

        int val2 = Math.max(arr[0], arr[1]);
        if(arr.length == 2) return val2;

        int res = Integer.MIN_VALUE;
        int n = arr.length;
        boolean firstConsidered = false;
        for(int i = 2; i<n; i++) {
            if(i == 2 && val1+arr[i] > val2) {
                firstConsidered = true;
            }
            res = Math.max(val1+arr[i],val2);
            val1 = val2;
            val2 = res;
        }
        if(firstConsidered && arr[0] < arr[arr.length-1]){
            res = res - arr[0];
        } else if (firstConsidered && arr[0] > arr[arr.length-1]){
            res = res- arr[arr.length-1];
        }
        return res;
    }
}
