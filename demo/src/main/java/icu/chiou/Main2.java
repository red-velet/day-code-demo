package icu.chiou;

import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/4
 * description:
 */
public class Main2 {

    public static String get(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                Character peek = stack.peek();
                if (peek.equals(chars[i])) {
                    int index = i + 1;
                    //abcccbef
                    Character num = stack.pop();
                    for (int j = index; j < chars.length; j++) {
                        if (num.equals(chars[j])) {
                            i++;
                        } else {
                            break;
                        }
                    }
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = Main2.get("abcccdp");
        System.out.println("s = " + s);
    }
}
