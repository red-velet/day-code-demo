package stackandqueue;

import java.util.*;

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

    //前k个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //记录每个元素值及其频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Queue<Map.Entry<Integer, Integer>> priority = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            priority.offer(entry);
            if (priority.size() > k) {
                priority.poll();
            }
        }
        int index = 0;
        while (!priority.isEmpty()) {
            Integer key = priority.poll().getKey();
            res[index++] = key;
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();
        int[] ints = window.maxSlidingWindow(new int[]{9, 11}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
