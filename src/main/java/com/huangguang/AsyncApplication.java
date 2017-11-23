package com.huangguang;

import com.huangguang.entiy.UserBean;
import com.huangguang.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsyncApplication {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ApplicationContext context;
	private int num = 1;
	private int cron = 100;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

	@Scheduled(cron = "0 0/1 15 * * ?")
	public void testSchedule() {
		UserBean userBean = new UserBean();
		userBean.setUsername("李四");
		userBean.setAge(cron);
		logger.info("发起请求时间：" + sdf.format(new Date()) + "   " + cron);
		context.publishEvent(new UserRegisterEvent(cron, userBean));
		logger.info("结束请求时间：" + sdf.format(new Date()) + "   " + cron);
		cron++;
	}

	@Scheduled(fixedDelay = 10000)
	public void testFixedDelay() {
		UserBean userBean = new UserBean();
		userBean.setUsername("王五");
		userBean.setAge(num);
		logger.info("发起请求时间：" + sdf.format(new Date()) + "   " + num);
		context.publishEvent(new UserRegisterEvent(num, userBean));
		logger.info("结束请求时间：" + sdf.format(new Date()) + "   " + num);
		num++;
	}
}
