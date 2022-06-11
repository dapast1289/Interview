import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L994 {


    private static Stream<Arguments> arrayStream(){
        int[][] grid1 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 2}};
        int[][] grid3 = new int[][]{ {1}, {2}};
        return Stream.of(
                Arguments.of(grid1, 4),
                Arguments.of(grid2, 2),
                Arguments.of(grid3, 1));
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    public void orangesRottingDFS(int[][] grid, int expectedResult) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottingByDFS(grid, i, j, 2);
                }
            }
        }

        // check if ther are still fresh orange left
        int minutes = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    assertEquals(expectedResult, -1);
                } else {
                    minutes = Math.max(minutes, grid[i][j]);
                }
            }
        }
        assertEquals(expectedResult, minutes - 2);
    }

    public void rottingByDFS(int[][] grid, int i, int j, int minutes) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ||
                (grid[i][j] > 1 && minutes > grid[i][j])) {
            return;
        };
        grid[i][j] = minutes;
        rottingByDFS(grid, i, j + 1, minutes + 1);
        rottingByDFS(grid, i, j - 1, minutes + 1);
        rottingByDFS(grid, i + 1, j, minutes + 1);
        rottingByDFS(grid, i - 1, j, minutes + 1);
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    public void orangesRottingBFS(int[][] grid, int expectedResult) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;
        int[][] direct = new int[][]{{0, -1},  {1, 0}, {0, 1}, {-1, 0}};
        if (fresh == 0) {
            assertEquals(expectedResult, 0);
        }
        while (!queue.isEmpty() && fresh > 0) {
            boolean isRottingFresh = false;
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] cur = queue.poll();
                for (int[] way : direct) {
                    int new_i = cur[0] + way[0], new_j = cur[1] + way[1];
                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        queue.offer(new int[]{new_i, new_j});
                        fresh--;
                        if (!isRottingFresh) {
                            isRottingFresh = true;
                            minute++;
                        }
                    }
                }
            }
        }
//        return (fresh > 0) ? -1 : minute;
        if (fresh > 0) {
            assertEquals(expectedResult, -1);
        } else {
            assertEquals(expectedResult, minute);
        }
    }
}
