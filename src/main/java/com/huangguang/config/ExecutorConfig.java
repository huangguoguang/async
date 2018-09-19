package com.huangguang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 13:54
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean
    public ThreadPoolTaskExecutor myexecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(1000);
        executor.initialize();
        return executor;
    }

    @Bean
    public ThreadPoolTaskExecutor secondExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(1000);
        executor.initialize();
        return executor;
    }
}