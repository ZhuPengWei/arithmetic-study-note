package pers.zpw.leetcode.lc912;

import java.util.Arrays;

/**
 * 插入排序:
 *   每次将一个元素插入到一个有序的数组里面，形成一个长度更大的有序数组，有限次操作之后，数组整体有序
 *
 *  [需要再次理解]
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2020-04-01 09:39
 */
public class D912Solution2 {


    public static void main(String[] args) {


        int[] arr = {8, 3, 2, 1, 6, 4};

        int[] arrSorted = sortArray(arr);

        System.out.println(Arrays.toString(arrSorted));

    }

    public static int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }
}
