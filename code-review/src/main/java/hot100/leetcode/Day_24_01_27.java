package hot100.leetcode;

import java.util.*;

/**
 * author: redvelet
 * createTime: 2024/1/27
 * description:
 */
public class Day_24_01_27 {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (table.containsKey(tar)) {
                return new int[]{i, table.get(tar)};
            } else {
                table.put(nums[i], i);
            }
        }
        return null;
    }

    //字母的异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            hash.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        result.addAll(hash.values());
        return result;
    }

    public String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return Arrays.toString(charArray);
    }


    //最长连续序列
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
        for (Integer val : set) {
            if (!set.contains(val - 1)) {
                int k = val + 1;
                while (set.contains(k)) {
                    k++;
                }
                len = Math.max(len, k - val);
            }
        }
        return len;
    }

    //移动零
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        while (slow < fast) {
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
        Day_24_01_27 demo = new Day_24_01_27();
        int[] nums = {0, 1, 0, 3, 1, 2};
        demo.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
