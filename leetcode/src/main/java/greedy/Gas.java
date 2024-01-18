package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/17
 * description: 加油站
 */
public class Gas {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += (gas[i] - cost[i]);
        }
        if (totalSum < 0) {
            return -1;
        }

        int currSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currSum += (gas[i] - cost[i]);
            if (currSum < 0) {
                start = i + 1;
                currSum = 0;
            }
        }
        return start;
    }
}
