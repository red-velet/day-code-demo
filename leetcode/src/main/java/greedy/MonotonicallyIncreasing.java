package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/19
 * description: 单调递增的数字
 */
public class MonotonicallyIncreasing {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int mark = digits.length;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                mark = i;
            }
        }
        for (int i = mark; i < digits.length; i++) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }
}
