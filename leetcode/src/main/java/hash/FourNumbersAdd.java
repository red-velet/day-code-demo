package hash;

import java.util.HashMap;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description: 四数相加
 */
public class FourNumbersAdd {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int k : nums3) {
            for (int l : nums4) {
                sum += map.getOrDefault(0 - (k + l), 0);
            }
        }
        return sum;
    }
}
