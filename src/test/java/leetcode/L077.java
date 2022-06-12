package leetcode;

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

    @ParameterizedTest
    @MethodSource("arrayStream1")
    public void combine(int n, int k, List<List<Integer>> expected) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        assertEquals(expected, combs);
    }
    public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
