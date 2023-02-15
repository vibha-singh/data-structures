package main.practice.linkedlist;

public class ReverseLL {
    public static void main(String[] args) {
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       head.next.next.next.next = new Node(5);
       Node newHead = reverseLL(head);
       while (newHead != null ) {
           System.out.print(newHead.data+" ");
           newHead = newHead.next;
       }
    }

    public static Node reverseLL(Node head) {
        Node prev = null, curr = head;
        while(curr != null ) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static class Node {
        int data;
        Node next;

        public Node(int val) {
            this.data = val;
        }
    }
}
