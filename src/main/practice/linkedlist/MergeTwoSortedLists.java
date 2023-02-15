package main.practice.linkedlist;

public class MergeTwoSortedLists {
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

        ReverseLL.Node mergedLL = mergerSortedList(head1, head2);
        while(mergedLL !=null) {
            System.out.print( mergedLL.data+" ");
            mergedLL = mergedLL.next;
        }
    }

    private static ReverseLL.Node mergerSortedList(ReverseLL.Node head1, ReverseLL.Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ReverseLL.Node dummy = new ReverseLL.Node(-1);
        ReverseLL.Node head = dummy;

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                ReverseLL.Node newNode = new ReverseLL.Node(head1.data);
                dummy.next = newNode;
                head1 = head1.next;
            } else {
                ReverseLL.Node newNode = new ReverseLL.Node(head2.data);
                dummy.next = newNode;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }

         dummy.next = head1 != null ? head1 : head2;
         return head.next;
    }


}
