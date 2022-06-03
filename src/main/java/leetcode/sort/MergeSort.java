package leetcode.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {10, 3, 4, 2, 7, 5, 6, 1, 8, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int arr_i = left;
        int arr_j = mid + 1;
        while (arr_i <= mid && arr_j <= right) {
            if (arr[arr_i] < arr[arr_j]) {
                temp[i] = arr[arr_i];
                arr_i++;
            } else {
                temp[i] = arr[arr_j];
                arr_j++;
            }
            i++;
        }
        while (arr_i <= mid) {
            temp[i] = arr[arr_i];
            i++;
            arr_i++;
        }
        while (arr_j <= right) {
            temp[i] = arr[arr_j];
            i++;
            arr_j++;
        }
        // copy value back to arr
        for (int t : temp) {
            arr[left] = t;
            left++;
        }
    }
}
