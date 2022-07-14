package leetcodeold;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L328 {

    private static Stream<Arguments> case1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4)))));
        return Stream.of(Arguments.of(head, expected));
    }

    @ParameterizedTest
    @MethodSource("case1")
    public void oddEvenList(ListNode head, ListNode expected) {
        ListNode dummy = new ListNode(0, head);

//        ListNode oddHead = head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;

        while (odd.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
        }
        while (even.next != null) {
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        even.next = null;
//        return dummy.next;
        ListNode actual = dummy.next;
        while (expected != null || actual != null) {
//            assertEquals(expected.val, actual.val);
            System.out.println(expected.val + " _ " + actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
