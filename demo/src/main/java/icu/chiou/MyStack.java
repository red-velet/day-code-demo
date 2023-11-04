package icu.chiou;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * author: chiou
 * createTime: 2023/11/4
 * description:
 */
public class MyStack {
    //栈 - 先进后出
    //1 2 3 4  = 4 3 2 1
    //栈 - 先进先出
    //1 2 3 4
    //1
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    int size = 0;


    public void push(Integer num) {
        queue1.add(num);
        size++;
    }

    public Integer pop() {
        //
        int index = 1;
        while (index < size) {
            Integer poll = queue1.poll();
            queue2.add(poll);
            index++;
        }
        Integer res = queue1.poll();
        size--;
        queue1 = queue2;
        return res;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }
}
