package greedy;

import lombok.extern.slf4j.Slf4j;

/**
 * author: redvelet
 * createTime: 2024/1/5
 * description: 最大连续子数组
 */
@Slf4j
public class MaxArraySum {
    /**
     * 最小最优解：每次找到子序和，如果继续加还小于0，就抛弃之前的
     * 注意：全是负数的情况
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxArraySum maxArraySum = new MaxArraySum();
        int result = maxArraySum.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        log.debug("result = {}", result);
    }
}
