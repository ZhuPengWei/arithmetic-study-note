package pers.zpw.leetcode.lc215;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2021-06-17 16:14
 */
public class Demo1 {

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{1, 3, 4, 2, 0, 9, 13, 11}, 4);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {

        // 将nums 排序 使用选择
        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }
            if (max != i) {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
            }
        }

        return nums[k - 1];
    }

}
