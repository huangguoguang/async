package com.huangguang.listener;

import com.huangguang.entiy.UserBean;
import com.huangguang.event.UserRegisterEvent;
import com.huangguang.event.WithdrawEvent;
import com.huangguang.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-19 15:14
 */
@Component
public class WithdrawListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawListener.class);

    @Async("secondExecutor")
    @EventListener
    public void register(ApplicationEvent event) throws InterruptedException {
        if (event instanceof WithdrawEvent) {
            WithdrawEvent withdrawEvent = (WithdrawEvent) event;
            LOGGER.info("监听到请求时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + withdrawEvent.getIndex());
            String result = HttpClientUtil.httpPost("http://192.168.0.213:8889/refund/testwithdrawal", new HashMap<>());
            LOGGER.info("监听到完成时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + withdrawEvent.getIndex());
        }
    }
}
