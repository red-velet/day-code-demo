package greedy;

import java.util.Arrays;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 无重叠区间
 */
public class NonOverLap {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                System.out.println("find a non over lap");
            } else {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return count;
    }
}
