package com.huangguang.service.impl;

import com.huangguang.entiy.UserBean;
import com.huangguang.event.UserRegisterEvent;
import com.huangguang.event.WithdrawEvent;
import com.huangguang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2017-11-22 14:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationContext context;
    @Override
    public void register(UserBean userBean) {
        //发布事件
        context.publishEvent(new UserRegisterEvent(this, userBean));
    }

    @Override
    public void doWithdraw(Integer index) {
        context.publishEvent(new WithdrawEvent(this, index));
    }
}
