package greedy;

import java.util.Arrays;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 最小弓箭数量
 */
public class MinShots {
    public int findMinArrowShots(int[][] points) {
        //根据区间左边界进行排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
