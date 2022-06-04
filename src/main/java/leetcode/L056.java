package leetcode;

public class L056 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        L056 l056 = new L056();
        int[][] result = l056.merge(intervals);
        l056.print(result);
    }

    public void print(int[][] arr) {
        for (int[] i : arr) {
            System.out.print(i[0] + ", " + i[1] + ", ");
        }
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        //sort
        mergeSort(intervals, 0, intervals.length - 1);

        //compare
        int i = 0;
        int count = 0;
        for (int j = 1; j < intervals.length; j++) {
            int pivot = intervals[i][1];
            if (pivot >= intervals[j][0]) {
                intervals[j][0] = -1;
                count++;
                if (pivot >= intervals[j][1]) {
                    intervals[j][1] = -1;
                    count++;
                } else {
                    intervals[i][1] = -1;
                    i = j;
                    count++;
                }
            }
        }

        // generate result
        // int[][] result = new int[(intervals.length - count/2)][2];
        // int ri = 0, rj = 0;
        // for (int[] nums : intervals) {
        //     for (int num : nums) {
        //         if (num != -1) {
        //             result[ri][rj] = num;
        //             rj++;
        //             if (rj == 2) {
        //                 ri++;
        //                 rj = 0;
        //             }
        //         }
        //     }
        // }
        return intervals;
    }

    public void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left ) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[][] arr, int left, int mid, int right) {
        int[][] result = new int[right - left + 1][2];
        int l1 = left;
        int l2 = mid + 1;
        int l3 = 0;
        while (l1 <= mid && l2 <= right) {
            if (arr[l1][0] <= arr[l2][0]) {
                result[l3][0] = arr[l1][0];
                result[l3][1] = arr[l1][1];
                l1++;
            } else {
                result[l3][0] = arr[l2][0];
                result[l3][1] = arr[l2][1];
                l2++;
            }
            l3++;
        }
        // deal with remained value
        while (l1 <= mid) {
            result[l3][0] = arr[l1][0];
            result[l3][1] = arr[l1][1];
            l1++;
            l3++;
        }
        while (l2 <= right) {
            result[l3][0] = arr[l2][0];
            result[l3][1] = arr[l2][1];
            l2++;
            l3++;
        }
        // replace
        for (int i = 0; i < result.length; i++) {
            arr[left][0] = result[i][0];
            arr[left][1] = result[i][1];
            left++;
        }
    }
}
