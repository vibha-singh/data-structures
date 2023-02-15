package main.practice.linkedlist;

/**
 * Normal two linked list sum is done in three steps:
 * 1) reverse both the lists
 * 2) Add them
 * 3) Reverse the output
 */
public class AddTwoSumActual {
    public static void main(String[] args) {
        ReverseLL.Node head1 = new ReverseLL.Node(1);
        head1.next = new ReverseLL.Node(2);
        head1.next.next = new ReverseLL.Node(3);
        head1.next.next.next = new ReverseLL.Node(4);
        head1.next.next.next.next = new ReverseLL.Node(5);

        ReverseLL.Node head2 = new ReverseLL.Node(6);
        head2.next = new ReverseLL.Node(7);
        head2.next.next = new ReverseLL.Node(8);
        head2.next.next.next = new ReverseLL.Node(9);
        head2.next.next.next.next = new ReverseLL.Node(10);

        ReverseLL.Node mergedLL = addTwoNum(head1, head2);
        while(mergedLL !=null) {
            System.out.print( mergedLL.data+" ");
            mergedLL = mergedLL.next;
        }
    }

    private static ReverseLL.Node addTwoNum(ReverseLL.Node head1, ReverseLL.Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        //1) Reverse both the list
        head1 = ReverseLL.reverseLL(head1);
        head2 = ReverseLL.reverseLL(head2);

        //2) Add the list
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
        // reverse the result
        return ReverseLL.reverseLL(head.next);
    }
}
