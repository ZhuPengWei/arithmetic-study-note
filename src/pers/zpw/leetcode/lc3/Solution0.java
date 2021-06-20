package pers.zpw.leetcode.lc3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  方法 穷举法
 */
public class Solution0 {

    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));

    }


    public static int lengthOfLongestSubstring(String s) {

        int maxlength = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
            for (int j = i + 1; j < s.length() ; j++) {
                char c1 = s.charAt(j);
                if (set.contains(c1)) {
                    break;
                }
                set.add(c1);
            }
            if (set.size() > maxlength) {
                maxlength = set.size();
            }
            set.clear();
        }

        return maxlength;
    }
}
