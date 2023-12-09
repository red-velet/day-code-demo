package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: chiou
 * createTime: 2023/12/8
 * description: 组合问题
 */
public class CombinationQuestion {
    //给定两个整数 `n` 和 `k`，返回范围 `[1, n]` 中所有可能的 `k` 个数的组合。
    public List<List<Integer>> combine(int n, int k) {
        //1.确定参数和返回值
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int startIndex = 1;
        backtracking(result, path, n, k, startIndex);

        //返回结果
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> path, int n, int k, int startIndex) {
        //2.确立递归终止条件
        if (k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //3.确立单层递归逻辑
        //剪枝
        for (int i = startIndex; i <= (n - (k - path.size()) + 1); i++) {
            path.add(i);
            backtracking(result, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //---------------------分----------------界----------------------线-------------
    //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    //
    //只使用数字1到9
    //每个数字 最多使用一次
    //返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking3(result, path, n, k, 1, 0, 10);
        return result;
    }

    public void backtracking3(List<List<Integer>> result, List<Integer> path, int n, int k, int startIndex, int sum, int range) {
        if (path.size() == k) {
            if (n == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = startIndex; i < range - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking3(result, path, n, k, i + 1, sum, range);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }

    //---------------------分----------------界----------------------线-------------
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackingCombinationSum(result, path, candidates, target, 0, 0);
        return result;
    }

    private void backtrackingCombinationSum(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtrackingCombinationSum(result, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    //---------------------分----------------界----------------------线-------------
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackingCombinationSum2(result, path, candidates, target, 0, 0);
        return result;
    }

    private void backtrackingCombinationSum2(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrackingCombinationSum2(result, path, candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    //电话号码字母组合
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits != null && !"".equals(digits)) {
            backtrackingLetterCombinations(result, digits, new StringBuilder(), 0);
        }
        return result;
    }

    String[] str = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pars", "tuv", "wxyz"};

    private void backtrackingLetterCombinations(List<String> result, String digits, StringBuilder path, int numIndex) {
        if (numIndex == digits.length()) {
            result.add(new String(path));
            return;
        }
        int digit = digits.charAt(numIndex) - '0';
        String letter = str[digit];
        for (int i = 0; i < letter.length(); i++) {
            path.append(letter.charAt(i));
            backtrackingLetterCombinations(result, digits, path, numIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    //分割回文串
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrackingPartition(result, path, s, 0);
        return result;
    }

    private void backtrackingPartition(List<List<String>> result, List<String> path, String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isHuiWen(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtrackingPartition(result, path, s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isHuiWen(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //复原ip地址
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrackingRestoreIpAddresses(result, new StringBuilder(s), 0, 0);
        return result;
    }

    private void backtrackingRestoreIpAddresses(List<String> result, StringBuilder path, int pointNum, int startIndex) {
        if (pointNum == 3) {
            if (isValidIpNum(path, startIndex, path.length() - 1)) {
                result.add(path.toString());
            }
            return;
        }
        for (int i = startIndex; i < path.length(); i++) {
            if (isValidIpNum(path, startIndex, i)) {
                path.insert(i + 1, ".");
                backtrackingRestoreIpAddresses(result, path, pointNum + 1, i + 2);
                path.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private boolean isValidIpNum(StringBuilder s, int start, int end) {
        //范围要正确
        if (start > end) {
            return false;
        }
        //不能0开头
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        //数字范围要正确
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CombinationQuestion main = new CombinationQuestion();
        List<List<Integer>> lists = main.combinationSum2(new int[]{2, 5, 2, 1, 2}, 4);
        System.out.println("lists = " + lists);
    }

}
