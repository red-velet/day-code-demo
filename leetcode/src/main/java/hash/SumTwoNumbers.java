package hash;

import java.util.HashMap;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description: 两数之和
 */
public class SumTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                indexes[0] = i;
                indexes[1] = map.get(num);
                return indexes;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
