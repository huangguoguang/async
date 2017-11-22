package com.huangguang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private TestTask testTask;

    @RequestMapping(value = "aysnc")
    public String testAsync() throws InterruptedException {
        testTask.task1();
        testTask.task2();
        testTask.task3();
        return "success";
    }
}
