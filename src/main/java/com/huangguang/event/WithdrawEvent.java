package com.huangguang.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-19 15:13
 */
public class WithdrawEvent extends ApplicationEvent {
    private Integer index;


    public WithdrawEvent(Object source) {
        super(source);
    }

    public WithdrawEvent(Object source, Integer index) {
        super(source);
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
