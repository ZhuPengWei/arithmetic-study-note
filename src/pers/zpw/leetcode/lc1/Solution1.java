package pers.zpw.leetcode.lc1;


class Solution1 {
    // 暴力解法
    // 代码复杂度 n^2
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]+ nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
