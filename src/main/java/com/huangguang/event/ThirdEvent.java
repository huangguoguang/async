package com.huangguang.event;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-25 16:17
 */
public class ThirdEvent extends ApplicationEvent{
    public ThirdEvent(Object source) {
        super(source);
    }
}
