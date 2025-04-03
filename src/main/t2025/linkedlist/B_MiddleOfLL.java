package main.t2025.linkedlist;

public class B_MiddleOfLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(2);
        ll.next.next = new LinkedList(3);
        ll.next.next.next = new LinkedList(4);
        ll.next.next.next.next = new LinkedList(5);

        LinkedList fast = ll;
        LinkedList slow = ll;
        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.value);
    }
}
