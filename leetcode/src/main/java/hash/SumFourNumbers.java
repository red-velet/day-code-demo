package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/11/5
 * description:
 */
public class SumFourNumbers {
    //四数之和-双向双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            //对i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //对j去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        //对k去重
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        //对l去重
                        l--;
                        while (l > k && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
