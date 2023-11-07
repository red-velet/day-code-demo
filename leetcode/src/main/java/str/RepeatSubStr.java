package str;

/**
 * author: chiou
 * createTime: 2023/11/7
 * description: 字符串能否由重复的子串构成
 */
public class RepeatSubStr {
    public boolean repeatedSubstringPattern(String s) {
        //思路：两个字符串想加，去除前面的头，去除后面的尾，如果前面的尾+后面的头包含在s，那么就是
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        boolean res = new RepeatSubStr().repeatedSubstringPattern("ababab");
        System.out.println("res = " + res);
    }
}
