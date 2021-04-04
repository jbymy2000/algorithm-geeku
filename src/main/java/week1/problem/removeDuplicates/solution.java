package week1.problem.removeDuplicates;
/**
 * 用快慢指针的方式
 * 时间复杂度O(n) 空间复杂度O(1)
 * 读题过程中发现这个是有序数组
 */


public class solution {
    public int removeDuplicates(int[] nums) {
        //边界处理，如果长度是0就返回0
        if (nums.length == 0) return 0;
        int i = 0;
        //如果快指针的值和慢指针的值不相等，说明有非重复值，那就把快指针指向的值放到i的下一位并把i向前移动
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

//todo 如果是无序数组怎么办？
