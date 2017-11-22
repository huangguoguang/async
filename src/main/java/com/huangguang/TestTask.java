package com.huangguang;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 10:49
 */
@Component
public class TestTask {
    @Async
    public void task1() throws InterruptedException {
        System.out.println("执行任务1");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("任务1执行完成，用时" + (end - start));
    }

    @Async
    public void task2() throws InterruptedException {
        System.out.println("执行任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(50000);
        long end = System.currentTimeMillis();
        System.out.println("任务2执行完成，用时" + (end - start));
    }

    @Async
    public void task3() throws InterruptedException {
        System.out.println("执行任务3");
        long start = System.currentTimeMillis();
        Thread.sleep(80000);
        long end = System.currentTimeMillis();
        System.out.println("任务3执行完成，用时" + (end - start));
    }
}
