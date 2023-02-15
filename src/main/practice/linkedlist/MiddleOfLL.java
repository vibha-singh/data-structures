package main.practice.linkedlist;

public class MiddleOfLL {
    public static void main(String[] args) {
        ReverseLL.Node head = new ReverseLL.Node(1);
        head.next = new ReverseLL.Node(2);
        head.next.next = new ReverseLL.Node(3);
        head.next.next.next = new ReverseLL.Node(4);
        head.next.next.next.next = new ReverseLL.Node(5);
        System.out.println(middleOfLL(head));
    }

    private static int middleOfLL(ReverseLL.Node head) {
        ReverseLL.Node slow = head;
        ReverseLL.Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
