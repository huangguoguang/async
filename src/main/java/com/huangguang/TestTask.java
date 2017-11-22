package com.huangguang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 10:49
 */
@Component
public class TestTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Async
    public void task1() throws InterruptedException {
        logger.info("执行任务1");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        logger.info("任务1执行完成，用时" + (end - start));
    }

    @Async
    public void task2() throws InterruptedException {
        logger.info("执行任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        logger.info("任务2执行完成，用时" + (end - start));
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        logger.info("执行任务3");
        long start = System.currentTimeMillis();
        Thread.sleep(20000);
        long end = System.currentTimeMillis();
        logger.info("任务3执行完成，用时" + (end - start));
        return new AsyncResult<>("task3 completed");
    }
}
