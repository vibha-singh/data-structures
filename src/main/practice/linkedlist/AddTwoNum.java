package main.practice.linkedlist;

/**
 * Given two list in reverse order add and return the result
 */
public class AddTwoNum {
    public static void main(String[] args) {
        ReverseLL.Node head1 = new ReverseLL.Node(1);
        head1.next = new ReverseLL.Node(2);
        head1.next.next = new ReverseLL.Node(3);
        head1.next.next.next = new ReverseLL.Node(4);
        head1.next.next.next.next = new ReverseLL.Node(5);
        //Step 1 reversing the 1st list
        head1 = reverseLL(head1);

        ReverseLL.Node head2 = new ReverseLL.Node(6);
        head2.next = new ReverseLL.Node(7);
        head2.next.next = new ReverseLL.Node(8);
        head2.next.next.next = new ReverseLL.Node(9);
        head2.next.next.next.next = new ReverseLL.Node(8);

        //Step 1 reversing the 2nd list
        head2 = reverseLL(head2);

        // Step 2 add two num
        ReverseLL.Node mergedLL = addTwoNum(head1, head2);

        //Step 3 reverse the final list
        mergedLL = reverseLL(mergedLL);
        while(mergedLL !=null) {
            System.out.print( mergedLL.data+" ");
            mergedLL = mergedLL.next;
        }
    }

    private static ReverseLL.Node addTwoNum(ReverseLL.Node head1, ReverseLL.Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ReverseLL.Node dummy = new ReverseLL.Node(-1);
        ReverseLL.Node head = dummy;
        int carry  = 0;
        while (head1 != null || head2 != null) {
            int first = head1 != null ? head1.data : 0;
            int second = head2 != null ? head2.data : 0 ;

            int val = first + second + carry;
            carry = val/10;
            val = val % 10;
            dummy.next = new ReverseLL.Node(val);

            dummy = dummy.next;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null ;
        }

        if(carry > 0) {
            dummy.next = new ReverseLL.Node(carry);
        }
        return head.next;
    }

    private static ReverseLL.Node reverseLL(ReverseLL.Node head) {
        ReverseLL.Node prev = null, curr = head;
        while(curr != null ) {
            ReverseLL.Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
