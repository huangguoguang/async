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
	private int age = 1;
	private int cron = 100;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}


	/**
	 * cron表达式可以定制化执行任务，但是执行的方式是与fixedDelay相近的，也是会按照上一次方法结束时间开始算起。
	 */
	@Scheduled(cron = "0 16 14 * * ?")
	public void testSchedule() {
		UserBean userBean = new UserBean();
		userBean.setUsername("李四");
		userBean.setAge(cron);
		for (int i =0; i< 100; i++) {
			context.publishEvent(new UserRegisterEvent(cron, userBean));
			cron++;
		}
	}

	/**
	 * fixedDelay控制方法执行的间隔时间，是以上一次方法执行完开始算起，
	 * 如上一次方法执行阻塞住了，那么直到上一次执行完，并间隔给定的时间后，执行下一次。
	 */
//	@Scheduled(fixedDelay = 10000)
//	public void testFixedDelay() {
//		UserBean userBean = new UserBean();
//		userBean.setUsername("王五");
//		userBean.setAge(num);
//		logger.info("王五发起请求时间：" + sdf.format(new Date()) + "   " + num);
//		context.publishEvent(new UserRegisterEvent(num, userBean));
//		logger.info("王五结束请求时间：" + sdf.format(new Date()) + "   " + num);
//		num++;
//	}

	/**
	 * fixedRate控制方法执行的间隔时间，
	 * 以下方法将以一个固定速率10s来调用一次执行，这个周期是以上一个任务开始时间为基准，从上一任务开始执行后10s再次调用
	 */
//	@Scheduled(fixedRate = 10000)
//	public void testFixedRate() throws InterruptedException {
//		UserBean userBean = new UserBean();
//		userBean.setUsername("赵六");
//		userBean.setAge(age);
//		logger.info("赵六发起请求时间：" + sdf.format(new Date()) + "   " + age);
//		context.publishEvent(new UserRegisterEvent(age, userBean));
//		logger.info("赵六结束请求时间：" + sdf.format(new Date()) + "   " + age);
//		age++;
//	}
}
