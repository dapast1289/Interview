package leetcodeold;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L067 {

    private static Stream<Arguments> arrayStream(){
        int[][] grid1 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 2}};
        int[][] grid3 = new int[][]{ {1}, {2}};
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("1111", "1", "10000")
        );
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    public void addBinary(String a, String b, String expected) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int aI = aArr.length - 1, bI = bArr.length - 1;
        int tempSum = 0;

        StringBuilder result = new StringBuilder();
        while (aI >= 0 && bI >= 0) {
            tempSum += Integer.valueOf(aArr[aI]) + Integer.valueOf(bArr[bI]);
            result.insert(0, tempSum % 2);
            tempSum = tempSum / 2;
            aI--;
            bI--;
        }
        while (aI >= 0) {
            tempSum += Integer.valueOf(aArr[aI]);
            result.insert(0, tempSum % 2);
            tempSum = tempSum / 2;
            aI--;
        }
        while (bI >= 0) {
            tempSum += Integer.valueOf(bArr[bI]);
            result.insert(0, tempSum % 2);
            tempSum = tempSum / 2;
            bI--;
        }
        if (tempSum > 0) {
            result.insert(0, tempSum);
        }
        assertEquals(expected, result.toString());
    }
}
