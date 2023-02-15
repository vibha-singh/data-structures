package main.practice.dp.jumpGame;

/**
 * Given an array of nums which indicate max number of jumps from any index. Return true if you can reach last index;
 */
public class JumpGameI {
    public static void main(String[] args) {
        int[] arr = {2,5,1,1,4};
        int[] arr1 = {3,2,1,0,4};
        System.out.println(jumpGame(arr, arr.length));
        System.out.println(jumpGame(arr1, arr1.length));
    }

    private static boolean jumpGame(int[] nums, int n) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
