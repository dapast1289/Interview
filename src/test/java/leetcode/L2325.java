package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L2325 {

    private static Stream<Arguments> arrayStream() {
        return Stream.of(
                Arguments.of("the quick brown fox jumps over the lazy dog",
                        "vkbs bs t suepuv", "this is a secret")
        );
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    public void decodeMessage(String key, String message, String expected) {
        int[] substitutionTable = initTable(key);

        char[] result = message.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != ' ') {
                int index = getTableIndex(result[i]);
                result[i] = (char) (substitutionTable[index] + 97);
            }
        }
        System.out.println(result);
//        return new String(result);
    }

    private int[] initTable(String key) {
        int[] substitutionTable = new int[26];
        for (int i = 0; i < substitutionTable.length; i++) {
            substitutionTable[i] = -1;
        }
        int i = 0;
        for (char c : key.toCharArray()) {
            int tableIndex = getTableIndex(c);
            if (c != ' ' && substitutionTable[tableIndex] == -1) {
                substitutionTable[tableIndex] = i;
                i++;
            }
        }
        return substitutionTable;
    }

    private int getTableIndex(char c) {
        return c - 97;
    }
}
