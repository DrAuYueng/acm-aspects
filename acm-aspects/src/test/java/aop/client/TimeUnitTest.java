package aop.client;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest {

    public static void main(String[] args) {
        long started = System.currentTimeMillis();
        final TimeUnit unit = TimeUnit.MILLISECONDS;
        final long threshold = 1000l;
        try {
            Thread.sleep(threshold);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block

        }
        final long age = unit.convert(System.currentTimeMillis() - started, TimeUnit.MILLISECONDS);
        final int cycle = (int) ((age - threshold) / threshold);
        System.out.println("age:" + age);
        System.out.println("cycle:" + cycle);
    }

}
