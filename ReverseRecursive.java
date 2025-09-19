public class ReverseRecursive {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { this.val = v; }
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static ListNode fromArray(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : arr) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        for (ListNode p = head; p != null; p = p.next) {
            sb.append(p.val);
            if (p.next != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode head = fromArray(new int[]{1,2,3,4,5});
        System.out.println("Before: " + toString(head));
        ListNode rev = reverse(head);
        System.out.println("After:  " + toString(rev));
    }
}
