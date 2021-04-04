package week1.problem.moveZero;

/**
 * 时间复杂度O(n)空间复杂度 O(1)
 * 写一个swap函数用于交换两个元素的位置，中间借助一个临时变量
 */
public class solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
