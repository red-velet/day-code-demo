package stackandqueue;

import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/9
 * description: 逆波兰表达式
 */
public class AntiPolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                stack.push(n2 + n1);
            } else if (tokens[i].equals("-")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                stack.push(n2 - n1);
            } else if (tokens[i].equals("*")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                stack.push(n2 * n1);
            } else if (tokens[i].equals("/")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int res = new AntiPolish().evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println("res = " + res);
    }
}
