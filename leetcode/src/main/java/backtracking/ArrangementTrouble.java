package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2023/12/13
 * description: 排列问题
 */
public class ArrangementTrouble {
    public List<List<Integer>> permute(int[] nums) {
        //1.确定参数
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (boolean b : used) {
            b = false;
        }
        permuteDfs(result, path, used, nums);
        return result;
    }

    private void permuteDfs(List<List<Integer>> result, List<Integer> path, boolean[] used, int[] nums) {
        //2.循环终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteDfs(result, path, used, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    //全排列2
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        //1.确定参数
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (boolean b : used) {
            b = false;
        }
        permuteUniqueDfs(result, path, used, nums);
        return result;
    }

    private void permuteUniqueDfs(List<List<Integer>> result, List<Integer> path, boolean[] used, int[] nums) {
        //2.循环终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteDfs(result, path, used, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
