package icu.chiou;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description: 代码demo测试
 */
public class Main {
    public static void main(String[] args) {
        float a = 3.14f;
        double b = 3.14;
        System.out.println(b == a);
        System.out.println(f(2));
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        new HashMap<>()
    }

    public static int f(int value) {
        try {
            return value += 10;
        } finally {
            return value + 4;
        }
    }

}
