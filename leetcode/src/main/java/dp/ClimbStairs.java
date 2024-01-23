package dp;

/**
 * author: redvelet
 * createTime: 2024/1/23
 * description:
 */
public class ClimbStairs {
    //爬楼梯
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        //1.确立dp数组，dp数组含义
        int[] dp = new int[cost.length + 1];

        //3.dp数组初始化
        dp[0] = 0;
        dp[1] = 0;

        //2.递推公式
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
