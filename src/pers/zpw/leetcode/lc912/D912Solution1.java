package pers.zpw.leetcode.lc912;

import java.util.Arrays;

/**
 *  选择排序
 *  每一轮选取未排定的部分中最小的元素交换到最开头，经过若干个步骤 就能排定整个数组
 *  即：
 *  先选出最小的数据，然后选出第二小的数据 以此类推
 *
 *  思想 ：
 *     贪心思想：每一次决策只看当前，当前最优，则全局最优。注意这种思想不是任何时候都适用
 *     减治思想：外层循环每次只排一个元素，每次的问题逐渐减少，直到全部解决，即【大二化小，小而化了】 这种思想最有名的就是"二分查找"
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2020-03-31 19:21
 */
public class D912Solution1 {

    public static void main(String[] args) {

        int[] arr = {8, 3, 2, 1, 6, 4};

        int[] arrSorted = sortArray(arr);

        System.out.println(Arrays.toString(arrSorted));

    }

    public static int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int tempIndex = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (temp > nums[j]) {
                    temp = nums[j];
                    tempIndex = j;
                }
            }
            if (tempIndex != -1) {
                nums[tempIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
