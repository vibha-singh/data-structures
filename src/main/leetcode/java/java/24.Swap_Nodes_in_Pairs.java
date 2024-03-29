package main.leetcode.java.java;

/**
 * 24. Swap Nodes in Pairs
 * Medium
 *
 * 7295
 *
 * 303
 *
 * Add to List
 *
 * Share
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * **/

class Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode low = head;
        ListNode high = head.next;

        while(low != null & low.next != null){
            low.next = low.next.next;
            high.next = low;
            prev.next = high;

            if(low.next == null)
                return dummyNode.next;

            prev = low;
            high = low.next.next;
            low = low.next;
        }

        return dummyNode.next;

    }

}