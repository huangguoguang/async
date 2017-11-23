package com.huangguang.controller;

import com.huangguang.TestTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 10:48
 */
@RestController
@RequestMapping(value = "test")
public class AsyncController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TestTask testTask;

    @RequestMapping(value = "aysnc")
    public String testAsync() throws InterruptedException, ExecutionException {
        testTask.task1();
        testTask.task2();
        Future<String> result = testTask.task3();
        while (true) {
            if (result.isDone()) {
                logger.info(result.get());
                break;
            }
        }
        return "success";
    }

}
