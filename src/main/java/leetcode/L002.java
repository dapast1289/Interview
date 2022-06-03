package leetcode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode answer = new ListNode(7, new ListNode(0, new ListNode(8)));
        L002 l002 = new L002();
        ListNode result = l002.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (true) {

            // handle result
            if (current == null) {
                current = new ListNode(0);
            }
            // add number and carry that is current result value
            int sum = getNodeVal(l1) + getNodeVal(l2) + getNodeVal(current);
            // handle next carry
            if (sum >= 10) {
                current.val = sum - 10;
                current.next = new ListNode(1);
            } else {
                current.val = sum;
            }
//            System.out.println(current.val);
            if (l1.next != null || l2.next != null) {
                if (current.next == null) {
                    current.next = new ListNode(0);
                }
                current = current.next;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                break;
            }
        }
        return result;
    }

    public int getNodeVal(ListNode listNode) {
        if (listNode == null) {
            return 0;
        } else {
            return listNode.val;
        }
    }
}