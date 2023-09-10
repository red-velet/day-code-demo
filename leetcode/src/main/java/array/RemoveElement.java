package array;

/**
 * author: chiou
 * createTime: 2023/9/10
 * description: 移除元素
 */
public class RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  值
     * @return 移除后数组的新长度
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[fast++]) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 8, 1};
        int val = 1;
        RemoveElement element = new RemoveElement();
        int len = element.removeElement(nums, val);
        System.out.println("len = " + len);
    }
}
