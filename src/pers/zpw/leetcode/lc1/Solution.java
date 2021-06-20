package pers.zpw.leetcode.lc1;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 缓存的思想(用空间换时间的思想))
    public int[] twoSum(int[] nums, int target) {

       Map<Integer,Integer> cache =new HashMap<>();

       for(int i=0 ; i<nums.length ; i++){
           int key = target -nums[i] ;
           if(cache.containsKey(key)){
               return new int[]{i,cache.get(nums[i])};
           }
           cache.put(nums[i],i);
       }
       return null;
    }
}
