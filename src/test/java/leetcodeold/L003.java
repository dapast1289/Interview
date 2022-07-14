package leetcodeold;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L003 {

    private static Stream<Arguments> case1() {
        return Stream.of(
                Arguments.of("abba", 2));
    }

    @ParameterizedTest
    @MethodSource("case1")
    public void lengthOfLongestSubstring(String s, int expected) {
        int[] position = new int[128];
        initPosition(position);

        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (position[c] >= 0) {
                j = Math.max(j, position[c] + 1);
            }
            position[c] = i;
            result = Math.max(result, i - j + 1);
        }

        assertEquals(expected, result);
    }

    private void initPosition(int[] position) {
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
    }
}
