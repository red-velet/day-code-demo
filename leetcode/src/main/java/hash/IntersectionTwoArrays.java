package hash;

import java.util.*;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description:两个数组的交集
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list1 = Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new));
        List<Integer> list2 = Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new));
        HashSet<Integer> hashSet1 = new HashSet<>(list1);
        HashSet<Integer> hashSet2 = new HashSet<>(list2);
        for (int num : hashSet1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : hashSet2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intersection = new IntersectionTwoArrays().intersection(new int[]{1, 2, 3, 4}, new int[]{1, 2});
    }
}
