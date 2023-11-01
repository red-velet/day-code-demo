package hash;

import java.util.HashSet;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description: 快乐数
 */
public class HappyNum {
    public boolean isHappy(int n) {
        //循环获取每一位数
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            int sum = getSum(n);
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow((n % 10), 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean happy = new HappyNum().isHappy(7);

    }
}
