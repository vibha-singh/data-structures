package main.t2025.linkedlist;

public class D_AddTwoLL {
    public static void main(String[] args) {
        LinkedList head1 = new LinkedList(7);
        head1.next = new LinkedList(2);
        head1.next.next = new LinkedList(4);
        head1.next.next.next = new LinkedList(3);

        LinkedList head2 = new LinkedList(5);
        head2.next = new LinkedList(6);
        head2.next.next = new LinkedList(4);

        LinkedList reversedHead1 = reverse(head1);
       // print(reversedHead1);

        System.out.println();

        LinkedList reversedHead2 = reverse(head2);
        //print(reversedHead2);

        System.out.println("=============== ANS =================");
        LinkedList ans = sum(reversedHead1, reversedHead2);
        print(ans);


    }

    public static LinkedList sum(LinkedList a, LinkedList b) {
        int carry = 0;
        LinkedList head = new LinkedList(-1);
        LinkedList dummy = head;
        while(a != null || b != null) {
            int v1 = a != null ? a.value : 0;
            int v2 = b != null ? b.value : 0;
            int sum = v1 + v2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            LinkedList newNode = new LinkedList(sum);
            dummy.next = newNode;
            dummy = dummy.next;

            a = a != null ? a.next : a;
            b = b != null ? b.next : b;
        }
        if(carry > 0) {
            dummy.next =  new LinkedList(carry);
        }
        return reverse(head.next);
    }

    public static LinkedList reverse (LinkedList head) {
        LinkedList curr = head;
        LinkedList prev = null;
        LinkedList temp;

        while (curr!= null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static void print(LinkedList head) {
        while (head != null) {
            System.out.print(head.value + "-> ");
            head = head.next;
        }
    }
}
