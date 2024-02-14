package hot100.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author red-velvet
 * @since 2024/2/14
 */
public class Day_24_02_24 {
    //找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> startIndexes = new ArrayList<>();
        int[] target = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        for (int right = 0, left = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                window[s.charAt(left++) - 'a']--;
            }
            if (collectRes(target, window)) {
                startIndexes.add(left);
            }
        }
        return startIndexes;
    }

    private boolean collectRes(int[] target, int[] window) {
        for (int i = 0; i < target.length; i++) {
            if (target[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}
