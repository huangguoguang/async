package com.huangguang.event;

import com.huangguang.entiy.UserBean;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description: 定义事件
 * User : huangguang
 * DATE : 2017-11-22 14:05
 */
public class UserRegisterEvent extends ApplicationEvent{

    //在Spring内部中有多种方式实现监听如：
    // @EventListener注解、
    // 实现ApplicationListener泛型接口、
    // 实现SmartApplicationListener接口等，
    private UserBean userBean;

    public UserRegisterEvent(Object source, UserBean userBean) {
        super(source);
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
