package stackandqueue;

import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/9
 * description: 有效的括号
 */
public class Parenthesis {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        //{()[]}
        for (char value : array) {
            if (value == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (c != '[') {
                    return false;
                }
            } else if (value == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (c != '{') {
                    return false;
                }
            } else if (value == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (c != '(') {
                    return false;
                }
            } else {
                stack.push(value);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Parenthesis().isValid("]");
        System.out.println("valid = " + valid);
    }
}

