package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L2325Test {


    @ParameterizedTest
    @CsvSource({"the quick brown fox jumps over the lazy dog, vkbs bs t suepuv, this is a secret",
            "eljuxhpwnyrdgtqkviszcfmabo, zwx hnfx lqantp mnoeius ycgk vcnjrdb, the five boxing wizards jump quickly"})
    public void test(String key, String message, String expected) {
        L2325 l2325 = new L2325();
        String actual = l2325.decodeMessage(key, message);
        assertEquals(expected, actual);
    }
}
