package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2023/12/25
 * description:
 */
public class Main {
    class Demo {
        int val = 0;
        String name = "jack";
    }

    private void dontStop() {
        List<Demo> list = new ArrayList<>();
        while (true) {
            Demo demo = new Demo();
            list.add(demo);
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        Main oom = new Main();
        int a = 1;
        int b = a;
        a = 3;
        System.out.println(a);
        System.out.println(b);
        ArrayList<Object> objects = new ArrayList<>();
        HashSet<Object> objects1 = new HashSet<>();
        objects1.add(1);
    }
}
