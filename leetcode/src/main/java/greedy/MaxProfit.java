package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/5
 * description: 股票买卖
 */
public class MaxProfit {
    /**
     * 思路：求出每天的；利润，然后取利润为正数进行累加
     *
     * @param prices
     * @return
     */
    public int maxProfitTwo(int[] prices) {
        int maxProfile = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfile += diff;
            }
        }
        return maxProfile;
    }
}
