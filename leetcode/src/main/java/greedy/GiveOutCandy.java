package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/18
 * description: 分发糖果
 */
public class GiveOutCandy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = (ratings[i] > ratings[i - 1]) ? (candy[i - 1] + 1) : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int j : candy) {
            sum += j;
        }
        return sum;
    }
}
