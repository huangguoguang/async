package com.huangguang.controller;

import com.huangguang.entiy.UserBean;
import com.huangguang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 14:25
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "user")
    public String register() {
        UserBean userBean = new UserBean();
        userBean.setAge(15);
        userBean.setUsername("张三");
        userService.register(userBean);
        return "注册成功";
    }

    @RequestMapping(value = "withdraw")
    public void withdraw() {
        for(int i = 0; i< 10;i++) {
            logger.info("=============" + i);
            userService.doWithdraw(i);
        }
    }
}
