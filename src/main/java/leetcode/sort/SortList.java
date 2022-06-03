package leetcode.sort;

public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        sortList.sortList(head);
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        buildHeap(head, length);
        for(int i = length - 1; i > 0; i--) {
            swap(head, 0, i);
            heapify(head, i, 0);
        }
        return head;
    }

    public void buildHeap(ListNode head, int length) {
        int lastNode = length - 1;
        int lastParent = (lastNode - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(head, length, i);
        }

    }

    public void heapify(ListNode head, int length, int i) {
        if (i >= length) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < length && getNode(head, c1).val > getNode(head, max).val) {
            max = c1;
        }
        if (c2 < length && getNode(head, c2).val > getNode(head, max).val) {
            max = c2;
        }
        if (max != i) {
            swap(head, max, i);
            heapify(head, length, max);
        }
    }

    public void swap(ListNode head, int i, int j) {
        ListNode nodeI = getNode(head, i);
        ListNode nodeJ = getNode(head, j);
        int temp = nodeI.val;
        nodeI.val = nodeJ.val;
        nodeJ.val = temp;

    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public ListNode getNode(ListNode head, int i) {
        ListNode cur = head;
        for (;i > 0; i--) {
            cur = cur.next;
        }
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
