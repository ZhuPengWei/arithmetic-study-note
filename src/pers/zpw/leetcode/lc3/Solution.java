package pers.zpw.leetcode.lc3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  方法 滑动窗口
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }


    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();

        int left = 0, right = -1;

        while (left < s.length()) {
            char c = s.charAt(left);


            if ((right + 1 < s.length())
                    && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            } else {
                set.remove(c);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
