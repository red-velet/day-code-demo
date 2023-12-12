package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/12/12
 * description: 子集问题
 */
public class SubsetProblem {
    public List<List<Integer>> subsets(int[] nums) {
        //1.确定传入参数1
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int startIndex = 0;
        subsetsBacktracking(result, path, startIndex, nums);
        return result;
    }

    private void subsetsBacktracking(List<List<Integer>> result, List<Integer> path, int startIndex, int[] nums) {
        result.add(new ArrayList<>(path));
        //2.确定终止条件
        if (startIndex >= nums.length) {
            return;
        }
        //3.确定单层递归逻辑
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsBacktracking(result, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    //子集Ⅱ
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //1.确定传入参数1
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        int startIndex = 0;
        subsetsWithDupBacktracking(result, path, startIndex, nums);
        return result;
    }

    private void subsetsWithDupBacktracking(List<List<Integer>> result, List<Integer> path, int startIndex, int[] nums) {
        result.add(new ArrayList<>(path));
        //2.确定终止条件
        if (startIndex >= nums.length) {
            return;
        }
        //3.确定单层递归逻辑
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsetsBacktracking(result, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    //递增子序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        //1.确定传入参数1
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int startIndex = 0;
        findSubsequencesBacktracking(result, path, startIndex, nums);
        return result;
    }

    private void findSubsequencesBacktracking(List<List<Integer>> result, List<Integer> path, int startIndex, int[] nums) {
        //2.确定终止条件
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
            return;
        }
        //3.确定单层递归逻辑
        //树层去除
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //要递增且不重复
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || hs.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            hs.add(nums[i]);
            subsetsBacktracking(result, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetProblem sub = new SubsetProblem();
        List<List<Integer>> subsets = sub.subsets(new int[]{1, 2, 3});
        System.out.println("subsets = " + subsets);
    }
}
