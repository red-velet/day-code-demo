package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/11/4
 * description: 三数之和
 */
public class SumThreeNumbers {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            //如果不是第一个数开始枚举，且和上一个数相等，则去除重复，跳过该数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //去除重复k和j,同时指针移动缩小范围
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    //范围大就缩小右边
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("new SumThreeNumbers().threeSum(new int[]{}) = \n" + new SumThreeNumbers().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
