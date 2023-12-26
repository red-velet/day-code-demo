package greedy;

import java.util.Arrays;

/**
 * author: redvelet
 * createTime: 2023/12/26
 * description: 分发饼干
 */
public class HandOutCookies {
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j，都有一个尺寸 s[j] 。
     * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     */
    public int findContentChildren(int[] g, int[] s) {
        //局部最优 --> 全局最优：用大容量的饼干去满足大胃口的孩子，这样得到所有满足孩子的值
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0; i--) {
            if (s[j] >= g[i]) {
                j--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HandOutCookies example = new HandOutCookies();
        int result = example.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println("result = " + result);
    }
}
