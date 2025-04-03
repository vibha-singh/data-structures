package main.t2025.linkedlist;

public class A_ReverseLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(2);
        ll.next.next = new LinkedList(3);
        ll.next.next.next = new LinkedList(4);

        LinkedList curr = ll;
        LinkedList prev = null;
        LinkedList temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while (prev !=null ){
            System.out.println(prev.value);
            prev = prev.next;
        }
    }
}

