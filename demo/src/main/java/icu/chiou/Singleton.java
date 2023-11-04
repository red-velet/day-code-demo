package icu.chiou;

/**
 * author: chiou
 * createTime: 2023/11/3
 * description:
 */
public class Singleton {
    //todo 懒汉式 定义成员变量、私有化构造器、提供公共方法
    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
