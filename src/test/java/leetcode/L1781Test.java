package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L1781Test {

    @ParameterizedTest
    @CsvSource({
            "aabcb,5",
            "aabcbaa, 17"
    })
    public void test(String s, int expected) {
        L1781 l1781 = new L1781();
        int actual = l1781.beautySum(s);
        assertEquals(expected, actual);
    }
}
