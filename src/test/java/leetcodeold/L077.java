package leetcodeold;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L077 {
    private static Stream<Arguments> arrayStream1() {
        List<List<Integer>> expected = new LinkedList<>();
        int[][] expected1In = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {3, 4}
        };
        for (int[] numList : expected1In) {
            List<Integer> ans = new ArrayList<>();
            for (int num : numList) {
                ans.add(num);
            }
            expected.add(ans);
        }
        return Stream.of(
                Arguments.of(4, 2, expected));
    }

    private static Stream<Arguments> arrayStream2() {
        List<List<Integer>> expected = new LinkedList<>();
        int[][] expected1In = {
                {1, 2, 3},
                {1, 2, 4},
                {1, 3, 4},
                {2, 3, 4}
        };
        for (int[] numList : expected1In) {
            List<Integer> ans = new ArrayList<>();
            for (int num : numList) {
                ans.add(num);
            }
            expected.add(ans);
        }
        return Stream.of(
                Arguments.of(4, 3, expected));
    }

    @ParameterizedTest
    @MethodSource({"arrayStream1", "arrayStream2"})
    public void combine(int n, int k, List<List<Integer>> expected) {
        System.out.println(String.format("input: n = %d, k = %d \n", n, k));
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        assertEquals(expected, combs);
    }

    public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            print(combs, comb, i, start, n, k);
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    int count = 0;
    public void print(List<List<Integer>> combs, List<Integer> comb, int i_, int start, int n, int k) {
        String combsStr = "[";
        for (List<Integer> i : combs) {
            combsStr += "[";
            for (Integer j : i) {
                combsStr += j + ", ";
            }
            combsStr = combsStr.substring(0, combsStr.length() - 2);
            combsStr += "], ";
        }
        if (combsStr.length() > 2) {
            combsStr = combsStr.substring(0, combsStr.length() - 2);
        }
        combsStr += "]";

        String combStr = "[";
        for (Integer j : comb) {
            combStr += j + ", ";
        }
        if (combStr.length() > 1) {
            combStr = combStr.substring(0, combStr.length() - 2);
        }
        combStr += "]";
        System.out.println(String.format("count: %d", count));
        System.out.println(String.format("combs: %s", combsStr));
        System.out.println(String.format("comb: %s", combStr));
        System.out.println(String.format("i: %d", i_));
        System.out.println(String.format("start: %d", start));
        System.out.println(String.format("n: %d", n));
        System.out.println(String.format("k: %d", k));
        System.out.println();
        count++;
    }

}
