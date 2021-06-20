package pers.zpw.leetcode.lc215;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-06-17 16:14
 */
public class Demo2 {

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{6, 3, 7, 9, 8, 5, 4}, 4);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {

        // 将nums 排序 使用快速排序
        quickSort(nums);

        return nums[k - 1];
    }

    private static void quickSort(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 1 || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序核心算法,递归实现
     */
    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        // base中存放基准数
        int base = nums[left];

        int i = left, j = right;
        while (i != j) {

            // 先从右边开始往左边找,直到找到比base值大的数量
            while (i < j && base >= nums[j]) {
                j--;
            }
            // 在从左边找 直到找到比base小的数
            while (i < j && base <= nums[i]) {
                i++;
            }

            // 如果上面的循环结束的话,表示找到了位置 或者  i>=j了 ,交换两个数在数组之中的位置
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 将基准数放到中间的位置
        nums[left] = nums[i];
        nums[i] = base;

        // 递归 继续向基准的左右两边执行和上面同样的操作
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }

}
