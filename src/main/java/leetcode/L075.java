package leetcode;

public class L075 {
    public static void main(String[] args) {
        L075 l075 = new L075();
        int[] nums = {2, 0, 2 ,1, 1, 0};
        l075.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    public void sortColors(int[] nums) {
        int point = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[point] == 0) {
                swap(nums, point, left);
                left++;
                point++;
            } else if (nums[point] == 1) {
                point++;
            } else {
                swap(nums, point, right);
                right--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
