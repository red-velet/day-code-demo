package str;

import java.util.ArrayList;
import java.util.Collections;

/**
 * author: chiou
 * createTime: 2023/11/5
 * description: 反转字符串
 */
public class ReverseString {
    //反转字符串
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    //反转字符串Ⅱ
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2 * k) {
            int remain = charArray.length - i;
            if (k <= remain) {
                reverse(charArray, i, i + k - 1);
            } else {
                reverse(charArray, i, charArray.length - 1);
            }

        }
        return new String(charArray);
    }

    public void reverse(char[] str, int l, int r) {

        while (l < r) {
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
    }

    //反转字符串中的单词
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        int start = 0;
        //找到每一个单词记录
        StringBuilder builder = new StringBuilder();
        while (start < charArray.length) {
            if (charArray[start] != ' ') {
                builder.append(charArray[start]);
            } else {
                if (builder.length() > 0) {
                    res.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            start++;
        }
        res.add(builder.toString());
        Collections.reverse(res);
        builder = new StringBuilder();
        for (String str : res) {
            builder.append(str).append(" ");
        }
        return builder.toString().trim();
    }


    public static void main(String[] args) {
        String res = new ReverseString().reverseStr("abcdefg", 2);
        System.out.println("res = " + res);

        res = new ReverseString().reverseWords("hello,i am mi  fans  ");
        System.out.println("res = " + res);
    }
}
