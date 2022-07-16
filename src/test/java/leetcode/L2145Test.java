package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L2145Test {


    private static Stream<Arguments> cases() {
        int[] differences = new int[100000];
        for (int i = 0; i < differences.length; i++) {
            differences[i] = 100000;
        }
        return Stream.of(Arguments.of(differences, -100000, 100000, 0));
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void test(int[] differences, int lower, int upper, int expected) {
        L2145 l2145 = new L2145();
        int actual = l2145.numberOfArrays(differences, lower, upper);
        assertEquals(expected, actual);
    }
}
