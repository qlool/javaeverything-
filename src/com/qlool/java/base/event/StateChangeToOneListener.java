package com.qlool.java.base.event;

import java.util.EventListener;

/**
 * @Author: cxn
 * @Description: (事件.事件监听器)
 * @Date: Created in 17:25 2018/5/22
 * @Modified by:
 */
public class StateChangeToOneListener implements EventListener {

    public void handleEvent(MyEvent event) {
        System.out.println("触发状态变为1的事件。。。");
        System.out.println("当前事件源状态为：" + event.getSourceState());
        System.out.println("。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
