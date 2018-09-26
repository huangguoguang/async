package com.huangguang.listener;

import com.huangguang.event.ThirdEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-25 16:17
 */
@Component
public class ThirdListener {
    private static Logger logger = LoggerFactory.getLogger(ThirdListener.class);
    @EventListener
    @Async("thirdExecutor")
    public void third(Object event) throws InterruptedException {
        if (event instanceof ThirdEvent) {
            logger.info("third start :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
            Thread.sleep(10000);
            logger.info("third end :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        }
    }
}
