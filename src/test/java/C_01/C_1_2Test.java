package C_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class C_1_2Test {

    @Test
    void isPermutation_return_false() {
        C_1_2 c_1_2 = new C_1_2();
        String str1 = "abcd";
        String str2 = "dbcd";
        boolean result = c_1_2.isPermutation(str1, str2);
        Assertions.assertFalse(result);
    }

    @Test
    void isPermutation_return_false_by_special_case() {
        C_1_2 c_1_2 = new C_1_2();
        String str1 = "abaadddc";
        String str2 = "ddbaadcc";
        boolean result = c_1_2.isPermutation(str1, str2);
        Assertions.assertFalse(result);
    }

    @Test
    void isPermutation_return_true() {
        C_1_2 c_1_2 = new C_1_2();
        String str1 = "abcde";
        String str2 = "edabc";
        boolean result = c_1_2.isPermutation(str1, str2);
        Assertions.assertTrue(result);
    }

    @Test
    void isPermutation_return_true_by_special_case() {
        C_1_2 c_1_2 = new C_1_2();
        String str1 = "aabbcdd";
        String str2 = "ddaacbb";
        boolean result = c_1_2.isPermutation(str1, str2);
        Assertions.assertTrue(result);
    }

}