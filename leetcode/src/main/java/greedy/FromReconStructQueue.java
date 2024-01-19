package greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 根据身高重建队列
 */
public class FromReconStructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //核心思路：先根据身高进行排序，然后再根据大于它身高的数量进行插入，因为往前插入，并不会影响前面元素比它之前大的数量变化
        Arrays.sort(people, (o1, o2) -> {
            //身高相同，根据k（比它身高高的数量）升序
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            //不相等就按升高降序
            return o2[0] - o1[0];
        });
        //创建队列，存放元素，进行插入
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            int pos = person[1];
            queue.add(pos, person);
        }
        return queue.toArray(new int[people.length][]);
    }
}
