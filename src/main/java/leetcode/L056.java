package leetcode;

public class L056 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        int[][] arr = copy(intervals);

        //sort
        mergeSort(arr, 0, arr.length - 1);
        //compare
        return arr;
    }

    public void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[][] arr, int left, int mid, int right) {
        int[][] result = new int[right - left + 1][2];
        int i1 = left;
        int j1 = 0;
        int i2 = mid + 1;
        int j2 = 0;
        int i3 = 0;
        int j3 = 0;
        while (i1 <= mid && i2 <= right) {
            if (arr[i1][j1] <= arr[i2][j2]) {
                result[i3][j3] = arr[i1][j1];
                j1++;
            } else {
                result[i3][j3] = arr[i2][j2];
                j2++;
            }
            j3++;
            if (j1 == 2) {
                j1 = 0;
                i1++;
            }
            if (j2 == 2) {
                j2 = 0;
                i2++;
            }
            if (j3 == 2) {
                j2 = 0;
                i2++;
            }
        }
        // add remained value
        while (i1 <= mid) {
            result[i3][j3] = arr[i1][j1];
            j1++;
            j3++;
            if (j1 == 2) {
                j1 = 0;
                i1++;
            }
            if (j3 == 2) {
                j2 = 0;
                i2++;
            }
        }
        while (i2 <= right) {
            result[i3][j3] = arr[i2][j2];
            j2++;
            j3++;
            if (j2 == 2) {
                j2 = 0;
                i2++;
            }
            if (j3 == 2) {
                j2 = 0;
                i2++;
            }
        }
        // replace
        for (int[] ints : result) {
            arr[left][0] = ints[0];
            arr[left][1] = ints[1];
        }
    }

    public int[][] copy(int[][] intervals) {
        int[][] arr = new int[intervals.length][2];
        //copy intervals
        for (int i = 0; i < intervals.length; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        return arr;
    }
}
