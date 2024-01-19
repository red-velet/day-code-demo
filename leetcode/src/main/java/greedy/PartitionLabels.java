package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 划分字母区间
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] letterMaxPost = new int[27];
        for (int i = 0; i < s.length(); i++) {
            letterMaxPost[s.charAt(i) - 'a'] = i;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, letterMaxPost[s.charAt(i) - 'a']);
            if (r == i) {
                result.add((r - l) + 1);
                l = i + 1;
            }
        }
        return result;
    }
}
