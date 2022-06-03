package leetcode;

public class L148 {
    public ListNode sortList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = slow; // when running out of while, p = l1's tail and p.next = null means head could be independent l1
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        merge(l1, l2);
        return head;
    }

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode result = new ListNode();
        ListNode pivot = result;
        ListNode l1 = listNode1;
        ListNode l2 = listNode2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pivot.next = l1;
                l1 = l1.next;
            } else {
                pivot.next = l2;
                l2 = l2.next;
            }
            pivot = pivot.next;
        }
        if (l1 != null) {
            pivot.next = l1;
        }
        if (l2 != null) {
            pivot.next = l2;
        }
        return result.next;
    }
}
