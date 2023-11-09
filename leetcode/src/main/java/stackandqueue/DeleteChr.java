package stackandqueue;

import java.util.Stack;

/**
 * author: chiou
 * createTime: 2023/11/9
 * description: 删除字符串相邻重复项
 */
public class DeleteChr {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
            } else {
                //比较当前指针元素和栈顶元素是否相等
                if (array[i] != stack.peek()) {
                    stack.push(array[i]);
                } else {
                    //相等弹出
                    Character c = stack.pop();
//                    for (int j = i + 1; j < array.length; j++) {
//                        if (c == array[j]) {
//                            i++;
//                        } else {
//                            break;
//                        }
//                    }
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
        String res = new DeleteChr().removeDuplicates("abbaca");
        System.out.println("res = " + res);
    }
}
