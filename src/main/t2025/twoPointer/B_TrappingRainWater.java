package main.t2025.twoPointer;

import java.util.Stack;

public class B_TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(maxWater(arr));

    }


    private static int maxWater(int[] height) {

        int left = 0;
        int right = height.length -1;

        int rMax = height[right ];
        int lMax = height[left];
        int res = 0;
        while(left < right) {
            if(lMax < rMax) {
                left++;
                lMax = Math.max(lMax, height[left]);
                res += lMax - height[left];
            } else {
                right--;
                rMax = Math.max(rMax, height[right]);
                res += rMax - height[right];
            }
        }
        return res;
    }
}
