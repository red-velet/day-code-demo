package icu.chiou;

/**
 * author: chiou
 * createTime: 2023/11/3
 * description:
 */
public class ThreadDemo {
    private static Object MONITOR1 = new Object();
    private static Object MONITOR2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (MONITOR1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "持有MONITOR1,想要访问MONITOR2");
                synchronized (MONITOR2) {
                    System.out.println(Thread.currentThread().getName() + "持有MONITOR1,MONITOR2");
                }
            }
        }, "thread1").start();
        new Thread(() -> {
            synchronized (MONITOR2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "持有MONITOR2,想要访问MONITOR1");
                synchronized (MONITOR1) {
                    System.out.println(Thread.currentThread().getName() + "持有MONITOR1,MONITOR2");
                }
            }
        }, "thread2").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
