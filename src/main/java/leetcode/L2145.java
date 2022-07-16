package leetcode;

import java.util.stream.IntStream;

public class L2145 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int[] hiddens = new int[differences.length + 1];
        int min = hiddens[0];
        int max = hiddens[0];
        for (int i = 0; i < differences.length; i++) {
            hiddens[i + 1] = hiddens[i] + differences[i];
            min = Math.min(min, hiddens[i + 1]);
            max = Math.max(max, hiddens[i + 1]);
        }



        int add = lower - min;
        for (int i = 0; i < hiddens.length; i++) {
            hiddens[i] += add;
        }
        int tempMax = max + add;
        if (tempMax > upper) {
            return 0;
        }
        int possible = upper - tempMax + 1;
        return possible;
    }

}
