package main.t2025.linkedlist;

public class C_CycleLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(2);
        ll.next.next = new LinkedList(3);
        ll.next.next.next = new LinkedList(4);
        ll.next.next.next.next = ll.next;

        System.out.println(llHasCycle(ll));
        System.out.println(llCyclePoint(ll).value);
        breakCycle(ll);
    }

    private static boolean llHasCycle(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }

    private static LinkedList llCyclePoint(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    private static void breakCycle(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            slow = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            LinkedList curr = fast;

            while(curr.next != slow ){
                curr = curr.next;
            }
            curr.next = null;
            System.out.println();
            while (head != null) {
                System.out.println(head.value);
                head = head.next;
            }
        }



    }
}
