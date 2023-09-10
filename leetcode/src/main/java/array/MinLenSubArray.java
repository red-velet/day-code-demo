package array;

/**
 * author: chiou
 * createTime: 2023/9/10
 * description: 最小长度的子数组
 */
public class MinLenSubArray {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于targe 的长度最小的连续子数组 ：
     * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * @param target 正整数的数组
     * @param nums   正整数的数组
     * @return 长度最小的连续子数组的长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = 0;
        int l = 0;
        int r = 0;
        //循环条件
        while (r < nums.length) {
            //窗口扩大，更新当前结果
            sum += nums[r];
            //如果满足条件
            while (sum >= target) {
                //更新最优解
                if ((r - l + 1) < minLen || minLen == 0) {
                    minLen = r - l + 1;
                }
                //缩小左窗口
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen;
    }

    public int findMaxNonDecreasingSeq(int[] nums) {
        int maxLen = 0;
        int curLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
        }

        return Math.max(maxLen, curLen);
    }


}
