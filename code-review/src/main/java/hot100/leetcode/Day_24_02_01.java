package hot100.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2024/2/1
 * description:
 */
public class Day_24_02_01 {
    //盛水最多的容器
    public int maxArea(int[] height) {
        //核心思路：最短的板决定了容量
        int l = 0;
        int r = height.length - 1;
        int waterCapacity = 0;
        while (l < r) {
            waterCapacity = height[l] < height[r] ?
                    Math.max(waterCapacity, (r - l) * height[l++]) :
                    Math.max(waterCapacity, (r - l) * height[r--]);
        }
        return waterCapacity;
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        //核心思路：固定一个数，然后使用双指针左右移动
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
