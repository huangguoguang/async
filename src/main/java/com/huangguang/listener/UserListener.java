package com.huangguang.listener;

import com.huangguang.entiy.UserBean;
import com.huangguang.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description: 监听类
 * User : huangguang
 * DATE : 2017-11-22 14:04
 */
@Component
public class UserListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("myexecutor")
    @EventListener
    public void register(ApplicationEvent event) throws InterruptedException {
        if (event instanceof UserRegisterEvent) {
            logger.info("监听到请求时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            UserRegisterEvent userRegisterEvent = (UserRegisterEvent) event;
            UserBean userBean = userRegisterEvent.getUserBean();
            Thread.sleep(60000);
            logger.info("监听到:" + userBean.getUsername() + "  " + userBean.getAge());
        }
    }

}
