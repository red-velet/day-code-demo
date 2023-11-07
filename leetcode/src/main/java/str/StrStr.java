package str;

/**
 * author: chiou
 * createTime: 2023/11/6
 * description: 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    //暴力匹配
    public int strStr(String haystack, String needle) {
        char[] src = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (i < src.length && j < target.length) {
            if (src[i] == target[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == target.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    //kmp
    public int strStrKmp(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (haystack.charAt(j) == needle.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String pattern) {
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        int res = new StrStr().strStr("satbutsad", "sad");
        System.out.println("res = " + res);
    }
}
