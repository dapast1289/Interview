package leetcode;

public class L206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        L206 l206 = new L206();
        ListNode ans = l206.reverseList(head);
//        l206.reverseRecursively(null, head);
        System.out.println();
    }
//    public ListNode reverseList(ListNode head) {
//        return reverseIteratively(head);
//    }

    public ListNode reverseIteratively(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseRecursively(ListNode pre, ListNode cur) {
        if (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            reverseRecursively(pre, cur);

        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
