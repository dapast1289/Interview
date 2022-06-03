package leetcode;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        int[] tree = {2, 5, 3, 1, 10, 4};
        Heap heap = new Heap();
//        heap.heapify(tree, tree.length, 0);
        heap.buildHeap(tree, tree.length);
//        heap.heapSort(tree, tree.length);
        for (int node : tree) {
            System.out.println(node);
        }
    }

    public void heapSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(tree, i, 0);
            heapify(tree, 0, i);
        }
    }

    public void buildHeap(int[] tree, int n) {
        int lastNode = n - 1;
        int lastParent = (lastNode - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public void heapify(int[] tree, int n, int i) {
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (i > n) {
            return;
        }
        if (c1 < tree.length && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < tree.length && tree[c2] > tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, i);
        }
    }

    public void swap(int[] tree, int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }
}
