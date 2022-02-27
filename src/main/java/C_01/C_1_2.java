package C_01;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Hints: #1, #84, #122, #131
 */
public class C_1_2 {
    public static void main(String[] args) {
        C_1_2 c_1_2 = new C_1_2();
        String str1 = "sdosssg";
        String str2 = "godsss";
        boolean answer = c_1_2.isPermutation(str1, str2);
        System.out.println("answer: " + answer);
    }

    public boolean isPermutation(String str1, String str2) {
        // K: (int) char
        // V: count
        Map<Integer, Integer> check1 = new HashMap<>();
        Map<Integer, Integer> check2 = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        for (int i = 0; i < str1CharArr.length; i++) {
            Integer str1CharCount = check1.computeIfAbsent((int)str1CharArr[i], V -> 0);
            Integer str2CharCount = check2.computeIfAbsent((int)str2CharArr[i], V -> 0);
            str1CharCount++;
            str2CharCount++;
        }

        if (check1.size() != check1.size()) {
            return false;
        }

        for (Integer key : check1.keySet()) {
            Integer str1CharCount = check1.get(key);
            Integer str2CharCount = check2.get(key);
            if (str2CharCount == null) {
                return false;
            }
            if (str1CharCount.intValue() != str2CharCount.intValue()) {
                return false;
            }
        }
        return true;
    }

}
