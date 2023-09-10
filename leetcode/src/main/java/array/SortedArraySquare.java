package array;

/**
 * author: chiou
 * createTime: 2023/9/10
 * description: 有序数组的平方
 */
public class SortedArraySquare {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方组成的新数组，要求也按非递减顺序 排序。
     *
     * @param nums 整数数组
     * @return 每个数字的平方组成的新数组
     */
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] newArr = new int[nums.length];
        int index = nums.length - 1;
        while (l <= r) {
            int m = nums[l] * nums[l];
            int n = nums[r] * nums[r];
            if (m < n) {
                newArr[index--] = n;
                r--;
            } else {
                newArr[index--] = m;
                l++;
            }
        }
        return newArr;
    }
}
