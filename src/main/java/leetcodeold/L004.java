package leetcodeold;

public class L004 {

    public static void main(String[] args) {
        L004 l004 = new L004();
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        int[] nums1 = {};
//        int[] nums2 = {1};
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        double result = l004.findMedianSortedArrays(nums1, nums2);
        System.out.println("result: " + result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        length = length / 2 + 1;
        int[] cache = new int[2];
        int count = 0;
        int i1 = 0;
        int i2 = 0;
        while (count < length) {
            if (i1 < nums1.length && i2 < nums2.length && nums1[i1] <= nums2[i2]) {
                cache[count % 2] = nums1[i1];
                i1++;
            } else if (i1 < nums1.length && i2 < nums2.length && nums2[i2] <= nums1[i1]) {
                cache[count % 2] = nums2[i2];
                i2++;
            } else if (i1 >= nums1.length) {
                cache[count % 2] = nums2[i2];
                i2++;
            } else {
                cache[count % 2] = nums1[i1];
                i1++;
            }
            count++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return (double) cache[0];
        } else {
            return ((double) cache[0] + (double) cache[1]) / 2;
        }
    }
}
