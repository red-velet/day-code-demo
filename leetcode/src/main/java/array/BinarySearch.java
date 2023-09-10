package array;

/**
 * author: chiou
 * createTime: 2023/9/10
 * description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值索引
     */
    public int search(int[] nums, int target) {
        int res = -1;
        //边界判断
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                res = mid;
                break;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //查找
        return res;
    }

    
}
