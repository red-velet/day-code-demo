package doublepointer;

/**
 * author: chiou
 * createTime: 2023/11/7
 * description: 双指针移除数组相等元素
 */
public class RemoveArrElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int res = new RemoveArrElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println("res = " + res);
    }
}
