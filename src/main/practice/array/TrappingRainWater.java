package main.practice.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {7,4,0,9};
        System.out.println(trappingRainWater(arr, arr.length));
    }

    private static int trappingRainWater(int[] arr, int n) {
        int res = 0;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = arr[0];
        for(int i = 1; i<n; i++)
            lMax[i] = Math.max(lMax[i-1], arr[i]);
        rMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--)
            rMax[i] = Math.max(rMax[i+1], arr[i]);

        for(int i = 1; i < n; i++)
            res += (Math.min(lMax[i], rMax[i]) - arr[i]);
        return res;
    }
}
