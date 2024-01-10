package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/10
 * description: 跳跃游戏
 */
public class JumpingGame {
    //跳跃游戏：能否到达终点
    // 思路在于将跳跃转换为覆盖范围，每次在覆盖范围内移动，每次添加步数
    public boolean canJump(int[] nums) {
        boolean flag = false;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //跳跃游戏：到达终点的最小步数
    //每次取最大，到了边界就记录步数
    public int jump(int[] nums) {
        int maxPos = 0;
        int res = 0;
        int currEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == currEnd) {
                currEnd = maxPos;
                res++;
            }
        }
        return res;
    }
}
