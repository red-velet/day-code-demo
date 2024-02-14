package hot100.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * author: redvelet
 * createTime: 2024/2/3
 * description:
 */
public class Day_24_02_03 {
    //滑动窗口：无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int maxLen = 0;
        int currLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = s.length();
        while (l < r) {
            for (int i = l; i < s.length(); i++) {
                //如果没有就放入，同时长度+1
                Integer isExist = map.getOrDefault(s.charAt(i), 0);
                if (isExist == 0) {
                    currLen++;
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                } else {
                    map.clear();
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    maxLen = Math.max(currLen, maxLen);
                    currLen = 1;
                }
            }
            l++;
            map.clear();
        }
        maxLen = Math.max(currLen, maxLen);
        return maxLen;
    }
}
