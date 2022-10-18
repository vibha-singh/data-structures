package leetcode.java;

/**
 * 485. Max Consecutive Ones
 * Easy
 *
 * 2798
 *
 * 402
 *
 * Add to List
 *
 * Share
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * **/

class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int currentOne = 0;
        int i = 0;
        while(i<nums.length){
            if(nums[i] == 1){
                currentOne++;
            }else{
                if(currentOne > maxOne){
                    maxOne = currentOne;
                }
                currentOne = 0;
            }
            i++;
        }
        return maxOne> currentOne? maxOne: currentOne;
    }
}