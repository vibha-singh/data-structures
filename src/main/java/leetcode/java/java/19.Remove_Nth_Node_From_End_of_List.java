package leetcode.java;

/**
 * 19. Remove Nth Node From End of List
 * Medium
 *
 * 10696
 *
 * 502
 *
 * Add to List
 *
 * Share
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * **/


// * Definition for singly-linked list.
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        for(int i = 1; i<=n+1; i++){
            if(fast != null)
                fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow != null){
            slow.next = slow.next.next;
        }

        return dummyHead.next;

    }
}