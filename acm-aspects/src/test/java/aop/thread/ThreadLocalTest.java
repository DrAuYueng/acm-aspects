package aop.thread;

import java.util.concurrent.ConcurrentSkipListSet;

public class ThreadLocalTest {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    private static final ConcurrentSkipListSet<String> SET = new ConcurrentSkipListSet<>();

    public static void foo1() {
        System.out.println(THREAD_LOCAL.get());
        THREAD_LOCAL.set("THREAD_LOCAL foo1," + Thread.currentThread().getName());
        SET.clear();
        SET.add("foo1_," + Thread.currentThread().getName());
    }

    public static void foo2() {
        System.out.println(THREAD_LOCAL.get());
        System.out.println(SET.first());
        THREAD_LOCAL.set("THREAD_LOCAL foo2," + Thread.currentThread().getName());
        SET.clear();
        SET.add("foo2_," + Thread.currentThread().getName());
    }

    public static void foo3() {
        System.out.println(THREAD_LOCAL.get());
        System.out.println(SET.first());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                ThreadLocalTest.foo1();
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block

                }
                ThreadLocalTest.foo2();
                ThreadLocalTest.foo3();
            }
        });
        t1.setName("thread-t1");
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block

                }
                ThreadLocalTest.foo2();
                ThreadLocalTest.foo3();
            }
        });
        t2.setName("thread-t2");
        t1.start();
        t2.start();
    }

}
