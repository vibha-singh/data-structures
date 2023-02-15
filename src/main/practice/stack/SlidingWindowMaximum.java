package main.practice.stack;

import java.util.*;

/**
 * nums = {1,2,-1,-3,5,3,6,7} , k= 3, res = {3,3,5,5,6,7}
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int nums[] =  {1,3,-1,-3,5,3,6,7};
        ArrayList<Integer> ans =  new ArrayList<>();
        int k = 3;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++) {
            if(!deque.isEmpty() && deque.getFirst() == i-k) deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i])
                deque.removeLast();

            deque.addLast(i);
            if(i>= k-i)
                ans.add(nums[deque.getFirst()]);

        }
        System.out.println(ans);
    }
}

