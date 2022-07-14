package leetcodeold;

public class L148 {

    public static void main(String[] args) {
//        [4,2,1,3]
        ListNode arr = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        L148 l148 = new L148();
        arr = l148.sortList(arr);
        while (arr != null) {
            System.out.print(arr.val + ", ");
            arr = arr.next;
        }
        System.out.println("");
        System.out.println("expected: 1, 2, 3, 4");
    }
    public ListNode sortList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = slow; // when running out of while, p = l1's tail and p.next = null means head could be independent l1
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            return head;
        }
        p.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode result = merge(l1, l2);
        return result;
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
