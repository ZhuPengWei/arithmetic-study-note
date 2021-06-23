package pers.zpw.leetcode.lc912;

/**
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-06-23 16:30
 */
public class Solution {

    public static void main(String[] args) {
        sortArray(new int[]{5, 6, 9, 4, 3});
    }

    // 快速排序
    public static int[] sortArray(int[] nums) {
        // 判断边界条件
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }


        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        // 选取基准值
        int base = nums[left];

        int i = left, j = right;

        while (i != j) {
            // 先从右边往左找,直到找到比基准值小的数
            while (nums[j] >= base && i < j) {
                j--;
            }
            // 再从左边往右边找,直到找到比基准值大的数
            while (nums[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;

        // 左
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }
}
