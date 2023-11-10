package stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * author: chiou
 * createTime: 2023/11/10
 * description:
 */
public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //入队：去除所有比当前元素小的
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //出队
            if (i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            //记录最大值：条件-长度为k
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();
        int[] ints = window.maxSlidingWindow(new int[]{9, 11}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
