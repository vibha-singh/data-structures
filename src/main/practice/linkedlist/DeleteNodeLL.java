package main.practice.linkedlist;

public class DeleteNodeLL {
    public static void main(String[] args) {
        ReverseLL.Node head = new ReverseLL.Node(1);
        head.next = new ReverseLL.Node(2);
        head.next.next = new ReverseLL.Node(3);
        head.next.next.next = new ReverseLL.Node(4);
        head.next.next.next.next = new ReverseLL.Node(5);
        System.out.println(deleteNode(head.next.next));
        while(head != null ){
            System.out.println(head.data+" ");
            head = head.next;
        }
    }

    private static boolean deleteNode(ReverseLL.Node node) {
        int val = node.next.data;
        node.next = node.next.next;
        node.data = val;
        return true;
    }
}
