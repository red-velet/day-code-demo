package greedy;

/**
 * author: redvelet
 * createTime: 2024/1/18
 * description: 柠檬水找零
 */
public class ChangeForLemonade {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollars = 0;
        int tenDollars = 0;
        int twentyDollars = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveDollars++;
            }
            if (bill == 10) {
                if (fiveDollars == 0) {
                    return false;
                } else {
                    tenDollars++;
                    fiveDollars--;
                }
            }
            if (bill == 20) {
                if (tenDollars > 0 && fiveDollars > 0) {
                    twentyDollars++;
                    tenDollars--;
                    fiveDollars--;
                } else if (fiveDollars >= 3) {
                    twentyDollars++;
                    fiveDollars -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
