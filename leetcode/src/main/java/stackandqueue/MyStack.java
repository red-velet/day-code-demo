package stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * author: chiou
 * createTime: 2023/11/9
 * description: 使用队列实现栈
 */
public class MyStack {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public MyStack() {
    }

    //队列是先进先出 -> 先进后出、后进先出的栈
    //插入默认插入，取出则取出除了最后一个的所有再重新插入
    public void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("myQueue.pop() = " + stack.pop());
        System.out.println("myQueue.pop() = " + stack.pop());
        System.out.println("myQueue.pop() = " + stack.pop());
        System.out.println("myQueue.pop() = " + stack.pop());
    }
}
