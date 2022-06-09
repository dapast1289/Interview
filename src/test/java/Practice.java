import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice {

    @Test
    public void whenPush_addsAtFirst() {
        ArrayDeque<String> stack = new ArrayDeque<>();
//        stack.push("1");
//        stack.push("2");
        stack.offer("3");
        stack.offer("4");
        stack.offer("5");
        stack.add("6");

        assertEquals("second", stack.poll());
        System.out.println();
    }
}
