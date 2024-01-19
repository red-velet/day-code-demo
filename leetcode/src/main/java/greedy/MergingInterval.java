package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 合并区间
 */
public class MergingInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(Arrays.copyOf(intervals[0], intervals[0].length));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            } else {
                result.add(Arrays.copyOf(intervals[i], intervals[i].length));
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
